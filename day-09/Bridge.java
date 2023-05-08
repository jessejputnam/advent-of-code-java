import java.util.HashSet;

public class Bridge {
    private HashSet<String> visited;
    private Knot[] rope;

    public Bridge(int ropeSize) {
        this.visited = new HashSet<>();
        this.rope = new Knot[ropeSize];
        for (int i = 0; i < ropeSize; i++)
            this.rope[i] = new Knot();
        this.visited.add(printTail());
    }

    public void exec(String[] cmd) {
        for (int i = 0; i < Integer.parseInt(cmd[1]); i++) {
            moveHead(cmd[0]);
            followHead();
            markVisited();
        }
    }

    public int getVisitedCount() {
        return this.visited.size();
    }

    public String toString() {
        return this.visited.toString();
    }

    private void moveHead(String dir) {
        head().move(dir);
    }

    private void followHead() {
        for (int i = 1; i < ropeSize(); i++) {
            this.rope[i].follow(this.rope[i - 1]);
        }
    }

    private void markVisited() {
        this.visited.add(this.printTail());
    }

    private String printTail() {
        return tail().toString();
    }

    private Knot tail() {
        return this.rope[ropeSize() - 1];
    }

    private Knot head() {
        return this.rope[0];
    }

    private int ropeSize() {
        return this.rope.length;
    }
}
