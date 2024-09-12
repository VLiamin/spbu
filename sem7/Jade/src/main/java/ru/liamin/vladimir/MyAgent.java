package ru.liamin.vladimir;

import jade.core.Agent;

import java.util.ArrayList;
import java.util.List;

public class MyAgent extends Agent {
    private int number;

    @Override
    protected void setup() {
        super.setup();

        Object[] args = getArguments();
        //number = Integer.parseInt(args[0].toString());
       // System.out.println(number);
        List<String> neighbors = new ArrayList<>();
        for (int i = 2; i < args.length; i++) {
            neighbors.add(args[i].toString() + "@192.168.56.1:9999/JADE");
        }
        System.out.println("Hello! Buyer-agent "+getAID().getName()+" is ready. Number: " + Integer.parseInt(args[0].toString()));

        if (getAID().getLocalName().equals(args[1].toString())) {
            addBehaviour(new MyBehavior(Integer.parseInt(args[0].toString()), true, neighbors, args[1].toString()));
        } else {
            addBehaviour(new MyBehavior(Integer.parseInt(args[0].toString()),false, neighbors, args[1].toString()));
        }

    }

    @Override
    protected void takeDown() {
        super.takeDown();

        System.out.println("Done");
    }
}
