package com.mcxb.ysxb;

import java.io.File;
import java.util.Objects;

public class test {

    public static void main(String[] args) {
        File folder = new File(".minecraft/versions");
        printFolderNames(folder);
    }

    public static void printFolderNames(File folder) {
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isDirectory()) {
                System.out.println(file.getName());
            }
        }
    }
}
