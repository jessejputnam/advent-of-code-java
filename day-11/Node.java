public class Node {
    private int val;
    private Node next;

    public Node(int value) {
        this.val = value;
        this.next = null;
    }

    public void setVal(int value) {
        this.val = value;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public int val() {
        return this.val;
    }

    public Node next() {
        return this.next;
    }

    @Override
    public String toString() {
        return "Item: " + this.val + " next: " + (this.next == null ? "null" : this.next.val());
    }

    @Override
    public boolean equals(Object that) {
        if (this == that)
            return true;

        if (this.getClass() != that.getClass())
            return false;

        Node node = (Node) that;
        if (this.val == node.val() && this.next == node.next())
            return true;

        return false;
    }
}
