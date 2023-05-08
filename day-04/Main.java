import java.util.Scanner;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(Paths.get("data.txt"))) {
            // int totalRangesContained = 0;
            int totalOverlapping = 0;

            while (scan.hasNextLine()) {
                Elf[] elves = getElves(scan.nextLine());

                // Part 1
                // boolean isContained = isContainedRange(elves[0], elves[1]);
                // if (isContained)
                // totalRangesContained++;

                // Part 2
                boolean isOverlapping = hasOverlap(elves[0], elves[1]);
                if (isOverlapping)
                    totalOverlapping++;
            }

            // System.out.println(totalRangesContained);
            System.out.println(totalOverlapping);
        } catch (Exception e) {
            System.out.println("Error reading text file: " + e);
            return;
        }
    }

    public static Elf[] getElves(String pairs) {
        String[] ranges = pairs.split(",");
        Elf elfA = new Elf(getAssignments(ranges[0]));
        Elf elfB = new Elf(getAssignments(ranges[1]));

        return new Elf[] { elfA, elfB };
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

    public static boolean hasOverlap(Elf a, Elf b) {
        if (a.getMin() <= b.getMin() && a.getMax() >= b.getMin())
            return true;

        if (a.getMin() >= b.getMin() && a.getMin() <= b.getMax())
            return true;

        if (b.getMin() <= a.getMin() && b.getMax() >= a.getMin())
            return true;

        if (b.getMin() >= a.getMin() && b.getMin() <= a.getMax())
            return true;

        return false;
    }
}