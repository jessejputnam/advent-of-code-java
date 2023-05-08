public class CPU {
    private int x;
    private int cycle;
    private Node recorded;

    private class Node {
        int val;
        Node next;
    }

    public CPU() {
        this.x = 1;
        this.cycle = 0;
        this.recorded = null;
    }

    public int getX() {
        return this.x;
    }

    public int getCycle() {
        return this.cycle;
    }

    public void printSignals() {
        String output = "[";
        for (Node n = this.recorded; n != null; n = n.next)
            output += n.next == null ? n.val + "]" : n.val + ", ";
        System.out.println(output);
    }

    public int sumSignals() {
        int sum = 0;
        for (Node n = this.recorded; n != null; n = n.next)
            sum += n.val;
        return sum;
    }

    public void parseCmd(String[] cmd) {
        if (cmd[0].equals("addx"))
            addx(Integer.valueOf(cmd[1]));
        else
            noop();
    }

    private void addx(int v) {
        this.cycle++;
        recordX();
        this.cycle++;
        recordX();
        this.x += v;
    }

    private void noop() {
        this.cycle++;
        recordX();
    }

    private void recordX() {
        if ((this.cycle - 20) % 40 != 0)
            return;

        Node node = new Node();
        node.val = this.x * this.cycle;

        Node n = this.recorded;
        while (n != null && n.next != null)
            n = n.next;

        if (n == null)
            this.recorded = node;
        else
            n.next = node;
    }
}
