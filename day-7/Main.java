import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileTree ft = new FileTree();

        try (Scanner scan = new Scanner(Paths.get("data.txt"))) {

            while (scan.hasNextLine()) {
                String row = scan.nextLine();
                ft.exec(row);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return;
        }

        int sumDirs = ft.getSumDirsBySize(100000);
        System.out.println("Part 1: " + sumDirs);
        int smallestDir = ft.getSmallestFileToRemove();
        System.out.println("Part 2: " + smallestDir);
    }
}