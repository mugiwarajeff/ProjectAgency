package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AgencySearchShowController implements Initializable{

    @FXML
    private ChoiceBox<String> managerChoice2;

    @FXML
    private TextField agencyInputName2;

    @FXML 
    private TextField agencyInputCNPJ2;

    @FXML
    private TextField adressInputPlace2;

    @FXML 
    private TextField adressInputNumber2;

    @FXML 
    private TextField adressInputPostal2;

    @FXML 
    private TextArea campaingInputDescription2;

    @FXML
    private TextField campaingInputValue2;

    @FXML
    private TextField campaignInputCode2;

    @FXML 
    private TextField vinhetaInputTime2;

    @FXML
    private CheckBox especialInput2;

    

    @FXML
    public void load(){
        Stage stageToClose = MainController.stageShow;

        try{
            agencyInputName2.setText(MainController.agencySearchShow.getName());
            agencyInputCNPJ2.setText(MainController.agencySearchShow.getCNPJ());
            adressInputNumber2.setText(String.valueOf(MainController.agencySearchShow.getAdress().getNumber()));
            adressInputPostal2.setText(MainController.agencySearchShow.getAdress().getCode());
            adressInputPlace2.setText(MainController.agencySearchShow.getAdress().getPlace());
            campaingInputDescription2.setText(MainController.agencySearchShow.getCampaign().getDescription());
            campaingInputValue2.setText(MainController.agencySearchShow.getCampaign().getValue());
            campaignInputCode2.setText(MainController.agencySearchShow.getCampaign().getCode());
            vinhetaInputTime2.setText(MainController.agencySearchShow.getCampaign().getTime());
            especialInput2.setSelected(true);
            managerChoice2.setValue(MainController.agencySearchShow.getManagerName());
            stageToClose.show();

        }catch(Exception e){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Agency not found");
            alert.setHeaderText("Your agency is not found, try again or register a new agency");
            alert.showAndWait();
            
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        load();
    }
}
