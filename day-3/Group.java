import java.util.HashSet;

public class Group {
    private char[][] rucksacks;
    private char badge;

    public Group() {
        this.rucksacks = new char[3][];
    }

    public void addRucksack(String rucksack) {
        for (int i = 0; i < rucksacks.length; i++) {
            if (rucksacks[i] == null) {
                rucksacks[i] = rucksack.toCharArray();
                return;
            }
        }

        System.out.println("Error: Rucksacks already full for group");
    }

    public void findBadge() {
        HashSet<Character> set = new HashSet<>(this.rucksacks[0].length);
        HashSet<Character> duplicates = new HashSet<>(this.rucksacks[1].length);

        for (char ch : rucksacks[0])
            set.add(ch);

        for (char ch : rucksacks[1]) {
            if (set.contains(ch))
                duplicates.add(ch);
        }

        for (char ch : rucksacks[2]) {
            if (duplicates.contains(ch))
                this.badge = ch;
        }

    }

    public char getBadge() {
        return this.badge;
    }

    public int getPriority() {
        if ((int) this.badge > 96)
            return this.badge - 96;
        return this.badge - 38;
    }
}
