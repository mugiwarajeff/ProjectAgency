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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    public void closeAgencyInput() throws IOException{

        Stage agencyInput = ConfigController.getAgencyInput();
        agencyInput.close();
    }

    @FXML
    public void agencyRegister(ActionEvent e) throws IOException{
        if(agencyInputName.getText().trim().isEmpty()||agencyInputCNPJ.getText().trim().isEmpty()||campaingInputDescription.getText().trim().isEmpty()||campaingInputValue.getText().trim().isEmpty()||campaignInputCode.getText().trim().isEmpty()|| managerChoice.getValue()== null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Complete todos os campos obrigatórios*");
            alert.show();
            }else{
                if(adressInputPlace.getText().trim().isEmpty()||adressInputNumber.getText().trim().isEmpty()||adressInputPostal.getText().trim().isEmpty()){
                    Adress adress = new Adress("",0, "");
                
                    if(especialInput.isSelected()){
                        if(vinhetaInputTime.getText().trim().isEmpty()){
                        Vinheta vinheta = new Vinheta(campaingInputDescription.getText(), Double.parseDouble(campaingInputValue.getText()), Integer.parseInt(campaignInputCode.getText()), 0.0);
                        EspecialAgency especialAgency = new EspecialAgency(agencyInputName.getText(), agencyInputCNPJ.getText(), adress, App.managerBank.search(managerChoice.getValue()), vinheta);

                        App.agencyBank.insert(especialAgency);
                        System.out.println(especialAgency);
                        }else{
                            Vinheta vinheta = new Vinheta(campaingInputDescription.getText(), Double.parseDouble(campaingInputValue.getText()), Integer.parseInt(campaignInputCode.getText()), Double.parseDouble(vinhetaInputTime.getText()));
                        EspecialAgency especialAgency = new EspecialAgency(agencyInputName.getText(), agencyInputCNPJ.getText(), adress, App.managerBank.search(managerChoice.getValue()), vinheta);

                        App.agencyBank.insert(especialAgency);
                        System.out.println(especialAgency);
                        }
                        }else{
                            Commum commum = new Commum(campaingInputDescription.getText(), Double.parseDouble(campaingInputValue.getText()), Integer.parseInt(campaignInputCode.getText()));
                            CommumAgency commumAgency = new CommumAgency(agencyInputName.getText(), agencyInputCNPJ.getText(), adress, App.managerBank.search(managerChoice.getValue()), commum);

                            App.agencyBank.insert(commumAgency);
                        }


                        Stage agencyInput = ConfigController.getAgencyInput();
                        agencyInput.close();
                    }else{
                        Adress adress = new Adress(adressInputPlace.getText(), Integer.parseInt(adressInputNumber.getText()), adressInputPostal.getText());
                        if(especialInput.isSelected()){
                            if(vinhetaInputTime.getText().trim().isEmpty()){
                                Vinheta vinheta = new Vinheta(campaingInputDescription.getText(), Double.parseDouble(campaingInputValue.getText()), Integer.parseInt(campaignInputCode.getText()), 0.0);
                                EspecialAgency especialAgency = new EspecialAgency(agencyInputName.getText(), agencyInputCNPJ.getText(), adress, App.managerBank.search(managerChoice.getValue()), vinheta);
        
                                App.agencyBank.insert(especialAgency);
                                System.out.println(especialAgency);
                                }else{
                                    Vinheta vinheta = new Vinheta(campaingInputDescription.getText(), Double.parseDouble(campaingInputValue.getText()), Integer.parseInt(campaignInputCode.getText()), Double.parseDouble(vinhetaInputTime.getText()));
                                EspecialAgency especialAgency = new EspecialAgency(agencyInputName.getText(), agencyInputCNPJ.getText(), adress, App.managerBank.search(managerChoice.getValue()), vinheta);
        
                                App.agencyBank.insert(especialAgency);
                                System.out.println(especialAgency);
                                }
                            }else{
                                Commum commum = new Commum(campaingInputDescription.getText(), Double.parseDouble(campaingInputValue.getText()), Integer.parseInt(campaignInputCode.getText()));
                                CommumAgency commumAgency = new CommumAgency(agencyInputName.getText(), agencyInputCNPJ.getText(), adress, App.managerBank.search(managerChoice.getValue()), commum);
    
                                App.agencyBank.insert(commumAgency);
                            }
                            Stage agencyInput = ConfigController.getAgencyInput();
                            agencyInput.close();

                    }
                }
            } //fecha ao registrar
        
    

    @FXML
    public void timeToggle(ActionEvent e){
        if (especialInput.isSelected()){
            vinhetaInputTime.setDisable(false);
        }else {
            vinhetaInputTime.setDisable(true);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        managerChoice.getItems().addAll(App.managerBank.getManagersNames());
        vinhetaInputTime.setDisable(true);
    }
}
