package main.java.com.pixolestudios.pathf;

import java.util.ArrayList;

public class Map {
    private String[][] map =
            {//       1    2    3    4    5    6    7    8
                    {" ", " ", " ", "#", "#", " ", "#", " "},// 1
                    {" ", "#", " ", " ", "#", " ", " ", " "},// 2
                    {"S", "#", "#", " ", " ", " ", "#", " "},// 3
                    {" ", "#", " ", " ", "#", " ", " ", " "},// 4
                    {" ", " ", " ", "#", "#", " ", "#", " "},// 5
                    {" ", "#", " ", " ", "#", " ", "#", " "},// 6
                    {" ", "#", "#", " ", " ", " ", "#", " "},// 7
                    {" ", " ", "O", " ", "#", " ", " ", " "},// 8
            };

    /**
     * Returns false if cell is wall OR out of bounds
     *
     * @param x
     * @param y
     * @return
     */
    protected boolean cellIsWall(int x, int y) {
        if (!cellInBounds(y, x)) {
            return true;
        }
        if (map[y - 1][x - 1] == "#") {
            return true;
        }
        return false;
    }

    private boolean cellInBounds(int y, int x) {
        try {
            map[y - 1][x - 1] = map[y - 1][x - 1];
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public ArrayList<Node> getNeighbours(Node node) { //TODO make sure is bounds
        ArrayList<Node> toReturn = new ArrayList<>();

        toReturn.add(new Node(node.getxCoord() - 1, node.getyCoord(), node.getCounter() + 1));
        toReturn.add(new Node(node.getxCoord(), node.getyCoord() - 1, node.getCounter() + 1));
        toReturn.add(new Node(node.getxCoord() + 1, node.getyCoord(), node.getCounter() + 1));
        toReturn.add(new Node(node.getxCoord(), node.getyCoord() + 1, node.getCounter() + 1));

        return toReturn;
    }

    protected String getCell(int x, int y) {
        return map[y - 1][x - 1];
    }

    protected void setCell(int x, int y, String val) {
        map[y - 1][x - 1] = val;
    }

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                toReturn.append(map[i][j]).append("|");
            }
            toReturn.append("\n");

        }


        return toReturn.toString();
    }
}

