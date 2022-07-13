package application.classes;

import javafx.scene.Parent;

public class infoBar {
    int id;
    Parent root;
    Agency agency;

    public infoBar(int id, Parent root, Agency agency){
        this.id = id;
        this.root = root;
        this.agency = agency;
    }

    public Parent getParent(){
        return this.root;
    }
}
