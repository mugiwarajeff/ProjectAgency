package application;
import java.io.IOException;

import application.classes.AgencyBank;
import application.classes.ManagerBank;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class App extends Application {
    public static AgencyBank  agencyBank = new AgencyBank();
    public static ManagerBank managerBank = new ManagerBank();
    
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException{

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Scenes/Scenes.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root); //setting colors in out scene
        //Image icon = new Image("images/instagram-logo.png"); comentario qualquer
    
        primaryStage.setTitle("Agency");
        primaryStage.setResizable(false);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
