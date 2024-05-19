module com.mcxb.ysxb.mcxb {
    requires javafx.controls;
    requires javafx.fxml;
    requires jmccc.mcdownloader;
    requires jmccc;
    requires jdk.compiler;
    requires java.desktop;


    opens com.mcxb.ysxb to javafx.fxml;
    exports com.mcxb.ysxb;
}