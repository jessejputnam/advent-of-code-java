public class Round {
    private int score;

    public Round() {
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public void play(String playerChoice, String compChoice) {
        int value = 0;
        value += getChoicePoints(playerChoice);
        value += getOutcomePoints(playerChoice, compChoice);
        this.score = value;
    }

    public int getChoicePoints(String playerChoice) {
        if (playerChoice.equals("rock"))
            return 1;
        if (playerChoice.equals("paper"))
            return 2;
        if (playerChoice.equals("scissors"))
            return 3;

        return 0;
    }

    public int getOutcomePoints(String playerChoice, String compChoice) {
        String outcome = "";

        if (playerChoice.equals("rock"))
            outcome = playerRockOutcome(compChoice);

        if (playerChoice.equals("scissors"))
            outcome = playerScissorsOutcome(compChoice);

        if (playerChoice.equals("paper"))
            outcome = playerPaperOutcome(compChoice);

        return convertOutcome(outcome);
    }

    public int convertOutcome(String outcome) {
        if (outcome.equals("lose"))
            return 0;
        if (outcome.equals("draw"))
            return 3;
        if (outcome.equals("win"))
            return 6;

        return 0;
    }

    public String playerRockOutcome(String compChoice) {
        if (compChoice.equals("rock"))
            return "draw";
        if (compChoice.equals("paper"))
            return "lose";
        if (compChoice.equals("scissors"))
            return "win";

        return "error";
    }

    public String playerScissorsOutcome(String compChoice) {
        if (compChoice.equals("rock"))
            return "lose";
        if (compChoice.equals("paper"))
            return "win";
        if (compChoice.equals("scissors"))
            return "draw";

        return "error";
    }

    public String playerPaperOutcome(String compChoice) {
        if (compChoice.equals("rock"))
            return "win";
        if (compChoice.equals("paper"))
            return "draw";
        if (compChoice.equals("scissors"))
            return "lose";

        return "error";
    }

}
