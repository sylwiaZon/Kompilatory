package Logo;

import Logo.Compiler.Compiler;
import Logo.Compiler.TurtleSituation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.*;


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
            System.out.println(canvas.getHeight());
            System.out.println(canvas.getWidth());
            situation = Compiler.compile(commands.getText().toUpperCase(), canvas, situation);
            if(mainPane.getChildren().size()>2){
                mainPane.getChildren().remove(mainPane.getChildren().size()-1);
            }
            Image img = new Image(setImage(0));
            setColor(situation.backgroundColor);
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

    private void setColor(Color color){
        if(color == BLACK){
            canvas.getParent().setStyle("-fx-background-color: black");
        } else if(color == PINK){
            canvas.getParent().setStyle("-fx-background-color: #ff00a0");
        }else if(color == AZURE){
            canvas.getParent().setStyle("-fx-background-color: #c2eeff");
        }else if(color == RED){
            canvas.getParent().setStyle("-fx-background-color: red");
        }else if(color == SALMON){
            canvas.getParent().setStyle("-fx-background-color: salmon");
        }else if(color == GREENYELLOW){
            canvas.getParent().setStyle("-fx-background-color: greenyellow");
        }else if(color == LAVENDER){
            canvas.getParent().setStyle("-fx-background-color: #bea1fa");
        }else if(color == CORNFLOWERBLUE){
            canvas.getParent().setStyle("-fx-background-color: cornflowerblue");
        }else if(color == ROYALBLUE){
            canvas.getParent().setStyle("-fx-background-color: royalblue");
        }else if(color == GAINSBORO){
            canvas.getParent().setStyle("-fx-background-color: #868686");
        }else if(color == WHITE){
            canvas.getParent().setStyle("-fx-background-color: white");
        }
    }

    private String setImage(int num){
        String path = "file:" + System.getProperty("user.dir").replace('\\', '/') + "/src/Logo";
        if(num == 0){
            path += "/szmuc.png";
        }
        System.out.println(path);
        return path;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        situation = new TurtleSituation();
    }
}
