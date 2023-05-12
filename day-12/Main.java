import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Device device = null;
        try (Scanner scan = new Scanner(Paths.get("dataTest.txt"))) {
            List<String> rows = scan.useDelimiter("\n").tokens().collect(Collectors.toList());
            device = new Device(rows.size(), rows.get(0).length());
            device.setGrid(rows);
            System.out.println(device);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}