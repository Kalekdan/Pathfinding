package main.java.com.pixolestudios.pathf;

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
}
