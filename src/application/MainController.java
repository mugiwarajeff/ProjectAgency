package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Parent;

public class MainController {

    @FXML
    AnchorPane contentHome;
    

    @FXML
    public void switchToShow(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Scenes/View.fxml"));
        Parent root = loader.load();
        contentHome.getChildren().clear();
        contentHome.getChildren().add(root);
    }

    @FXML
    public void switchToHome(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Scenes/Home.fxml"));
        Parent root = loader.load();
        contentHome.getChildren().clear();
        contentHome.getChildren().add(root);
    }

    @FXML
    public void switchToConfig(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Scenes/Configs.fxml"));
        Parent root = loader.load();
        contentHome.getChildren().clear();
        contentHome.getChildren().add(root);
    }

    @FXML
    public void loadHome() throws IOException{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Scenes/Home.fxml"));
        Parent root = loader.load();
        contentHome.getChildren().clear();
        contentHome.getChildren().add(root);
    }
}
