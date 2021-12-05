package ru.liamin.vladimir;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class MyBehavior extends Behaviour {
    private boolean isMain;
    private List<String> neighbors;
    private int number;
    Map<String, Integer> map;
    private boolean isFirstStage = true;
    private String nameOfSender;
    private int counter;
    private ACLMessage response;
    private ACLMessage request;
    private boolean isAlive = false;
    private String mainAgent;
    private String previousSender;

    public MyBehavior(int number, boolean isMain, List<String> neighbors, String mainAgent) {
        super();
        this.neighbors = neighbors;
        this.isMain = isMain;
        this.number = number;
        this.mainAgent = mainAgent;
        map = new HashMap<>();
        response = new ACLMessage(ACLMessage.INFORM);
        if (!isMain && !(neighbors.size() == 1)) {
            neighbors.remove(mainAgent);
        }
    }

    @Override
    public void action() {
        if (isMain && isFirstStage) {
            map.put(myAgent.getLocalName(), number);
            for (int i = 0; i < neighbors.size(); i++) {
                response.addReceiver(new AID(neighbors.get(i), AID.ISGUID));
            }

            response.setContent("Numbers");
            myAgent.send(response);
            isFirstStage = false;
            block();
        }

        request = myAgent.receive();
        if (request != null && isFirstStage && request.getContent().equals("Numbers") && neighbors.size() == 1)  {
            workWithoutNeighbors();
        } else if (request != null && isFirstStage && request.getContent().equals("Numbers") && neighbors.size() != 0) {
            workWithNeighbors();
        }
        else if (request != null && !request.getContent().equals("Numbers")) {
            sendAnswer();
        } else if (request != null){

            String nameOfSender2 = request.getSender().getName();
            map.put(myAgent.getLocalName(), number);
            response.addReceiver(new AID(nameOfSender2, AID.ISGUID));
            try {
                response.setContentObject((Serializable) map);
            } catch (IOException e) {
                e.printStackTrace();
            }
            myAgent.send(response);
        }
        else {
            block();
        }
    }

    private void workWithoutNeighbors() {
        map.put(myAgent.getLocalName(), number);
        response.addReceiver(new AID(neighbors.get(0), AID.ISGUID));
        try {
            response.setContentObject((Serializable) map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        myAgent.send(response);
        isFirstStage = false;
        block();
    }

    private void workWithNeighbors() {
        isFirstStage = false;
        nameOfSender = request.getSender().getName();
        previousSender = nameOfSender;
        response = new ACLMessage(ACLMessage.INFORM);
        for (int i = 0; i < neighbors.size(); i++) {
            if (!neighbors.get(i).equals(nameOfSender)) {
                response.addReceiver(new AID(neighbors.get(i), AID.ISGUID));
            }
        }

        response.setContent("Numbers");
        myAgent.send(response);
        isFirstStage = false;
        block();
    }

    private void sendAnswer() {
        Set<String> names;
        try {
            Map<String, Integer> agents = (Map<String, Integer>) request.getContentObject();
            names = agents.keySet();

            for (String name : names) {
                map.put(name, agents.get(name));
            }
        } catch (UnreadableException e) {
            e.printStackTrace();
        }

        counter++;
        if (counter < neighbors.size() - 1 && !isMain
                || counter != neighbors.size() && isMain) {
            block();
            return;
        }

        if (isMain) {
            names = map.keySet();
            int number = 0;
            for (String name : names) {
                number += map.get(name);
                System.out.println("Name: " +  name);
            }
            System.out.println("Average value: " +  ((double) number / names.size()));

        } else {
            map.put(myAgent.getLocalName(), number);

            response = new ACLMessage(ACLMessage.INFORM);
            response.addReceiver(new AID(previousSender, AID.ISGUID));
            try {
                response.setContentObject((Serializable) map);
            } catch (IOException e) {
                e.printStackTrace();
            }
            myAgent.send(response);
        }

        block();
    }

    @Override
    public boolean done() {
        return isAlive;
    }
}
