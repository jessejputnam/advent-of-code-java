public class Round {
    private int score;

    public Round() {
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public void playPart1(String compChoice, String playerChoice) {
        int value = 0;
        value += getChoicePoints(playerChoice);
        value += getOutcomePoints(playerChoice, compChoice);
        this.score = value;
    }

    public void playPart2(String compChoice, String outcome) {
        int value = 0;
        value += getChoicePoints(playerChoiceFromOutcome(compChoice, outcome));
        value += convertOutcome(outcome);
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

    public String playerChoiceFromOutcome(String compChoice, String outcome) {
        if (compChoice.equals("rock")) {
            if (outcome.equals("lose"))
                return "scissors";
            if (outcome.equals("draw"))
                return "rock";
            if (outcome.equals("win"))
                return "paper";
        }

        if (compChoice.equals("paper")) {
            if (outcome.equals("lose"))
                return "rock";
            if (outcome.equals("draw"))
                return "paper";
            if (outcome.equals("win"))
                return "scissors";
        }

        if (compChoice.equals("scissors")) {
            if (outcome.equals("lose"))
                return "paper";
            if (outcome.equals("draw"))
                return "scissors";
            if (outcome.equals("win"))
                return "rock";
        }

        return "error";
    }

}
