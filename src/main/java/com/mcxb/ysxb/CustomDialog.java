package com.mcxb.ysxb;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class CustomDialog {
    public Button closeButton;
    public AnchorPane root;

    @FXML
    private Text ErrorText;

    private static Stage stage;

    public static void showPopup(String message) {
        try {
            FXMLLoader loader = new FXMLLoader(CustomDialog.class.getResource("CustomDialog.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Popup");
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();

            CustomDialog controller = loader.getController();
            controller.setMessage(message);
            CustomDialog.stage = stage;

            FadeTransition ft = new FadeTransition(Duration.millis(400), stage.getScene().getRoot());
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void RouteSwitchingAnimation() {
        FadeTransition ft = new FadeTransition(Duration.millis(1000), stage.getScene().getRoot());
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setOnFinished(event -> stage.close());
        ft.play();
    }

    @FXML
    private void closePopup() {
        stage.close();
    }

    public void setMessage(String message) {
        ErrorText.setText(message);
    }

    public void closeDialog(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
