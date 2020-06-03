package Logo;

import Logo.Compiler.Compiler;
import Logo.Compiler.TurtleSituation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextArea;


public class Controller implements Initializable {
    private TurtleSituation situation;
    @FXML
    private TextArea commands;

    @FXML
    private Canvas canvas;

    @FXML
    public void draw(ActionEvent event) {
        try {
            situation = Compiler.compile(commands.getText().toUpperCase(), canvas, situation);
        } catch (Exception e) {
            e.printStackTrace();
        }
        commands.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        situation = new TurtleSituation();
    }
}
