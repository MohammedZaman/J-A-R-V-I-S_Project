package sample.projects;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Project {
//    private HBox topPane;
//    private GridPane leftPane;
//    private GridPane rightPane;
//    private GridPane bottomPanel;

    private ImageView title = new ImageView();
    private List<ImageView> leftPane =  new ArrayList<>();
    private List<ImageView> rightPane  =  new ArrayList<>();
    private List<ImageView> bottomPane  =  new ArrayList<>();


    public void LoadIn(){}
    public void LoadOut(){}
    public void movementOn(){}
    public void movementOff(){}

    public ImageView getTitle() {
        return title;
    }

    public void setTitle(ImageView title) {
        this.title = title;
    }

    public List<javafx.scene.image.ImageView> getLeftPane() {
        return leftPane;
    }

    public void setLeftPane(List<ImageView> leftPane) {
        this.leftPane = leftPane;
    }

    public List<ImageView> getRightPane() {
        return rightPane;
    }

    public void setRightPane(List<ImageView> rightPane) {
        this.rightPane = rightPane;
    }

    public List<ImageView> getBottomPane() {
        return bottomPane;
    }

    public void setBottomPane(List<ImageView> bottomPane) {
        this.bottomPane = bottomPane;
    }




}
