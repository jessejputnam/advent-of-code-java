import java.util.ArrayList;

public class Dir {
    private String name;
    private ArrayList<Dir> dirs;
    private ArrayList<File> files;

    public Dir(String name) {
        this.name = name;
        this.dirs = new ArrayList<>();
        this.files = new ArrayList<>();
    }

    public void addFile(File file) {
        this.files.add(file);
    }

    public void addDir(Dir dir) {
        this.dirs.add(dir);
    }

    public ArrayList<Dir> getDirs() {
        return this.dirs;
    }

    public ArrayList<File> getFiles() {
        return this.files;
    }

    public boolean hasFiles() {
        return this.files.size() > 0;
    }

    public boolean hasDirs() {
        return this.dirs.size() > 0;
    }

    public String toString() {
        return this.name + ": files (" + this.files.size() + ") dirs (" + this.dirs.size() + ")";
    }
}
