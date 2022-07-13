package application.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Parent;
import javafx.scene.control.Label;

public class MainController implements Initializable{ 

    @FXML
    AnchorPane contentHome;

    @FXML
    private Label totalRegisters;

    @FXML 
    private Label totalCommum;

    @FXML
    private Label totalEspecial;
    

    @FXML
    public void switchToShow(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../../Scenes/View.fxml"));
        Parent root = loader.load();
        contentHome.getChildren().clear();
        contentHome.getChildren().add(root);
    }

    @FXML
    public void switchToHome(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../../Scenes/Home.fxml"));
        Parent root = loader.load();
        contentHome.getChildren().clear();
        contentHome.getChildren().add(root);
    }

    @FXML
    public void switchToConfig(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../../Scenes/Configs.fxml"));
        Parent root = loader.load();
        contentHome.getChildren().clear();
        contentHome.getChildren().add(root);
    }

    @FXML
    public void loadHome() throws IOException{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../../Scenes/Home.fxml"));
        Parent root = loader.load();
        contentHome.getChildren().clear();
        contentHome.getChildren().add(root);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        totalRegisters.setText(Integer.toString(App.agencyBank.getBankLenght()));
        totalCommum.setText(Integer.toString(App.agencyBank.getBankCommumLenght()));
        totalEspecial.setText(Integer.toString(App.agencyBank.getBankEspecialLenght()));    
    }
}
