public class Head extends Knot {
    public Head() {
        super();
    }

    public void move(String dir) {
        if (dir.equals("R")) {
            this.right();
        } else if (dir.equals("U")) {
            this.up();
        } else if (dir.equals("L")) {
            this.left();
        } else if (dir.equals("D")) {
            this.down();
        }
    }
}
