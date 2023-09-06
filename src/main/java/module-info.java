module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens PD to javafx.fxml;
    exports PD;
    exports UI;
    opens UI to javafx.fxml;
    exports Test;
    opens Test to javafx.fxml;
}