public class Tail extends Knot {
    public Tail() {
        super();
    }

    public boolean follow(Head head) {
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
        if (checkCoord(0, headCoord)) {
            setCol(headCoord[1]);
            moveVertical(headCoord[0]);
        } else {
            setRow(headCoord[0]);
            moveHorizontal(headCoord[1]);
        }
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
        if (checkCoord(0, headCoord) || checkCoord(1, headCoord))
            return true;

        return false;
    }

    private boolean checkCoord(int idx, int[] headCoord) {
        return Math.abs(headCoord[idx] - this.getCoords()[idx]) > 1;
    }
}
