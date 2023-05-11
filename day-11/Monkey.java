import java.math.BigInteger;

public class Monkey {
    private Queue items;
    private char operator;
    private BigInteger operand;
    private BigInteger divisor;
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

    public BigInteger inspect() {
        this.totalInspections++;
        BigInteger value = this.items.dequeue();
        BigInteger num = this.operand == null ? value : this.operand;

        if (this.operand == null)
            return value.pow(2);
        else if (this.operator == '*')
            return value.multiply(num);
        else if (this.operator == '+')
            return value.add(num);

        // value /= 3;

        return value;
    }

    public int test(BigInteger value) {
        return (value.mod(this.divisor).compareTo(BigInteger.valueOf(0)) == 0 ? this.testTrue : this.testFalse);
    }

    public void addItem(BigInteger value) {
        this.items.enqueue(value);
    }

    public int totalInspections() {
        return this.totalInspections;
    }

    public String toString() {
        return "Monkey [" + this.totalInspections + "]";
    }

    private void setStartingItems(String line) {
        String[] arr = line.split(" ");
        for (int i = 4; i < arr.length; i++) {
            long num = Long.parseLong(arr[i].replaceAll(",", ""));
            BigInteger value = BigInteger.valueOf(num);
            items.enqueue(value);
        }
    }

    private void setInspectValues(String line) {
        String[] algo = line.split(" = ")[1].split(" ");
        this.operator = algo[1].charAt(0);
        this.operand = algo[2].equals("old") ? null : BigInteger.valueOf(Long.parseLong(algo[2]));
    }

    private void setTestValue(String line) {
        long num = Long.parseLong(line.split(" ")[5]);
        this.divisor = BigInteger.valueOf(num);
    }

    private void setTestTrueValue(String line) {
        this.testTrue = Integer.parseInt(line.split(" ")[9]);
    }

    private void setTestFalseValue(String line) {
        this.testFalse = Integer.parseInt(line.split(" ")[9]);
    }
}
