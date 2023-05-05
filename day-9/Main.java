import java.util.Scanner;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String file = args[0];
        Bridge bridge = new Bridge();
        try (Scanner scan = new Scanner(Paths.get(file))) {
            while (scan.hasNextLine()) {
                String[] cmd = scan.nextLine().split(" ");
                bridge.exec(cmd);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e);
            return;
        }

        System.out.println(bridge.getVisitedCount());
    }
}