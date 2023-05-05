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

    public void setRow(int row) {
        this.coords[0] = row;
    }

    public void setCol(int col) {
        this.coords[1] = col;
    }

    public String toString() {
        return Arrays.toString(this.coords);
    }
}
