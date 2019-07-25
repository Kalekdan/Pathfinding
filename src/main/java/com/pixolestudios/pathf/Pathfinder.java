package main.java.com.pixolestudios.pathf;

import java.util.ArrayList;

public class Pathfinder {
    private ArrayList<Node> queue = new ArrayList<>();

    private ArrayList<Node> neighbourArr = new ArrayList<>();

    private boolean atDestination = false;

    public Pathfinder(Map maze, Node startNode, Node destinationNode){
        queue.add(startNode);

        while (!atDestination){
            neighbourArr = maze.getNeighbours(startNode);
            for (int i = 0; i < neighbourArr.size(); i++) {
                if (maze.cellIsWall(neighbourArr.get(i).getxCoord(), neighbourArr.get(i).getyCoord())){
                    neighbourArr.remove(i);
                    continue;
                }
                for (Node queueNode : queue) {   // Check if coords are already in main queue
                    if (queueNode.equalsCoords(neighbourArr.get(i))) {
                        if (queueNode.getCounter() <= neighbourArr.get(i).getCounter()){
                            neighbourArr.remove(i);
                        }
                    }
                }
            }
            queue.addAll(neighbourArr);
            // If last element coords == destination coords, we have reached desitnationo
            if (queue.get(queue.size() - 1).equalsCoords(destinationNode)){
                atDestination = true;
            }
        }
        System.out.print(neighbourArr);
    }
}
