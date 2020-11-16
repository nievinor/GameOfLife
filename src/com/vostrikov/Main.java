package com.vostrikov;

public class Main {

    public static void main(String[] args) {

        Simulation simulation = new Simulation(8, 8);

        simulation.setAlive(1, 0);
        simulation.setAlive(2, 1);
        simulation.setAlive(0, 2);
        simulation.setAlive(1, 2);
        simulation.setAlive(2, 2);

        simulation.printBoard();

        for (int i = 0; i < 10; i++) {
            simulation.step();
            simulation.printBoard();
        }

    }
}

