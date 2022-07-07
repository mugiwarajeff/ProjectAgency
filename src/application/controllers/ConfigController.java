package application.controllers;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ConfigController {
    
    private static Stage managerInput = new Stage();
    private static Stage agencyInput = new Stage();
    
    @FXML
    public void callManagerInput() throws IOException{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../../Scenes/ManagerInput.fxml"));
        Parent root = loader.load();

        Scene sceneManagerInput = new Scene(root);
        managerInput.setScene(sceneManagerInput);
        managerInput.setTitle("Cadastre o seu Gerente");
        managerInput.setResizable(false);
        
        managerInput.show();
    }

    @FXML
    public void callAgencyInput() throws IOException{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../../Scenes/AgencyInput.fxml"));
        Parent root = loader.load();

        Scene sceneAgencyInput = new Scene(root);
        agencyInput.setScene(sceneAgencyInput);
        agencyInput.setTitle("Register your agency");
        agencyInput.setResizable(false);
        agencyInput.show();
    }

    public static Stage getManagerInput(){
        return managerInput;
    }

    public static Stage getAgencyInput(){
        return agencyInput;
    }
}
