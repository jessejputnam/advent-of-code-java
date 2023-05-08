import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        ArrayList<Elf> topThreeElves = getTopThreeElvesFromFile();

        System.out.println("Part 1: " + topThreeElves.get(0).getTotalCalories());
        System.out.println("Part 2: " + sumTopThree(topThreeElves));
    }

    public static ArrayList<Elf> getTopThreeElvesFromFile() {
        ArrayList<Elf> topThreeElves = initTopThreeElvesArr();
        Elf elf = new Elf();

        try (Scanner scan = new Scanner(Paths.get("data.txt"))) {
            while (scan.hasNextLine()) {
                String row = scan.nextLine();
                if (!row.isEmpty()) {
                    elf.addFood(Integer.parseInt(row));
                    continue;
                }
                updateTopThree(topThreeElves, elf);
                elf = new Elf();
            }
            return topThreeElves;
        } catch (Exception e) {
            System.out.println("Error: Reading the file '" + e.getMessage() + "' failed.");
            return topThreeElves;
        }
    }

    public static void updateTopThree(ArrayList<Elf> topThreeElves, Elf elf) {
        for (int i = 0; i < topThreeElves.size(); i++) {
            boolean hasMore = elf.hasMoreCalories(topThreeElves.get(i));
            if (hasMore) {
                topThreeElves.add(i, elf);
                topThreeElves.remove(3);
                break;
            }
        }
    }

    public static int sumTopThree(ArrayList<Elf> topThreeElves) {
        int sum = 0;
        for (Elf elf : topThreeElves)
            sum += elf.getTotalCalories();
        return sum;
    }

    public static ArrayList<Elf> initTopThreeElvesArr() {
        Elf[] emptyList = { new Elf(), new Elf(), new Elf() };
        ArrayList<Elf> topThreeElves = new ArrayList<>();
        topThreeElves.addAll(Arrays.asList(emptyList));
        return topThreeElves;
    }
}