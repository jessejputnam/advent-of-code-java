import java.util.Arrays;

public class Knot {
    private int[] coords;

    public Knot() {
        this.coords = new int[2];
    }

    public int[] getCoords() {
        return this.coords;
    }

    public void right() {
        this.coords[1]++;
    }

    public void left() {
        this.coords[1]--;
    }

    public void up() {
        this.coords[0]--;
    }

    public void down() {
        this.coords[0]++;
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

    public boolean follow(Knot head) {
        int[] headCoord = head.getCoords();
        if (!requireMove(headCoord))
            return false;

        if (sameAxis(0, headCoord)) {
            moveHorizontal(headCoord[1]);
        } else if (sameAxis(1, headCoord)) {
            moveVertical(headCoord[0]);
        } else {
            moveDiagonal(headCoord);
        }

        return true;
    }

    private void moveDiagonal(int[] headCoord) {
        moveVertical(headCoord[0]);
        moveHorizontal(headCoord[1]);
    }

    private void moveVertical(int headRow) {
        if (headRow > this.getCoords()[0])
            this.down();
        else
            this.up();
    }

    private void moveHorizontal(int headCol) {
        if (headCol > this.getCoords()[1])
            this.right();
        else
            this.left();
    }

    private boolean sameAxis(int idx, int[] headCoord) {
        return headCoord[idx] == this.getCoords()[idx];
    }

    private boolean requireMove(int[] headCoord) {
        return checkCoord(0, headCoord) || checkCoord(1, headCoord);
    }

    private boolean checkCoord(int idx, int[] headCoord) {
        return Math.abs(headCoord[idx] - this.getCoords()[idx]) > 1;
    }

    public String toString() {
        return Arrays.toString(this.coords);
    }
}
