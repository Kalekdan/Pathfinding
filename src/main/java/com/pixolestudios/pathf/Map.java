package main.java.com.pixolestudios.pathf;

import java.util.ArrayList;

public class Map {
    private char[][] map =
            {//       1    2    3    4    5    6    7    8    9   10   11
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},// 1
                    {'#', 'S', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},// 2
                    {'#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#'},// 3
                    {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},// 4
                    {'#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#'},// 5
                    {'#', '#', ' ', ' ', '#', '#', '#', '#', ' ', ' ', '#'},// 6
                    {'#', '#', ' ', ' ', '#', '#', '#', '#', ' ', ' ', '#'},// 7
                    {'#', '#', ' ', ' ', '#', '#', ' ', ' ', ' ', ' ', '#'},// 8
                    {'#', ' ', ' ', ' ', '#', '#', '#', ' ', 'O', ' ', '#'},// 9
                    {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#'},// 10
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'} // 11
            };

    /**
     * Returns false if cell is wall OR out of bounds
     * @param x
     * @param y
     * @return
     */
    protected boolean cellIsWall(int x, int y) {
        if (!cellInBounds(y, x)) {
            return true;
        }
        if (map[y - 1][x - 1] == '#') {
            return true;
        }
        return false;
    }

    private boolean cellInBounds(int y, int x) {
        try {
            map[y-1][x-1] = map[y-1][x-1];
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public ArrayList<Node> getNeighbours(Node node) {
        ArrayList<Node> toReturn = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                System.out.println(map[node.getyCoord() + i-1][node.getxCoord() + j-1]);
                toReturn.add(new Node(node.getyCoord() + i-1, node.getxCoord() + j-1, node.getCounter() + 1));
            }
        }
        return toReturn;
    }
}

