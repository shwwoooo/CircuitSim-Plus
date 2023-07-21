module com.yudit {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens com.yudit to javafx.fxml;
    exports com.yudit;
}
