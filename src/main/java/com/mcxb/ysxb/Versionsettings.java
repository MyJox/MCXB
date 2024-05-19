package com.mcxb.ysxb;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Versionsettings {
    @FXML
    public VBox VersVbox;
    private static String selectedDirectory = "0";

    public void VersTings() throws IOException {
        String directoryPath = ".minecraft/versions";
        List<String> subDirectories = getSubDirectories(directoryPath);
        ToggleGroup toggleGroup = new ToggleGroup();

        for (String directory : subDirectories) {
            RadioButton radioButton = new RadioButton(directory);
            radioButton.setToggleGroup(toggleGroup);
            HBox hBox = new HBox();
            hBox.getChildren().add(radioButton);
            hBox.setStyle("-fx-background-radius: 10;-fx-background-color: #ffffff;-fx-min-height: 50;-fx-alignment: CENTER_LEFT;-fx-padding: 0 0 0 10;-fx-border-width: 0 0 2 0;-fx-border-color: #3061b2;");
            VersVbox.getChildren().add(hBox);
        }

        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                RadioButton selectedRadioButton = (RadioButton) newValue;
                setSelectedDirectory(selectedRadioButton.getText());
            }
        });
    }

    private List<String> getSubDirectories(String directoryPath) throws IOException {
        try (Stream<Path> paths = Files.list(Paths.get(directoryPath))) {
            return paths
                    .filter(Files::isDirectory)
                    .map(p -> p.getFileName().toString())
                    .collect(Collectors.toList());
        }
    }

    public String getSelectedDirectory() {
        return selectedDirectory;
    }

    public void setSelectedDirectory(String selectedDirectory) {
        Versionsettings.selectedDirectory = selectedDirectory;
    }
}
