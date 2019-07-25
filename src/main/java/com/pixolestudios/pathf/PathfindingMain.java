package main.java.com.pixolestudios.pathf;

@SuppressWarnings("MagicNumber")
public class PathfindingMain {
    private PathfindingMain() {
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Map maze = new Map();

        Pathfinder pathfinder = new Pathfinder(maze, new Node(1, 4, 0), new Node(15, 14, 1));
    }
}
