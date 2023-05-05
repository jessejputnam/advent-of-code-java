import java.util.HashSet;

public class Bridge {
    private HashSet<String> visited;
    private Head head;
    private Tail tail;

    public Bridge() {
        this.visited = new HashSet<>();
        this.head = new Head();
        this.tail = new Tail();
        this.visited.add(tail.toString());
    }

    public String printHead() {
        return this.head.toString();
    }

    public String printTail() {
        return this.tail.toString();
    }

    public void exec(String[] cmd) {
        String dir = cmd[0];
        int num = Integer.parseInt(cmd[1]);

        while (num > 0) {
            this.head.move(dir);
            this.tail.follow(this.head);
            this.markVisited();
            num--;
        }
    }

    public void markVisited() {
        if (this.visited.contains(this.tail.toString()))
            return;

        this.visited.add(this.tail.toString());
    }

    public int getVisitedCount() {
        return this.visited.size();
    }

    public String toString() {
        return visited.toString();
    }
}
