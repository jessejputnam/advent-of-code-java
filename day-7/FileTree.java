public class FileTree {
    private Dir root;
    private Dir curDir;

    public FileTree() {
        this.root = new Dir("/", null);
        this.curDir = null;
    }

    public Dir getRootDir() {
        return this.root;
    }

    public Dir getCurDir() {
        return this.curDir;
    }

    public void exec(String row) {
        // Movement command
        if (row.charAt(0) == '$') {
            parseCmd(row);
            return;
        }

        // Create command
        String[] toAdd = row.split(" ");
        if (toAdd[0].equals("dir")) {
            mkdir(row.substring(4));
            return;
        }

        touch(toAdd[1], Integer.valueOf(toAdd[0]));

    }

    private void parseCmd(String row) {
        String cmd = row.substring(2, 4);
        if (cmd.equals("ls"))
            return;

        String arg = row.substring(5);
        cd(arg);
    }

    private void cd(String arg) {
        if (arg.equals("/")) {
            this.curDir = this.root;
            return;
        }

        if (arg.equals("..")) {
            this.curDir = this.curDir.getParent();
            return;
        }

        this.curDir = this.curDir.getDir(arg);

    }

    private void mkdir(String dirName) {
        Dir newDir = new Dir(dirName, this.curDir);
        this.curDir.addDir(newDir);
    }

    private void touch(String fileName, int fileSize) {
        File newFile = new File(fileName, fileSize);
        this.curDir.addFile(newFile);
    }
}