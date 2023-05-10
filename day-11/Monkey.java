public class Monkey {
    private Queue items;
    private char operator;
    private int operand;
    private int divisor;
    private int testTrue;
    private int testFalse;
    private int totalInspections;

    public Monkey() {
        this.items = new Queue();
    }

    public void setData(String[] data) {
        setStartingItems(data[0]);
        setInspectValues(data[1]);
        setTestValue(data[2]);
        setTestTrueValue(data[3]);
        setTestFalseValue(data[4]);
    }

    public boolean hasItems() {
        return !this.items.isEmpty();
    }

    public int inspect() {
        totalInspections++;
        int value = this.items.dequeue();
        int num = operand == -1 ? value : operand;

        if (this.operator == '*')
            value *= num;
        if (this.operator == '+')
            value += num;

        value /= 3;

        return value;
    }

    public int test(int value) {
        return (value % this.divisor == 0) ? this.testTrue : this.testFalse;
    }

    public void addItem(int value) {
        this.items.enqueue(value);
    }

    public int totalInspections() {
        return this.totalInspections;
    }

    public String toString() {
        return "Monkey [" + this.totalInspections + "]: " + this.items.toString();
    }

    private void setStartingItems(String line) {
        String[] arr = line.split(" ");
        for (int i = 4; i < arr.length; i++) {
            int value = Integer.parseInt(arr[i].replaceAll(",", ""));
            items.enqueue(value);
        }
    }

    private void setInspectValues(String line) {
        String[] algo = line.split(" = ")[1].split(" ");
        this.operator = algo[1].charAt(0);
        this.operand = algo[2].equals("old") ? -1 : Integer.parseInt(algo[2]);
    }

    private void setTestValue(String line) {
        this.divisor = Integer.parseInt(line.split(" ")[5]);
    }

    private void setTestTrueValue(String line) {
        this.testTrue = Integer.parseInt(line.split(" ")[9]);
    }

    private void setTestFalseValue(String line) {
        this.testFalse = Integer.parseInt(line.split(" ")[9]);
    }
}
