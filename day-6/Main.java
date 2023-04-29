import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Character> marker = new ArrayList<>(4);
        int idx = 0;

        try (Scanner scan = new Scanner(Paths.get("data.txt"))) {
            scan.useDelimiter("");

            while (scan.hasNext()) {
                char ch = scan.next().charAt(0);

                boolean valid = checkMarker(marker, ch, 14);

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

    public static boolean checkMarker(ArrayList<Character> marker, char ch, int uniqueChars) {
        updateMarker(marker, ch, uniqueChars);
        return isValid(marker, uniqueChars);
    }

    public static boolean isValid(ArrayList<Character> marker, int uniqueChars) {
        int idx = uniqueChars;

        if (marker.size() < idx)
            return false;

        for (int i = 0; i < idx - 1; i++) {
            for (int j = i + 1; j < idx; j++) {
                if (marker.get(i) == marker.get(j))
                    return false;
            }
        }

        return true;
    }

    public static void updateMarker(ArrayList<Character> marker, char ch, int uniqueChars) {
        if (marker.size() > uniqueChars - 1)
            marker.remove(0);

        marker.add(ch);
    }
}
