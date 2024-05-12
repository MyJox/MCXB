package com.mcxb.ysxb.Tool;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.util.Objects;

public class CoreCoreTools {

    public ObservableList<String> CoreVersionOutput() {
        File folder = new File(".minecraft/versions");
        ObservableList<String> coreVersions = FXCollections.observableArrayList();

        // 检查文件夹是否存在
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
}
