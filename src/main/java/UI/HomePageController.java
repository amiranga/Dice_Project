package UI;

import PD.DiceGame;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HomePageController {
    @FXML
    public Text result;
    @FXML
    private TextField nDices;
    @FXML
    private TextField nFaces;

    @FXML
    protected void onReset() {
        result.setText("");
        nDices.setText("");
        nFaces.setText("");
    }

    @FXML
    protected void onPlay() {
        DiceGame diceGame = new DiceGame(nDices.getText(), nFaces.getText());
        diceGame.play();
        result.setText(diceGame.GetGameResult());
    }
}