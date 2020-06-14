package ridingFarm;

import java.util.*;
import java.io.*;

public class hMethods {

    public static String getText() {

        Scanner textScanner = new Scanner(System.in);
        return textScanner.nextLine();
    }

    public static String getFilePath() {

        return getFilePath("Error: The given path doesn't point to a valid file.");
    }

    public static String getFilePath(String noPathError) {

        String path = getText();
        while (!new File(path).isFile()) {
            System.out.println("noPathError");
            path = hMethods.getText();
        }
        return path;
    }

}
