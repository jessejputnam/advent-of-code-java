import java.util.ArrayList;

public class Elf {
    private ArrayList<Integer> pack;

    public Elf() {
        this.pack = new ArrayList<>();
    }

    public void addFood(int food) {
        this.pack.add(food);
    }

    public int getTotalCalories() {
        int total = 0;
        for (int food : pack) {
            total += food;
        }
        return total;
    }

    public boolean hasMoreCalories(Elf newElf) {
        return getTotalCalories() > newElf.getTotalCalories();
    }

    @Override
    public String toString() {
        return this.pack.toString();
    }
}
