package application.classes;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;

public class InfoBar {
    private String name = "generico";
    private Parent parent;
    private FXMLLoader loader;
    private Agency a;
    
    @FXML
    private Label agencyNameLabel;

    public InfoBar(Agency a) throws IOException{
        this.loader = new FXMLLoader(this.getClass().getResource("../../Scenes/infoBar.fxml"));
        this.parent = loader.load();
        this.a = a;
    }

    public Parent getParent(){
        return parent;
    }

    public Agency getAgency(){
        return a;
    }

    public void setName(String name){
        this.name = name;
        this.agencyNameLabel.setText(name);
    }


  



}
