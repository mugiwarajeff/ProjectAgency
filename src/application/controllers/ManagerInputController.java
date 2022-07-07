package application.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ManagerInputController {
    
    @FXML
    public void closeManagerInput(ActionEvent e) throws IOException{

        Stage managerInput = ConfigController.getManagerInput();
        managerInput.close();
    }
}
