package application.controllers;

import java.awt.Event;
import java.io.IOException;

import application.App;
import application.classes.Agency;
import application.classes.infoBar;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ShowController{

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
    static int indexSelected = 0;

    
    @FXML
    private ListView showArea;

    @FXML 
    private Pane mainPane;

    @FXML 
    Label agencyNameLabel;
    
    @FXML
    private TextField agencyInputName;

    private static Stage stageShow = new Stage();


    public static Stage getStageShow(){
        return stageShow;
    }
    private infoBar[] transformItensInParents(Agency[] a) throws IOException{
        infoBar[] returnParents = new infoBar[App.agencyBank.getBankLenght()];

        this.showArea.setOnMouseClicked(new EventHandler<Event>() {
            
            @Override
            public void handle(Event event){
                indexSelected = showArea.getSelectionModel().getSelectedIndex();
                try {
                    this.showAgency();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            private void showAgency() throws IOException {
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
        
        
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../../Scenes/AgencyShow.fxml"));
                Pane root = loader.load();
        
                Scene scene = new Scene(root);
                stageShow.setScene(scene);
                stageShow.show();
        
            }
        });
       

        for (int i = 0; i < returnParents.length; i++){
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../../Scenes/infoBar.fxml"));
            AnchorPane root = loader.load();
            Label label = new Label(a[i].getName());
            label.setTextFill(Color.WHITE);
            label.setFont(Font.font("System", 15));
            root.getChildren().set(1, label);
            infoBar bar = new infoBar(i, root, a[i]);
            returnParents[i] = bar;
        }

        return returnParents;
    }
<<<<<<< HEAD
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
=======
>>>>>>> infoBar

    public void showUpdate() throws IOException{
        
        showArea.getItems().clear();

        Agency[] bankItens = App.agencyBank.getBankItens();
        infoBar[] bankItens2 = transformItensInParents(bankItens);

        for (int i = 0; i < bankItens2.length; i++){
            showArea.getItems().add(bankItens2[i].getParent());
        }
    }

}
