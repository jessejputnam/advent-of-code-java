import java.util.Scanner;

public class Part2 {
    public static int Solution(Scanner scan) {
        int sumPriorities = 0;
        int count = 0;
        Group group = new Group();

        while (scan.hasNextLine()) {
            count++;
            group.addRucksack(scan.nextLine());

            if (count == 3) {
                group.findBadge();
                sumPriorities += group.getPriority();

                count = 0;
                group = new Group();
            }
        }

        return sumPriorities;
    }
}
