package com.urise.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * gkislin
 * 21.07.2016
 */
public class MainFile {
    public static void main(String[] args) {
        String filePath = "./.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File("./src/com/urise/webapp");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        printRescursiveDirectory(dir, 0);
    }

    public static void printRescursiveDirectory(File root, int deepLevel) {
        Objects.nonNull(root);
        for (int i = 0; i < deepLevel; ++i) {
            System.out.print(" ");
        }

        if (root.isDirectory()) {
            System.out.println("directory: " + root.getName());
            File[] files = root.listFiles();
            if (files != null) {
                for (File file : files) {
                    printRescursiveDirectory(file, deepLevel + 1);
                }
            }
        } else if (root.isFile()) {
              System.out.println("file: " + root.getName());
        }
    }
}
