package com.mcxb.ysxb.MCXBCore;

import com.mcxb.ysxb.MCXBCore.download.DownlodeCore;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Alert;

import java.io.File;

public class McxbCore {
    public boolean Core(String MinecraftV) {
        File file =new File(".minecraft/versions/" + MinecraftV);
        if  (!file.exists()  && !file.isDirectory()){
            DownlodeCore core = new DownlodeCore();
            core.setMinecraftV(MinecraftV);
            core.CoreDownload();
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!!!");
            alert.setHeaderText(null);
            alert.setContentText(MinecraftV + "版本已存在");
            alert.showAndWait();
            return false;
        }
    }
}
