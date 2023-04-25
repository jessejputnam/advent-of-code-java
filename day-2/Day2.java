import java.util.Scanner;
import java.nio.file.Paths;

public class Day2 {
    public static void main(String[] args) {
        Convert convert = new Convert();
        int score = 0;

        try (Scanner scan = new Scanner(Paths.get("data.txt"))) {
            while (scan.hasNextLine()) {
                score += playRoundPart2(scan, convert);
            }
        } catch (Exception e) {
            System.out.println("Error reading file " + e);
        }

        System.out.println(score);
    }

    public static int playRoundPart2(Scanner scan, Convert convert) {
        Round round = new Round();
        String[] code = scan.nextLine().split(" ");
        round.playPart2(convert.compCode(code[0]), convert.outcome(code[1]));
        return round.getScore();
    }

    public static int playRoundPart1(Scanner scan, Convert convert) {
        Round round = new Round();
        String[] code = scan.nextLine().split(" ");
        round.playPart1(convert.compCode(code[0]), convert.playerCode(code[1]));
        return round.getScore();
    }
}