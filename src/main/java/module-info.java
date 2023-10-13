module com.example.circuitsimplus {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.circuitsimplus to javafx.fxml;
    exports com.example.circuitsimplus;
}