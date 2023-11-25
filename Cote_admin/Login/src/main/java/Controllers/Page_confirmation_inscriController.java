/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import com.mycompany.login.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Spray
 */



public class Page_confirmation_inscriController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private ImageView img_confirmation;
          @FXML
    private Button btn_menu;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showImage();
        styleclasses();
    }   
    
    public void openLogin() throws Exception {
        App.openLogin();
        
        
    }
     //Utilities  
   public void showImage() {
    try {

        Image image = new Image("Images/confirmation_inscri.png");
        img_confirmation.setImage(image);
       
      
    } catch (Exception e) {
       System.out.println(e.getMessage());
    }
}
   
   private void styleclasses()
    {
        
            btn_menu.getStyleClass().add("btn_menu");
    }
}
