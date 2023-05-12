import java.util.Arrays;
import java.util.List;

public class Device {
    private char[][] grid;
    private int[] start;
    private int[] end;
    private int min;

    public Device(int rows, int cols) {
        this.grid = new char[rows][cols];
    }

    public int findShortestPath() {
        int[] cur = { this.start[0], this.start[1] };
        int[] min = { Integer.MAX_VALUE };

        return -1;
    }

    public void setGrid(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                if (list.get(i).charAt(j) == 'S') {
                    setStart(i, j);
                    this.grid[i][j] = 'a';
                    continue;
                }
                if (list.get(i).charAt(j) == 'E') {
                    setEnd(i, j);
                    this.grid[i][j] = 'z';
                    continue;
                }
                this.grid[i][j] = list.get(i).charAt(j);
            }
        }
    }

    public void setStart(int row, int col) {
        this.start = new int[] { row, col };
    }

    public void setEnd(int row, int col) {
        this.end = new int[] { row, col };
    }

    public String toString() {
        String output = " -- " + Arrays.toString(this.start) + " " + Arrays.toString(this.end) + " --\n";
        for (char[] row : this.grid)
            output += Arrays.toString(row) + "\n";
        return output;
    }

    private void recur(int a, int b, int count) {

        char up = a > 0 ? this.grid[a - 1][b] : 45;
        char right = b < this.grid[0].length - 1 ? this.grid[a][b + 1] : 45;
        char down = a < this.grid.length - 1 ? this.grid[a + 1][b] : 45;
        char left = b > 0 ? this.grid[a][b - 1] : 45;

        // if (up != '_')
    }
}
