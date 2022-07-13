package application.controllers;

import java.awt.Event;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.App;
import application.classes.Agency;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ShowController implements Initializable{

    public static String name;
    public static String CNPJ;
    public static String publicplace;
    public static String postalCode;
    public static String number;
    public static String manager;
    public static boolean especial;
    public static String description;
    public static String value;
    public static String code;
    public static String time;

    
    @FXML
    private ListView showArea;

    @FXML 
    private Pane mainPane;

    @FXML 
    Label agencyNameLabel;
    
    @FXML
    private TextField agencyInputName;

    private Parent[] transformItensInParents(Agency[] a) throws IOException{
        Parent[] returnParents = new Parent[App.agencyBank.getBankLenght()];
       

        for (int i = 0; i < returnParents.length; i++){
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../../Scenes/infoBar.fxml"));
            AnchorPane root = loader.load();
            Label label = new Label(a[i].getName());
            label.setTextFill(Color.WHITE);
            label.setFont(Font.font("System", 15));
            System.out.println(root.getChildren().set(1, label));
            returnParents[i] = root;
            
            name = a[i].getName();
            CNPJ = a[i].getCNPJ();
            publicplace = a[i].getAdress().getPlace();
            number = String.valueOf(a[i].getAdress().getNumber()); 
            if (a[i].getManager().getName() == null){
                manager = "";
            }else{
                manager = a[i].getManager().getName();
            }
            postalCode = a[i].getAdress().getCode();
            especial = a[i].getCampaign().getTime() != "";
            description = a[i].getCampaign().getDescription();
            value = a[i].getCampaign().getValue();
            code = a[i].getCampaign().getCode();
            time = a[i].getCampaign().getTime();

        }

        return returnParents;
    }
    public void showUpdate(ActionEvent e) throws IOException{
        Agency[] bankItens = App.agencyBank.getBankItens();
        showArea.getItems().addAll(transformItensInParents(bankItens));


    }

    @FXML
    public void showAgency()throws IOException{

        System.out.println("evento");
        Agency a = App.agencyBank.search("jefferson");
        System.out.println(a);
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../../Scenes/AgencyShow.fxml"));
        Pane root = loader.load();

        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //showArea.getItems().addAll(transformItensInParents(App.agencyBank.getBankItens()));
    }

}
