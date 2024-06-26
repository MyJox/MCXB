package com.mcxb.ysxb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("FXML Example");

        // Get the VBox from the FXML file
        VBox vBox = (VBox) loader.getNamespace().get("vBox");

        // Sample directory path
        String directoryPath = ".minecraft/versions";

        // Get all subdirectories
        List<String> subDirectories = getSubDirectories(directoryPath);

        // ToggleGroup for RadioButtons
        ToggleGroup toggleGroup = new ToggleGroup();

        // Add RadioButtons dynamically
        for (String directory : subDirectories) {
            RadioButton radioButton = new RadioButton(directory);
            radioButton.setToggleGroup(toggleGroup);
            vBox.getChildren().add(radioButton);
        }

        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    private List<String> getSubDirectories(String directoryPath) throws IOException {
        try (Stream<Path> paths = Files.list(Paths.get(directoryPath))) {
            return paths
                    .filter(Files::isDirectory)
                    .map(p -> p.getFileName().toString())
                    .collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
