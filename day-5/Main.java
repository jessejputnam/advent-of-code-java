import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Ship ship = new Ship();
        ArrayList<String> reverseStack = new ArrayList<>();

        try (Scanner scan = new Scanner(Paths.get("dataTest.txt"))) {

            // Read file for stack schema
            while (scan.hasNextLine()) {
                String row = scan.nextLine();

                if (row.isEmpty())
                    break;

                if (isNumberedRow(row))
                    continue;

                if (ship.getStacksLength() == 0)
                    initBothStacks(ship, reverseStack, row);

                fillReverseStackSchema(row, reverseStack);
            }

            // Use reverse stack schema to create stack
            ship.fillStacks(reverseStack);

            // Read file for rearrangement procedure
            while (scan.hasNextLine()) {
                String row = scan.nextLine();
                System.out.println(row);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e);
        }
    }

    public static void fillReverseStackSchema(String row, ArrayList<String> reverseStack) {
        char[] charRow = row.toCharArray();
        for (int i = 0, num = 0; i < charRow.length; i++) {
            if ((i - 1) % 4 == 0) {
                if (charRow[i] != 32)
                    reverseStack.set(num, reverseStack.get(num) + charRow[i]);
                num++;
            }
        }
    }

    public static void initBothStacks(Ship ship, ArrayList<String> reverseStack, String row) {
        ship.initStacks(getNumStacks(row));
        for (int i = 0; i < getNumStacks(row); i++)
            reverseStack.add("");
    }

    public static boolean isNumberedRow(String row) {
        if (row.charAt(1) == 49) {
            return true;
        }
        return false;
    }

    public static int getNumStacks(String row) {
        return (row.length() / 4) + 1;
    }
}
