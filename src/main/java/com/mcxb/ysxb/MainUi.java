package com.mcxb.ysxb;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.to2mbn.jmccc.auth.OfflineAuthenticator;
import org.to2mbn.jmccc.launch.LaunchException;
import org.to2mbn.jmccc.launch.Launcher;
import org.to2mbn.jmccc.launch.LauncherBuilder;
import org.to2mbn.jmccc.option.LaunchOption;
import org.to2mbn.jmccc.option.MinecraftDirectory;

import java.io.IOException;
import java.util.Objects;

public class MainUi {
    public AnchorPane root;
    public TextField OfflineNickname;
    public HBox Authenticlogin;
    public HBox Versionsettings;
    public HBox ModDownload;
    public Text announcement;
    public HBox help;
    public HBox setup;
    public Button Startgames;
    @FXML
    private VBox contentBox;
    @FXML
    private Text NoVersionAvailable;

    public void Authenticloginbut() {
        route("Authenticlogin.fxml");
    }

    public void Versionsettingsbut() throws IOException {
        route("Versionsettings.fxml");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Versionsettings.fxml"));
        VBox newContent = loader.load();
        contentBox.getChildren().setAll(newContent.getChildren());
        Versionsettings controller = loader.getController();
        controller.VersVbox = contentBox;
        controller.VersTings();
        RouteSwitchingAnimation(contentBox);
    }

    public void ModDownloadbut() {
        route("ModDownload.fxml");
    }

    public void helpbut() {
        route("help.fxml");
    }

    public void setupbut() {
        route("setup.fxml");
    }

    private void route(String fxmlFile) {
        try {
            VBox newContent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
            contentBox.getChildren().setAll(newContent.getChildren());
            RouteSwitchingAnimation(contentBox);
        } catch (IOException e) {
            System.err.println("Route Err: " + e);
        }
    }

    private void RouteSwitchingAnimation(VBox node) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(400), node);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    @FXML
    private void Startgamesbut(ActionEvent event) throws IOException, LaunchException {
        Versionsettings view = new Versionsettings();
        if (OfflineNickname.getText().isEmpty()) {
            CustomDialog.showPopup("昵称不能为空！");
            NoVersionAvailable.setText(view.getSelectedDirectory());
        } else {
            if (view.getSelectedDirectory().equals("0")) {
                CustomDialog.showPopup("未发现版本");
                NoVersionAvailable.setText("当前没有版本");
            } else {
                NoVersionAvailable.setText(view.getSelectedDirectory());
                MinecraftDirectory dir = new MinecraftDirectory(".minecraft");
                Launcher launcher = LauncherBuilder.buildDefault();
                launcher.launch(new LaunchOption(view.getSelectedDirectory(), new OfflineAuthenticator(OfflineNickname.getText()), dir));
                CustomDialog.showPopup("正在启动");
            }
        }
    }
}
