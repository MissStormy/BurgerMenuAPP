module com.burgermenuapp.burgermenuapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.burgermenuapp.burgermenuapp to javafx.fxml;
    exports com.burgermenuapp.burgermenuapp;
}