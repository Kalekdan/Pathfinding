package main.java.com.pixolestudios.pathf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pathfinder {
    public Pathfinder(Map maze, Node destinationNode, Node startNode) {
        System.out.println(maze);
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(startNode);
        boolean atDestination = false;
        for (int i = 0; i < queue.size(); i++) {
            if (atDestination) {
                break;
            }
            List<Node> neighbourArr = maze.makeNeighbours(queue.get(i));
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

        // Update map with distances
        for (Node node : queue) {
            if (!node.equalsCoords(destinationNode) && !node.equalsCoords(startNode)) {
                maze.setCell(node.getxCoord(), node.getyCoord(), String.valueOf(node.getCounter()));
            }
        }
        System.out.println(maze);

        // Trace through distances for shortest path
        Node stepThroughNode = destinationNode;
        boolean complete = false;
        while (!complete) {
            complete = stepThroughNode.equalsCoords(startNode);
            System.out.println(stepThroughNode);
            stepThroughNode = Node.getLowestDistanceNode(maze.getNeighbours(stepThroughNode));
        }
    }
}

