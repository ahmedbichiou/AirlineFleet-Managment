package com.mycompany.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
     private static Stage loginStage; 
     private static Stage create_accountStage;

    @Override
     public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_Login.fxml"));
        scene = new Scene(fxmlLoader.load(), 600, 700);
        
         Image icon = new Image("Images/icon_stage.png");
        stage.getIcons().add(icon);
        stage.setTitle("Flight Booking");
        stage.setScene(scene);
        stage.show();
        loginStage = stage;
    }

    public static void main(String[] args) {
        launch();
    }
    
     public static void openNewScene() throws Exception {
         
         
         FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_Creation_Compte.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
         
         
    }

}