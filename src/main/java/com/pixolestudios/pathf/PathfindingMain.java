package main.java.com.pixolestudios.pathf;

public class PathfindingMain {
    private PathfindingMain() {
    }

    public static void main(String[] args) {
        Map maze = new Map();

        Pathfinder pathfinder = new Pathfinder(maze, new Node(3, 8, 0), new Node(1, 3, 1));
    }
}
