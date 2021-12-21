package ru.liamin.vladimir;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

import java.util.*;

public class MyBehavior extends Behaviour {

    public static final double a = 0.001;
    public static final double error = 0.01;
    public static final double probabilityBroken = 0.01;
    public static final double probabilityDelayed = 0.01;

    private String mainAgent;
    private double result;
    private int iterations;
    private boolean isAlive = false;
    private MyAgent agent;
    private Random random;
    public static int numberOfIterations;
    private ACLMessage message;

    MyBehavior(MyAgent agent, String mainAgent, int agents) {
        this.agent = agent;
        this.result = agent.getNumber();
        random = new Random();
        numberOfIterations = agents * 1000;
        this.mainAgent = mainAgent;
    }

    @Override
    public void action() {
        Set<String> neighbors = agent.getNeighbors();

        for (String neighbor : neighbors) {
            message = new ACLMessage();
            double error = random.nextDouble() / 100 * MyBehavior.error;
            message.addReceiver(new AID(neighbor, AID.ISLOCALNAME));
            message.setContent(String.valueOf(result + error));
            agent.send(message);
        }

        int received = 0;
        while (received < neighbors.size()) {
            message = agent.receive();
            received += 1;

            if (message != null) {
                if (random.nextFloat() <= probabilityBroken) {
                    continue;
                }

                if (random.nextFloat() <= probabilityDelayed) {
                    agent.send(message);
                    continue;
                }

                result += a * (Double.parseDouble(message.getContent()) - result);


            }
        }

        iterations += 1;

        if (iterations >= numberOfIterations - 2) {
            isAlive = true;
        }

        if (isAlive && agent.getLocalName().equals(mainAgent)) {
            System.out.println("Number: " + result);
        }
    }

    @Override
    public boolean done() {
        return isAlive;
    }
}
