public class Queue {
    private Node first;
    private Node last;
    private int size;

    public Queue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public Node first() {
        return this.first;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int size() {
        return this.size;
    }

    public void enqueue(int value) {
        Node node = new Node(value);
        this.size++;

        if (this.first == null) {
            this.first = node;
            return;
        }

        if (this.last == null)
            this.first.setNext(node);
        else
            this.last.setNext(node);

        this.last = node;
    }

    public int dequeue() {
        Node node = this.first;
        if (node.next() == this.last)
            this.last = null;
        this.first = node.next();
        this.size--;
        return node.val();
    }

    public String toString() {
        String items = "";
        for (Node n = this.first; n != null; n = n.next()) {
            items += n.val();
            if (n.next() != null)
                items += ", ";
        }
        return items;
    }
}
