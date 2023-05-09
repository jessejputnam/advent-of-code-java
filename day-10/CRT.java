public class CRT {
    private char[][] screen;

    public CRT() {
        this.screen = new char[6][40];
    }

    public void drawPixel(int cycle, char mark) {
        int row = cycle / 40;
        int col = cycle % 40;
        this.screen[row][col] = mark;
    }

    public void printScreen() {
        String monitor = "";
        for (char[] line : this.screen) {
            for (char ch : line)
                monitor += ch;
            monitor += "\n";
        }
        System.out.println(monitor);
    }
}
