public class CPU {
    private int x;
    private int cycle;
    private Node recorded;
    private CRT crt;

    private class Node {
        int val;
        Node next;
    }

    public CPU() {
        this.x = 1;
        this.cycle = 0;
        this.recorded = null;
        this.crt = new CRT();
    }

    public void parseCmd(String[] cmd) {
        if (cmd[0].equals("addx"))
            addx(Integer.valueOf(cmd[1]));
        else
            noop();
    }

    public int getX() {
        return this.x;
    }

    public int getCycle() {
        return this.cycle;
    }

    public void printScreen() {
        this.crt.printScreen();
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

    private void addx(int v) {
        for (int i = 0; i < 2; i++) {
            this.cycle++;
            getSignalStrength();
            markPixel();
        }
        this.x += v;
    }

    private void noop() {
        this.cycle++;
        getSignalStrength();
        markPixel();
    }

    private void getSignalStrength() {
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

    private void markPixel() {
        char mark = isLit() ? '#' : '.';
        crt.drawPixel(this.cycle - 1, mark);
    }

    private boolean isLit() {
        int c = (this.cycle - 1) % 40;
        int x = this.x;
        if (c == 0)
            return x > 0 && x < 3;
        if (c == 39)
            return x > 37;

        return (x < c + 2) && (x > c - 2);
    }
}
