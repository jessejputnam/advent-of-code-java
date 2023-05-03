import java.util.Scanner;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Forest forest = new Forest();

        try (Scanner scan = new Scanner(Paths.get("data.txt"))) {
            // Create forest map
            while (scan.hasNextLine()) {
                forest.addRow(scan.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e);
        }

        System.out.println(forest.getVisibleTreeCount());
    }
}
