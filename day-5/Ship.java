import java.util.Stack;
import java.util.ArrayList;

public class Ship {
    private ArrayList<Stack<Character>> stacks;

    public Ship() {
        this.stacks = new ArrayList<>();
    }

    public void initStacks(int numStacks) {
        for (int i = 0; i < numStacks; i++)
            this.stacks.add(new Stack<Character>());
    }

    public int getStacksLength() {
        return this.stacks.size();
    }

    public void fillStacks(ArrayList<String> reverseStacks) {
        for (int i = 0; i < reverseStacks.size(); i++) {
            int num = reverseStacks.get(i).length() - 1;
            for (int j = num; j >= 0; j--) {
                char crate = reverseStacks.get(i).charAt(j);
                this.stacks.get(i).push(crate);
            }
        }
    }

    public void rearrange(int[] instruction) {
        for (int i = 0; i < instruction[0]; i++) {
            char crate = this.stacks.get(instruction[1]).pop();
            this.stacks.get(instruction[2]).push(crate);
        }
    }

    public String getTopCrates() {
        String topCrates = "";
        for (int i = 0; i < this.stacks.size(); i++)
            topCrates += String.valueOf(this.stacks.get(i).pop());

        return topCrates;
    }

    public String toString() {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < this.stacks.size(); i++) {
            list.add("");
            while (!this.stacks.get(i).isEmpty()) {
                list.set(i, String.valueOf(this.stacks.get(i).pop() + list.get(i)));
            }
        }
        return list.toString();
    }
}
