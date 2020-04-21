package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.net.URI;
import java.util.List;

public class Main extends Application {

    @FXML
    private Rectangle projectsBtn;



    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
//        root.getStylesheets().add("home.css");
//        primaryStage.setTitle("J.A.R.V.I.S");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.setMaximized(true);
//        primaryStage.setFullScreen(true);
//        Image image = new Image("images/curser.png");  //pass in the image path
//
//
//        primaryStage.show();
//                getHostServices().showDocument("http://127.0.0.1:8081/examples/webgl_loader_obj.html");
//

        Screen primaryScreen = Screen.getPrimary();

        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        Rectangle2D bounds = primaryScreen.getBounds();
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        primaryStage.setMaximized(true);
        primaryStage.setFullScreen(true);
        primaryStage.show();
        primaryStage.setTitle("J.A.R.V.I.S");

        //Screen secondaryScreen  = Screen.getScreens().get(1);



//        if(secondaryScreen!=null){
//            Stage secondaryStage = new Stage();
//            Parent root2 = FXMLLoader.load(getClass().getResource("home.fxml"));
//            Scene scene2 = new Scene(root2);
//            secondaryStage.setScene(scene2);
//            Rectangle2D bounds2 = secondaryScreen.getBounds();
//            secondaryStage.setX(bounds2.getMinX());
//            secondaryStage.setY(bounds2.getMinY());
//            secondaryStage.setWidth(bounds2.getWidth());
//            secondaryStage.setHeight(bounds2.getHeight());
//            secondaryStage.initStyle(StageStyle.UNDECORATED);
//            secondaryStage.setFullScreen(true);
//            secondaryStage.setMaximized(true);
//            secondaryStage.setTitle("J.A.R.V.I.S");
//            secondaryStage.show();
//
//        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
