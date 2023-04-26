import java.util.Scanner;
import java.nio.file.Paths;

public class Main {
    public static void main(String... args) {
        try (Scanner scan = new Scanner(Paths.get("data.txt"))) {
            int sumPriorities = 0;

            while (scan.hasNextLine()) {
                Rucksack sack = new Rucksack(scan.nextLine());
                sack.findDuplicate();
                sumPriorities += sack.getPriority();
            }

            System.out.println(sumPriorities);
        } catch (Exception e) {
            System.out.println("Error reading file " + e);
        }
    }
}