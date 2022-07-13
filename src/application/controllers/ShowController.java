package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.App;
import application.classes.Agency;
import application.classes.infoBar;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
    private static int indexSelected = 0;

    
    @FXML
    private ListView showArea;

    @FXML 
    private Pane mainPane;

    @FXML 
    Label agencyNameLabel;
    
    @FXML
    private TextField agencyInputName;



    private infoBar[] transformItensInParents(Agency[] a) throws IOException{
        infoBar[] returnParents = new infoBar[App.agencyBank.getBankLenght()];

        showArea.setOnMouseClicked(new EventHandler<Event>() {
            
            @Override
            public void handle(Event event){
                indexSelected = showArea.getSelectionModel().getSelectedIndex();
            }
        });
       

        for (int i = 0; i < returnParents.length; i++){
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../../Scenes/infoBar.fxml"));
            AnchorPane root = loader.load();
            Label label = new Label(a[i].getName());
            label.setTextFill(Color.WHITE);
            label.setFont(Font.font("System", 15));
            root.getChildren().set(1, label);
            //returnParents[i] = root;
            infoBar bar = new infoBar(i, root, a[i]);
            returnParents[i] = bar;
            

            System.out.println(root.getChildren().get(1));

        }

        return returnParents;
    }

    public void showUpdate(ActionEvent e) throws IOException{
        Agency[] bankItens = App.agencyBank.getBankItens();
        infoBar[] bankItens2 = transformItensInParents(bankItens);

        for (int i = 0; i < bankItens2.length; i++){
            showArea.getItems().add(bankItens2[i].getParent());
        }

        

        System.out.println(showArea);
        System.out.println(showArea.getSelectionModel().getSelectedIndex());


    }

    @FXML
    public void updateSelectedItem() {
        System.out.println("Estou no update Selected Item");
        System.out.println(indexSelected);
        System.out.println(showArea);
        //indexSelected = this.showArea.getSelectionModel().getSelectedIndex();
    }

    @FXML
    public void showAgency(Event e)throws IOException, InterruptedException{

        Agency a = App.agencyBank.getBankItens()[indexSelected];

            name = a.getName();
            CNPJ = a.getCNPJ();
            publicplace = a.getAdress().getPlace();
            number = String.valueOf(a.getAdress().getNumber()); 

            if (a.getManager().getName() == null){
                manager = "";
            }else{
                manager = a.getManager().getName();
            }


            postalCode = a.getAdress().getCode();
            especial = a.getCampaign().getTime() != "";
            description = a.getCampaign().getDescription();
            value = a.getCampaign().getValue();
            code = a.getCampaign().getCode();
            time = a.getCampaign().getTime();


        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../../Scenes/AgencyShow.fxml"));
        Pane root = loader.load();

        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //indexSelected = showArea.getSelectionModel().getSelectedIndex();
        //showArea.getItems().addAll(transformItensInParents(App.agencyBank.getBankItens()));
    }
    

}
