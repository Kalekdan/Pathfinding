package main.java.com.pixolestudios.pathf;

public class PathfindingMain {
    private PathfindingMain() {
    }

    public static void main(String[] args) {
        Map maze = new Map();

        Pathfinder pathfinder = new Pathfinder(maze, new Node(3, 2, 0), new Node(5, 3, 1));
    }
}
