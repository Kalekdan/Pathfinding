package main.java.com.pixolestudios.pathf;

import java.util.ArrayList;
import java.util.Iterator;

public class Pathfinder {
    private ArrayList<Node> queue = new ArrayList<>();

    private ArrayList<Node> neighbourArr = new ArrayList<>();

    private boolean atDestination = false;

    public Pathfinder(Map maze, Node startNode, Node destinationNode) {
        System.out.println(maze);

        queue.add(startNode);

        for (int i = 0; i < queue.size(); i++) {
            if (atDestination) {
                break;
            }
            neighbourArr = maze.getNeighbours(queue.get(i));
            // For each of the neighbours
            Iterator<Node> neighbourItr = neighbourArr.iterator();
            while (neighbourItr.hasNext()) {
                Node neighbour = neighbourItr.next();
                // If neightbour is wall remove from list
                if (maze.cellIsWall(neighbour.getxCoord(), neighbour.getyCoord())) {
                    neighbourItr.remove();
                }
                // If neighbour is already in main queue with lower/equal counter remove it
                for (Node queueNode : queue) {   // Check if coords are already in main queue
                    if (queueNode.equalsCoords(neighbour)) {
                        if (queueNode.getCounter() <= neighbour.getCounter()) {
                            neighbourItr.remove();
                        }
                    }
                }
            }
            queue.addAll(neighbourArr);
            // System.out.println("Queue: " + queue);
            // If last element coords == destination coords, we have reached desitnationo
            for (Node queueNode : queue) {
                if (queueNode.equalsCoords(destinationNode)) {
                    atDestination = true;
                }
            }
        }



        for (Node node: queue) {
            if (!node.equalsCoords(destinationNode) && !node.equalsCoords(startNode)){
                maze.setCell(node.getxCoord(), node.getyCoord(), String.valueOf(node.getCounter()));
            }
        }
        System.out.println(maze);
    }
}

