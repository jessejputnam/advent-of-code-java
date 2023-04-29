import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Character> marker = new ArrayList<>(4);
        int idx = 0;

        try (Scanner scan = new Scanner(Paths.get("dataTest.txt"))) {
            scan.useDelimiter("");

            while (scan.hasNext()) {
                char ch = scan.next().charAt(0);

                boolean valid = checkMarker(marker, ch);

                idx++;
                if (valid)
                    break;

            }
        } catch (Exception e) {
            System.out.println("Error: could not read file: " + e);
            return;
        }

        System.out.println(idx);
    }

    public static boolean checkMarker(ArrayList<Character> marker, char ch) {
        updateMarker(marker, ch);
        return isValidMarker(marker);
    }

    public static boolean isValidMarker(ArrayList<Character> marker) {
        if (marker.size() < 4)
            return false;

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (marker.get(i) == marker.get(j))
                    return false;
            }
        }

        return true;
    }

    public static void updateMarker(ArrayList<Character> marker, char ch) {
        if (marker.size() > 3)
            marker.remove(0);

        marker.add(ch);
    }
}
