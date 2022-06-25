package application;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;



public class App extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException{
        //Group root = new Group();

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Scenes/Scenes.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);


        primaryStage.setTitle("Hello World!!"); //setting the titles of stage
        primaryStage.setResizable(false);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
