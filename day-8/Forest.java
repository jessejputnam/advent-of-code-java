import java.util.ArrayList;

public class Forest {
    private ArrayList<ArrayList<Integer>> grid;

    public Forest() {
        this.grid = new ArrayList<>();
    }

    public void addRow(String row) {
        String[] arr = row.split("");
        ArrayList<Integer> gridRow = new ArrayList<Integer>();
        for (String tree : arr) {
            gridRow.add(Integer.parseInt(tree));
        }
        this.grid.add(gridRow);
    }

    public int getVisibleTreeCount() {
        int totalVisible = 0;
        int length = this.grid.size();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (isEdge(i, j)) {
                    totalVisible++;
                    continue;
                }

                boolean[] visibleDirections = { true, true, true, true };
                checkCardinalVisibility(visibleDirections, i, j);

                // Final check
                for (boolean dir : visibleDirections) {
                    if (dir == true) {
                        totalVisible++;
                        break;
                    }
                }

            }
        }
        return totalVisible;
    }

    @Override
    public String toString() {
        String output = "";
        for (ArrayList<Integer> row : this.grid) {
            for (int tree : row) {
                output += tree;
            }
            output += "\n";
        }

        return output;
    }

    private boolean isEdge(int i, int j) {
        int length = this.grid.size();
        return (i == 0 || j == 0 || i == length - 1 || j == length - 1);
    }

    private void checkCardinalVisibility(boolean[] visibleDirections, int i, int j) {
        int tree = this.grid.get(i).get(j);
        int length = this.grid.size();

        for (int k = 0; k < length; k++) {
            // check horizontal
            if (this.grid.get(i).get(k) >= tree) {
                if (k < j)
                    visibleDirections[3] = false;

                if (k > j)
                    visibleDirections[1] = false;

            }

            // check vertical
            if (this.grid.get(k).get(j) >= tree) {
                if (k < i)
                    visibleDirections[0] = false;

                if (k > i)
                    visibleDirections[2] = false;
            }
        }
    }
}
