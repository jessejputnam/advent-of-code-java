public class Convert {
    public Convert() {
    }

    public String compCode(String code) {
        if (code.equals("A"))
            return "rock";
        if (code.equals("B"))
            return "paper";
        if (code.equals("C"))
            return "scissors";

        return "error";
    }

    public String playerCode(String code) {
        if (code.equals("X"))
            return "rock";
        if (code.equals("Y"))
            return "paper";
        if (code.equals("Z"))
            return "scissors";

        return "error";
    }

    public String outcome(String code) {
        if (code.equals("X"))
            return "lose";
        if (code.equals("Y"))
            return "draw";
        if (code.equals("Z"))
            return "win";

        return "error";
    }
}
