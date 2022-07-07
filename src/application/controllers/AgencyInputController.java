package application.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AgencyInputController {
    
    @FXML
    public void closeAgencyInput() throws IOException{

        Stage agencyInput = ConfigController.getAgencyInput();
        agencyInput.close();
    }
}
