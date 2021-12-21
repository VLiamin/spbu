package ru.liamin.vladimir;

import jade.core.Agent;

import java.util.HashSet;
import java.util.Set;

public class MyAgent extends Agent {
    private int number;
    private final Set<String> links = new HashSet<>();

    @Override
    protected void setup() {
        super.setup();

        Object[] args = getArguments();

        if (args != null && args.length > 0) {
            number = Integer.parseInt(args[0].toString());

            System.out.println(this.getLocalName() + ": " + number);

            for (int i = 2; i < args.length; i++) {
                links.add(args[i].toString());
            }
        }

        addBehaviour(new MyBehavior(this, args[1].toString(), args.length - 1));
    }

    public int getNumber() {
        return number;
    }

    public Set<String> getNeighbors() {
        return links;
    }

    @Override
    protected void takeDown() {
        super.takeDown();

        System.out.println("Done");
    }
}
