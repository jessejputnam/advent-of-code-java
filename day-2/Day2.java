import java.util.Scanner;
import java.nio.file.Paths;

public class Day2 {
    public static void main(String[] args) {
        int score = 0;

        try (Scanner scan = new Scanner(Paths.get("data.txt"))) {
            while (scan.hasNextLine()) {
                score += playRound(scan);
            }
        } catch (Exception e) {
            System.out.println("Error reading file " + e);
        }

        System.out.println(score);
    }

    public static int playRound(Scanner scan) {
        Round round = new Round();
        String[] choices = scan.nextLine().split(" ");
        round.play(convertCode(choices[1]), convertCode(choices[0]));
        return round.getScore();
    }

    public static String convertCode(String code) {
        if (code.equals("A") || code.equals("X"))
            return "rock";
        if (code.equals("B") || code.equals("Y"))
            return "paper";
        if (code.equals("C") || code.equals("Z"))
            return "scissors";

        return "error";
    }
}