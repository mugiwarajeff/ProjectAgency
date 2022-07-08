package application.controllers;

import java.io.IOException;

import application.App;
import application.classes.Manager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ManagerInputController {
    
    @FXML 
    private TextField inputManagerName;

    @FXML
    private TextField inputManagerLast;

    @FXML
    private TextField inputManagerCPF;

    @FXML
    public void closeManagerInput(ActionEvent e) throws IOException{

        Stage managerInput = ConfigController.getManagerInput();
        managerInput.close();
    }

    @FXML
    public void registerManager(ActionEvent e) throws IOException{

        Manager manager = new Manager(inputManagerName.getText(), inputManagerLast.getText(), inputManagerCPF.getText());
        App.managerBank.insert(manager);
        App.managerBank.report();
        System.out.println(manager.getCpf());
    }
}
