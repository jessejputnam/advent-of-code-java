import java.util.Scanner;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(Paths.get("data.txt"))) {
            int totalRangesContained = 0;

            while (scan.hasNextLine()) {
                boolean isContained = findContainedPairsFromPairs(scan.nextLine());

                if (isContained)
                    totalRangesContained++;
            }

            System.out.println(totalRangesContained);
        } catch (Exception e) {
            System.out.println("Error reading text file: " + e);
            return;
        }
    }

    public static boolean findContainedPairsFromPairs(String pairs) {
        String[] ranges = pairs.split(",");
        Elf elfA = new Elf(getAssignments(ranges[0]));
        Elf elfB = new Elf(getAssignments(ranges[1]));

        return isContainedRange(elfA, elfB);
    }

    public static int[] getAssignments(String pair) {
        String[] assignment = pair.split("-");
        return new int[] { Integer.valueOf(assignment[0]), Integer.valueOf(assignment[1]) };
    }

    public static boolean isContainedRange(Elf a, Elf b) {
        if (a.getMin() >= b.getMin() && a.getMax() <= b.getMax())
            return true;

        if (b.getMin() >= a.getMin() && b.getMax() <= a.getMax())
            return true;

        return false;
    }
}