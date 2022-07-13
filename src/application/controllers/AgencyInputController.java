package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import application.App;
import application.classes.Adress;
import application.classes.Commum;
import application.classes.CommumAgency;
import application.classes.EspecialAgency;
import application.classes.Vinheta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AgencyInputController implements Initializable {
    @FXML
    private ChoiceBox<String> managerChoice;

    @FXML
    private TextField agencyInputName;

    @FXML 
    private TextField agencyInputCNPJ;

    @FXML
    private TextField adressInputPlace;

    @FXML 
    private TextField adressInputNumber;

    @FXML 
    private TextField adressInputPostal;

    @FXML 
    private TextArea campaingInputDescription;

    @FXML
    private TextField campaingInputValue;

    @FXML
    private TextField campaignInputCode;

    @FXML 
    private TextField vinhetaInputTime;

    @FXML
    private CheckBox especialInput;

    @FXML
    private Button agencyRegisterButton;


    @FXML
    public void closeAgencyInput() throws IOException{

        Stage agencyInput = ConfigController.getAgencyInput();
        agencyInput.close();
    }

    @FXML
    public void agencyRegister(ActionEvent e) throws IOException{
        Adress adress = new Adress(adressInputPlace.getText(), Integer.parseInt(adressInputNumber.getText()), adressInputPostal.getText());
        System.out.println(managerChoice.getValue());

        if(managerChoice.getValue() == null){
            System.out.println("entrei no alert");
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Manager Error");
            alert.setHeaderText("Please select a manager to you agency");
            alert.setContentText("If you don't have registry a manager, please do it on the previous screen");
            alert.showAndWait();
        }else if(false){}else{

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.getButtonTypes().remove(1);
            alert.setTitle("Register Confirmation");
            alert.setHeaderText("Your register has been confirmed");
            alert.showAndWait();

            try {
                if(especialInput.isSelected()){
                    Vinheta vinheta = new Vinheta(campaingInputDescription.getText(), Double.parseDouble(campaingInputValue.getText()), Integer.parseInt(campaignInputCode.getText()), Double.parseDouble(vinhetaInputTime.getText()));
                    EspecialAgency especialAgency = new EspecialAgency(agencyInputName.getText(), agencyInputCNPJ.getText(), adress, App.managerBank.search(managerChoice.getValue()), vinheta);
        
                    App.agencyBank.insert(especialAgency);
                    System.out.println(especialAgency);
                }else{
                    Commum commum = new Commum(campaingInputDescription.getText(), Double.parseDouble(campaingInputValue.getText()), Integer.parseInt(campaignInputCode.getText()));
                    CommumAgency commumAgency = new CommumAgency(agencyInputName.getText(), agencyInputCNPJ.getText(), adress, App.managerBank.search(managerChoice.getValue()), commum);
        
                    App.agencyBank.insert(commumAgency);
                }

                Stage agencyInput = ConfigController.getAgencyInput();
                agencyInput.close(); //fecha ao registrar

            }catch(Exception erro){
                Alert alertError = new Alert(AlertType.ERROR);
                alertError.showAndWait();
            }
           
    
            
        }

        
        
    }

    @FXML
    public void timeToggle(ActionEvent e){
        if (especialInput.isSelected()){
            vinhetaInputTime.setDisable(false);
        }else {
            vinhetaInputTime.setDisable(true);
        }
    }

    @FXML void registerToggle(ActionEvent e){
        System.out.println("entrei no register toggle");
        if (managerChoice.getValue() == ""){
            agencyRegisterButton.setDisable(false);
        }
        else {
            agencyRegisterButton.setDisable(false);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        managerChoice.getItems().addAll(App.managerBank.getManagersNames());
        vinhetaInputTime.setDisable(true);
    }
}
