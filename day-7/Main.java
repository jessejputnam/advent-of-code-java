import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileTree ft = new FileTree();

        try (Scanner scan = new Scanner(Paths.get("dataTest.txt"))) {

            while (scan.hasNextLine()) {
                String row = scan.nextLine();
                ft.exec(row);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return;
        }

        System.out.println(ft.getRootDir().getDir("a"));
    }
}