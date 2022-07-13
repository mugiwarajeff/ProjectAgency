package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;



public class AgencyShowController implements Initializable {

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        agencyInputName2.setText(ShowController.name);
        agencyInputCNPJ2.setText(ShowController.CNPJ);
        adressInputNumber2.setText(ShowController.number);
        adressInputPostal2.setText(ShowController.postalCode);
        adressInputPlace2.setText(ShowController.publicplace);
        campaingInputDescription2.setText(ShowController.description);
        campaingInputValue2.setText(ShowController.value);
        campaignInputCode2.setText(ShowController.code);
        vinhetaInputTime2.setText(ShowController.time);
        especialInput2.setSelected(ShowController.especial);
        managerChoice2.setValue(ShowController.manager);

    } 
    
}
