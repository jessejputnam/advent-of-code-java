import java.math.BigInteger;

public class Node {
    private BigInteger val;
    private Node next;

    public Node(BigInteger value) {
        this.val = value;
        this.next = null;
    }

    public void setVal(BigInteger value) {
        this.val = value;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public BigInteger val() {
        return this.val;
    }

    public Node next() {
        return this.next;
    }

    @Override
    public String toString() {
        return "Item: " + this.val.toString() + " next: " + (this.next == null ? "null" : this.next.val().toString());
    }

    @Override
    public boolean equals(Object that) {
        if (this == that)
            return true;

        if (this.getClass() != that.getClass())
            return false;

        Node node = (Node) that;
        if (this.val.compareTo(node.val()) == 0 && this.next == node.next())
            return true;

        return false;
    }
}
