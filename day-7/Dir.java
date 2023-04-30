import java.util.HashMap;

public class Dir {
    private Dir parent;
    private String name;
    private HashMap<String, Dir> dirs;
    private HashMap<String, File> files;

    public Dir(String name, Dir parent) {
        this.parent = parent;
        this.name = name;
        this.dirs = new HashMap<>();
        this.files = new HashMap<>();
    }

    public void addFile(File file) {
        this.files.put(file.getName(), file);
    }

    public void addDir(Dir dir) {
        this.dirs.put(dir.getName(), dir);
    }

    public String getName() {
        return this.name;
    }

    public Dir getParent() {
        return this.parent;
    }

    public Dir getDir(String dirName) {
        return this.dirs.get(dirName);
    }

    // public HashMap<String, Dir> getDirs() {
    // return this.dirs;
    // }

    // public HashMap<String, File> getFiles() {
    // return this.files;
    // }

    public boolean hasFiles() {
        return this.files.size() > 0;
    }

    public boolean hasDirs() {
        return this.dirs.size() > 0;
    }

    public String toString() {
        return this.name + ": files[" + this.files.size() + "] dirs[" + this.dirs.size() + "]";
    }
}
