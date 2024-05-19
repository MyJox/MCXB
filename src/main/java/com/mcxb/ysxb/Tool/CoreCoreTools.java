package com.mcxb.ysxb.Tool;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class CoreCoreTools {

    public ObservableList<String> CoreVersionOutput() {
        File folder = new File(".minecraft/versions");
        ObservableList<String> coreVersions = FXCollections.observableArrayList();

        if (!folder.exists()) {
            return coreVersions;
        }

        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isDirectory()) {
                coreVersions.add(file.getName());
            }
        }
        return coreVersions;
    }

    public void onFile(String FilePath) {
        File folder = new File(FilePath);

        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(folder);
            } catch (IOException e) {
                System.err.println("An error occurred while trying to open the folder: " + e.getMessage());
            }
        } else {
            System.err.println("Desktop operations are not supported on this system.");
        }
    }
}
