package Day00;

import java.io.File;

public class DemoDeleteFolder {
    public static void main(String[] args) {
        File myObj = new File("/Users/geekqq/IdeaProjects/JavaLearning/test");
        if (myObj.delete()) {
            System.out.println("Deleted the folder: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the folder!");
        }
    }
}
