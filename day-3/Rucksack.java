import java.util.HashSet;

public class Rucksack {
    private char[] compartmentA;
    private char[] compartmentB;
    private char duplicate;

    public Rucksack(String row) {
        this.compartmentA = row.substring(0, (row.length() / 2)).toCharArray();
        this.compartmentB = row.substring((row.length() / 2)).toCharArray();
    }

    public void findDuplicate() {
        int size = this.compartmentA.length;
        HashSet<Character> visited = new HashSet<>(size);

        for (char charA : compartmentA) {
            if (visited.contains(charA))
                continue;
            visited.add(charA);

            for (char charB : compartmentB) {
                if (charA == charB) {
                    this.duplicate = charA;
                    return;
                }
            }

        }
    }

    public char getDuplicate() {
        return this.duplicate;
    }

    public int getPriority() {
        if ((int) this.duplicate > 96)
            return this.duplicate - 96;
        return this.duplicate - 38;
    }
}
