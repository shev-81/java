package algoritm_lesson_5;

import java.io.File;

public class ShowFiles {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\shev-\\IdeaProjects\\LearnGeetBraine\\src\\main\\java");
        viewFiles(file);
    }

    private static void viewFiles(File file, int level) {

        StringBuilder prefix = new StringBuilder();
        prefix.append("\t".repeat(level));

        if (file.isFile()) {
            System.out.println(prefix + "File: " + file.getName());
        } else {
            System.out.println(prefix + "Dir: " + file.getName());
            level++;
            for (File listFile : file.listFiles()) {
                viewFiles(listFile, level);
            }
        }

    }

    private static void viewFiles(File file) {
        viewFiles(file, 0);
    }

}