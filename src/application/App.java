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
        Scene scene = new Scene(root); //setting colors in out scene
        //Image icon = new Image("images/instagram-logo.png");
    
        primaryStage.setTitle("Hello World!!"); //setting the titles of stage
       
        primaryStage.setResizable(false);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


        //primaryStage.setWidth(420);
        //primaryStage.setHeight(420);
        //primaryStage.setResizable(false);
        //primaryStage.setX(50);
        //primaryStage.setY(50);
        //primaryStage.setFullScreen(true);

            /* 
        //Definindo uma linha
        Line line = new Line();
        line.setStartX(200);
        line.setStartY(200);
        line.setEndX(500);
        line.setEndY(500);
        line.setStrokeWidth(5);
        line.setStroke(Color.BLUEVIOLET);
        line.setOpacity(0.5);
        line.setRotate(135);
        root.getChildren().add(line);

        //Defining a rectangle
        Rectangle rectangle = new Rectangle();
        rectangle.setX(200);
        rectangle.setY(200);
        rectangle.setWidth(100);
        rectangle.setHeight(100);
        rectangle.setFill(Color.BROWN);
        rectangle.setStrokeWidth(5);
        rectangle.setStroke(Color.BLACK);
        root.getChildren().add(rectangle);

        //Defining a triangle
        Polygon triangle = new Polygon();
        triangle.getPoints().setAll(
            400.0,400.0,
            500.0,500.0,
            400.0,500.0
        );
        triangle.setFill(Color.YELLOW);
        root.getChildren().add(triangle);

        //defing a Circle
        Circle circle = new Circle();
        circle.setCenterX(350);
        circle.setCenterY(350);
        circle.setRadius(50);
        circle.setFill(Color.ORANGE);
        root.getChildren().add(circle);
        
        //defining a image;
        Image image = new Image("images/instagram-logo.png");
        ImageView imageView = new ImageView(image);
        imageView.setX(400);
        imageView.setY(400);
        imageView.maxWidth(10.0);
        root.getChildren().add(imageView);

        */