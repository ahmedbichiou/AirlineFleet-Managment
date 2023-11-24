package com.mycompany.login;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class Page_LoginController implements Initializable {

    @FXML
    private ImageView logo_notre_entreprise;
  @FXML
    private TextField test;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         test.setText("Default Text");
    showImage();
    }
    
    
    public void showImage() {
    try {

        Image image = new Image("../Images/1.png");
        logo_notre_entreprise.setImage(image);
       logo_notre_entreprise.setCache(true);
    } catch (Exception e) {
       System.out.println(e.getMessage());
    }
}}
  
    
 


