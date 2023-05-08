import java.util.Scanner;
import java.nio.file.Paths;

public class Main {
    public static void main(String... args) {
        try (Scanner scan = new Scanner(Paths.get("data.txt"))) {
            // int sumPriorities = Part1.Solution(scan);
            int sumPriorities = Part2.Solution(scan);

            System.out.println("Final Sum: " + sumPriorities);
        } catch (Exception e) {
            System.out.println("Error reading file " + e);
        }
    }
}