package main.java.com.pixolestudios.pathf;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private String[][] map =
            {//       1    2    3    4    5    6    7    8    9   10   11   12   13   14   15
                    {" ", " ", " ", "#", "#", " ", "#", " ", " ", " ", "#", "#", " ", "#", " "},// 1
                    {" ", "#", " ", " ", "#", " ", " ", " ", "#", " ", " ", "#", " ", " ", " "},// 2
                    {" ", "#", "#", " ", " ", " ", "#", " ", "#", "#", " ", " ", " ", "#", " "},// 3
                    {"S", "#", " ", " ", "#", " ", "#", " ", "#", " ", " ", "#", " ", " ", " "},// 4
                    {" ", " ", " ", "#", "#", " ", "#", " ", " ", " ", "#", "#", " ", "#", " "},// 5
                    {" ", "#", " ", " ", "#", " ", "#", " ", "#", " ", " ", "#", " ", "#", " "},// 6
                    {" ", "#", "#", " ", " ", " ", "#", " ", "#", "#", " ", " ", " ", "#", " "},// 7
                    {" ", " ", " ", " ", "#", " ", "#", " ", " ", " ", " ", "#", " ", " ", " "},// 8
                    {" ", " ", " ", "#", "#", " ", "#", " ", " ", " ", "#", "#", " ", "#", " "},// 9
                    {" ", "#", " ", " ", "#", " ", "#", " ", "#", " ", " ", "#", " ", " ", " "},// 10
                    {" ", "#", "#", " ", " ", " ", "#", " ", "#", "#", " ", " ", " ", "#", " "},// 11
                    {" ", "#", " ", " ", "#", " ", "#", " ", "#", " ", " ", "#", " ", " ", " "},// 12
                    {" ", " ", " ", "#", "#", " ", "#", " ", " ", " ", "#", "#", " ", "#", " "},// 13
                    {" ", "#", " ", " ", "#", " ", "#", " ", "#", " ", " ", "#", " ", "#", "O"},// 14
                    {" ", "#", "#", " ", " ", " ", "#", " ", "#", "#", " ", " ", " ", "#", " "},// 15
                    {" ", " ", " ", " ", "#", " ", " ", " ", " ", " ", " ", "#", " ", " ", " "} // 16
            };

    /**
     * Returns true if cell is wall OR out of bounds
     *
     * @param x x coordinate
     * @param y y coordinate
     * @return true if cell is wall OR out of bounds, otherwise false
     */
    protected boolean cellIsWall(int x, int y) {
        if (!cellInBounds(y, x)) {
            return true;
        }
        return "#".equals(map[y - 1][x - 1]);
    }

    @SuppressWarnings("ProhibitedExceptionCaught")
    private boolean cellInBounds(int y, int x) {
        try {
            map[y - 1][x - 1] = map[y - 1][x - 1];
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public List<Node> getNeighbours(Node node) {
        List<Node> toReturn = new ArrayList<>();

        toReturn.add(new Node(node.getxCoord() - 1, node.getyCoord(), node.getCounter() + 1));
        toReturn.add(new Node(node.getxCoord(), node.getyCoord() - 1, node.getCounter() + 1));
        toReturn.add(new Node(node.getxCoord() + 1, node.getyCoord(), node.getCounter() + 1));
        toReturn.add(new Node(node.getxCoord(), node.getyCoord() + 1, node.getCounter() + 1));

        return toReturn;
    }

    protected void setCell(int x, int y, String val) {
        map[y - 1][x - 1] = val;
    }

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder();
        for (String[] line : map) {
            for (String element : line) {
                toReturn.append(element).append("\t");
            }
            toReturn.append("\n");
        }
        return toReturn.toString();
    }
}

