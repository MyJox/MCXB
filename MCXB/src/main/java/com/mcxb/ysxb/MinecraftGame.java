package com.mcxb.ysxb;

import com.mcxb.ysxb.MCXBCore.McxbCore;
import com.mcxb.ysxb.MCXBCore.download.DownlodeCore;
import com.mcxb.ysxb.Tool.CoreCoreTools;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.to2mbn.jmccc.auth.OfflineAuthenticator;
import org.to2mbn.jmccc.launch.LaunchException;
import org.to2mbn.jmccc.launch.Launcher;
import org.to2mbn.jmccc.launch.LauncherBuilder;
import org.to2mbn.jmccc.option.LaunchOption;
import org.to2mbn.jmccc.option.MinecraftDirectory;
import java.io.IOException;
import java.util.Optional;

public class MinecraftGame {
    @FXML
    public AnchorPane root;

    private String MinecraftV = "0.0.0";

    @FXML
    private ComboBox<String> SelectVersion;

    @FXML
    private ComboBox<String> DownloadVersion;

    private final String[] DownloadVersionLOT = {"1.20.0", "1.20.1", "1.20.2", "1.20.3"};

    @FXML
    private void handleComboBoxAction(ActionEvent event) {
        String selectedVersion = SelectVersion.getSelectionModel().getSelectedItem();
        setMinecraftV(selectedVersion);
        System.out.println("选择的版本: " + selectedVersion);
        setMinecraftV(selectedVersion);
    }

    @FXML
    public void CoreDownload() {
        String selectedVersion = DownloadVersion.getSelectionModel().getSelectedItem();
        setMinecraftV(selectedVersion);
        System.out.println("下载的版本: " + selectedVersion);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Minecraft " + selectedVersion + " 下载");
        alert.setHeaderText("Minecraft版本：" + selectedVersion);
        alert.setContentText("您确定要下载Minecraft版本：" + selectedVersion + "吗？");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.out.println("确认下载：" + selectedVersion);
            setMinecraftV(selectedVersion);
            McxbCore core = new McxbCore();
            core.Core(MinecraftV);

            Alert Downloadingalert = new Alert(Alert.AlertType.INFORMATION);
            Downloadingalert.setTitle("正在下载Minecraft");
            Downloadingalert.setContentText("正在下载Minecraft：" + selectedVersion);
            Downloadingalert.showAndWait();
        } else {
            System.out.println("取消下载");
        }

    }

    public void initialize() {
        CoreCoreTools coreCoreTools = new CoreCoreTools();
        // 获取版本列表
        ObservableList<String> SelectVersionVersions = coreCoreTools.CoreVersionOutput();
        SelectVersion.setItems(SelectVersionVersions);

        ObservableList<String> options = FXCollections.observableArrayList(DownloadVersionLOT);
        DownloadVersion.setItems(options);
    }

    @FXML
    private void MinecraftGames(ActionEvent event) throws IOException, LaunchException {
        if (MinecraftV.equals("0.0.0")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!!!");
            alert.setHeaderText(null);
            alert.setContentText("请选择有效的版本");
            alert.showAndWait();
        } else {
            MinecraftDirectory dir = new MinecraftDirectory(".minecraft");
            Launcher launcher = LauncherBuilder.buildDefault();
            launcher.launch(new LaunchOption(MinecraftV, new OfflineAuthenticator("abc"), dir));
            System.out.println("YES Minecraft" + getMinecraftV());
        }
    }

    public String getMinecraftV() {
        return MinecraftV;
    }

    public void setMinecraftV(String minecraftV) {
        MinecraftV = minecraftV;
    }
}
