module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cs.game.dice.roller.app to javafx.fxml;
    exports com.cs.game.dice.roller.app;
}