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
        String dir = cmd[0];
        int num = Integer.parseInt(cmd[1]);
        for (int i = 0; i < num; i++) {
            moveHead(dir);
            followHead();
            markVisited();
        }
    }

    public int getVisitedCount() {
        return this.visited.size();
    }

    public String toString() {
        return visited.toString();
    }

    private void moveHead(String dir) {
        this.rope[0].move(dir);
    }

    private void followHead() {
        for (int i = 1; i < this.rope.length; i++) {
            this.rope[i].follow(this.rope[i - 1]);
        }
    }

    private void markVisited() {
        this.visited.add(this.printTail());
    }

    private String printTail() {
        return this.rope[this.rope.length - 1].toString();
    }
}
