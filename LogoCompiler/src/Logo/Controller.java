package Logo;

import Logo.Compiler.Compiler;
import Logo.Compiler.TurtleSituation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Controller implements Initializable {
    private TurtleSituation situation;
    @FXML
    private TextArea commands;

    @FXML
    private Canvas canvas;

    @FXML
    private BorderPane mainPane;

    @FXML
    public void draw(ActionEvent event) {
        try {
            if(mainPane.getChildren().size()>2){
                mainPane.getChildren().remove(mainPane.getChildren().size()-1);
            }

            situation = Compiler.compile(commands.getText().toUpperCase(), canvas, situation);
            Image img = new Image("file:/Users/pyszczekk/Desktop/Kompilatory/LogoCompiler/src/Logo/szmuc.png");

            //Setting the image view
            ImageView imageView = new ImageView(img);
            imageView.setFitHeight(40);
            imageView.setFitWidth(40);
            //Setting the position of the image
            imageView.setRotate(situation.angle);
            imageView.setX(situation.position.x-20);
            imageView.setY(situation.position.y-20);

            mainPane.getChildren().add(imageView);

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
