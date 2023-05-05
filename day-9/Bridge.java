import java.util.HashSet;

public class Bridge {
    private HashSet<String> visited;
    private Knot[] rope;
    public int moves;

    public Bridge(int ropeSize) {
        this.visited = new HashSet<>();
        this.rope = new Knot[ropeSize];
        for (int i = 0; i < ropeSize; i++)
            this.rope[i] = new Knot();
        this.visited.add(rope[ropeSize - 1].toString());
    }

    public String printHead() {
        return this.rope[0].toString();
    }

    public String printTail() {
        return this.rope[this.rope.length - 1].toString();
    }

    public void exec(String[] cmd) {
        String dir = cmd[0];
        int num = Integer.parseInt(cmd[1]);

        while (num > 0) {
            this.rope[0].move(dir);
            this.moves++;
            for (int i = 1; i < this.rope.length; i++)
                this.rope[i].follow(this.rope[i - 1]);
            this.markVisited();
            num--;
        }
    }

    public void markVisited() {
        if (this.visited.contains(this.rope[this.rope.length - 1].toString()))
            return;

        this.visited.add(this.rope[this.rope.length - 1].toString());
    }

    public int getVisitedCount() {
        return this.visited.size();
    }

    public String toString() {
        return visited.toString();
    }
}
