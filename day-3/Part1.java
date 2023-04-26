import java.util.Scanner;

public class Part1 {
    public static int Solution(Scanner scan) {
        int sumPriorities = 0;

        while (scan.hasNextLine()) {
            Rucksack sack = new Rucksack(scan.nextLine());
            sack.findDuplicate();
            sumPriorities += sack.getPriority();
        }

        return sumPriorities;
    }
}
