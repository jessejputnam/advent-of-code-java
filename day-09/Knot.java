import java.util.Arrays;

public class Knot {
    private int[] coords;

    public Knot() {
        this.coords = new int[2];
    }

    public boolean move(String dir) {
        if (dir.equals("R"))
            return right();
        if (dir.equals("U"))
            return up();
        if (dir.equals("L"))
            return left();
        if (dir.equals("D"))
            return down();

        return false;
    }

    public boolean follow(Knot head) {
        int[] headCoord = head.getCoords();
        if (!requireMove(headCoord))
            return false;

        if (sameAxis(0, headCoord))
            return moveHorizontal(headCoord[1]);
        if (sameAxis(1, headCoord))
            return moveVertical(headCoord[0]);
        return moveDiagonal(headCoord);
    }

    public String toString() {
        return Arrays.toString(this.coords);
    }

    private int[] getCoords() {
        return this.coords;
    }

    private boolean right() {
        this.coords[1]++;
        return true;
    }

    private boolean left() {
        this.coords[1]--;
        return true;
    }

    private boolean up() {
        this.coords[0]--;
        return true;
    }

    private boolean down() {
        this.coords[0]++;
        return true;
    }

    private boolean moveDiagonal(int[] headCoord) {
        moveVertical(headCoord[0]);
        return moveHorizontal(headCoord[1]);
    }

    private boolean moveVertical(int headRow) {
        if (headRow > this.getCoords()[0])
            return down();
        return up();

    }

    private boolean moveHorizontal(int headCol) {
        if (headCol > this.getCoords()[1])
            return right();
        return left();
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
}
