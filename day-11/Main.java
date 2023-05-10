import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        ArrayList<Monkey> monkeys = new ArrayList<>();
        getMonkeysFromData(monkeys);
        playRounds(20, monkeys);
        System.out.println("Monkey Business: " + totalMonkeyBusiness(monkeys));

    }

    public static void getMonkeysFromData(ArrayList<Monkey> monkeys) {
        try (Scanner scan = new Scanner(Paths.get("data.txt"))) {
            while (scan.hasNextLine()) {
                parseMonkeyData(scan, monkeys);
                if (!scan.hasNextLine())
                    break;
                // Empty line
                scan.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void parseMonkeyData(Scanner scan, ArrayList<Monkey> monkeys) {
        // Monkey idx
        scan.nextLine();
        String items = scan.nextLine();
        String op = scan.nextLine();
        String test = scan.nextLine();
        String testTrue = scan.nextLine();
        String testFalse = scan.nextLine();
        String[] monkeyData = { items, op, test, testTrue, testFalse };
        Monkey monkey = new Monkey();
        monkey.setData(monkeyData);
        monkeys.add(monkey);
    }

    public static int totalMonkeyBusiness(ArrayList<Monkey> monkeys) {
        int[] arr = new int[monkeys.size()];
        for (int i = 0; i < monkeys.size(); i++) {
            arr[i] = monkeys.get(i).totalInspections();
        }
        Arrays.sort(arr);
        return arr[arr.length - 1] * arr[arr.length - 2];
    }

    public static void printMonkeys(ArrayList<Monkey> monkeys) {
        for (Monkey monkey : monkeys) {
            System.out.println(monkey);
        }
    }

    public static void playRounds(int numRounds, ArrayList<Monkey> monkeys) {
        for (int i = 0; i < numRounds; i++) {
            for (Monkey monkey : monkeys) {
                while (monkey.hasItems()) {
                    int value = monkey.inspect();
                    int target = monkey.test(value);
                    Monkey monk = monkeys.get(target);
                    monk.addItem(value);
                }
            }
        }
    }
}