import java.util.Scanner;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        CPU cpu = new CPU();

        try (Scanner scan = new Scanner(Paths.get("data.txt"))) {
            while (scan.hasNextLine()) {
                String[] cmd = scan.nextLine().split(" ");
                cpu.parseCmd(cmd);
            }
            // cpu.printSignals();
            // System.out.println(cpu.sumSignals());
            cpu.printScreen();
        } catch (Exception e) {
            System.out.println("Scanner error: " + e);
            return;
        }
    }
}