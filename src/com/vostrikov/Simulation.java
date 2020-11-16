package com.vostrikov;

public class Simulation {

    int width;
    int height;
    int[][] board;

    public Simulation(int width, int height) {
        this.width  = width;
        this.height = height;
        this.board  = new int[width][height];
    }

    public void printBoard() {
        System.out.println("---");
        for (int y = 0; y < height; y++) {
            String line = "|";
            for (int x = 0; x < width; x++) {
                if (this.board[x][y] == 0) line += ".";
                else line += "*";
            }
            line += "|";
            System.out.println(line);
        }
        System.out.println("---\n");
    }

    public void setAlive(int x, int y) {
        this.board[x][y] = 1;
    }

    public void setDead(int x, int y) {
        this.board[x][y] = 0;
    }

    public int countAliveNeighbours(int x, int y) {
        int count = 0;

        //over
        count += getState(x - 1, y - 1);
        count += getState(x,y - 1);
        count += getState(x + 1, y - 1);

        //left, right
        count += getState(x - 1, y);
        count += getState(x + 1, y);

        //under
        count += getState(x - 1, y + 1);
        count += getState(x, y + 1);
        count += getState(x + 1, y + 1);

        return  count;
    }

    public int getState(int x, int y) {
        if ((x < 0 || x >= width) || (y < 0 || y >= height)) return 0;

        return this.board[x][y];
    }

    public void step() {

        int[][] newBoard = new int[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int aliveNeighbours = countAliveNeighbours(x, y);

                if (getState(x, y) == 1) {
                    if (aliveNeighbours < 2 || aliveNeighbours > 3) newBoard[x][y] = 0;
                    else newBoard[x][y] = 1;

                } else {
                    if (aliveNeighbours == 3) newBoard[x][y] = 1;
                }


            }
        }
        this.board = newBoard;
    }

//    public static void main(String[] args) {
//        Simulation simulation = new Simulation(8, 8);
//
//        simulation.setAlive(1, 0);
//        simulation.setAlive(2, 1);
//        simulation.setAlive(0, 2);
//        simulation.setAlive(1, 2);
//        simulation.setAlive(2, 2);
//
//        simulation.printBoard();
//
//        for (int i = 0; i < 10; i++) {
//            simulation.step();
//            simulation.printBoard();
//        }
//
//    }

}
