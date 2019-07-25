package main.java.com.pixolestudios.pathf;

import java.util.List;

public class Node {
    private int xCoord;
    private int yCoord;
    private int counter;

    public Node(int x, int y, int counter) {
        xCoord = x;
        yCoord = y;
        this.counter = counter;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public int getCounter() {
        return counter;
    }

    public boolean equalsCoords(Node other) {
        return other.getxCoord() == xCoord && other.getyCoord() == yCoord;
    }

    @Override
    public String toString() {
        return "(" + xCoord + "," + yCoord + "," + counter + ")";
    }

    /**
     * Returns the node with the lowest distance from an array of nodes
     * @param nodes array of nodes
     * @return node with lowest distance
     */
    protected static Node getLowestDistanceNode(List<Node> nodes){
        Node lowestDistNode = nodes.get(0);
        for (Node node : nodes) {
            if (node.getCounter() <= lowestDistNode.getCounter()) {
                lowestDistNode = node;
            }
        }
        return lowestDistNode;
    }
}
