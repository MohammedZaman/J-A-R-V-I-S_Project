package sample;

import animatefx.animation.SlideInLeft;
import animatefx.animation.SlideOutDown;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @FXML
    private Rectangle projectsBtn;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        root.getStylesheets().add("home.css");
        primaryStage.setTitle("J.A.R.V.I.S");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMaximized(true);
        primaryStage.setFullScreen(true);
        Image image = new Image("images/curser.png");  //pass in the image path
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
