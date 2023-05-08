public class Elf {
    private int min;
    private int max;

    public Elf(int[] assignment) {
        this.min = assignment[0];
        this.max = assignment[1];
    }

    public int getMin() {
        return this.min;
    }

    public int getMax() {
        return this.max;
    }
}
