package Controllers;



import com.mycompany.login.App;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Page_LoginController implements Initializable {

    @FXML
    private ImageView logo_notre_entreprise;
    @FXML
    private TextField nom_login;
    @FXML
    private TextField password_login;
    @FXML
    private Button btn_login;
    @FXML
    private Rectangle main_rectangle;
    @FXML
    private Button btn_creation;
    @FXML
    private Text login_label;
    @FXML
    private ImageView Image_User;
    @FXML
    private Circle Image_circle;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    Image_circle.setOpacity(0);        
    hints();        
    styleclasses();        
    showImage();
  
    }
    public  void image_username()
    {
        
        if(nom_login.getText().toString().equals("Tunisair"))
        {

       logo_notre_entreprise.setOpacity(0);
       Image image = new Image("Images/Tunisair.png");
       Image_User.setImage(image);
       Image_circle.setOpacity(0.5);  

    
        }
        else
        {
       logo_notre_entreprise.setOpacity(1);
       Image_User.setOpacity(0); 
       Image_circle.setOpacity(0);  
        }
    } //switch
    
    
  //Utilities  
   public void showImage() {
    try {

        Image image = new Image("Images/login.png");
        logo_notre_entreprise.setImage(image);
       
      
    } catch (Exception e) {
       System.out.println(e.getMessage());
    }
}
  
   public void openInscrir() throws Exception {
        App.openInscrir();
    }
   
   public void openmenu_principal_admin() throws Exception {
        App.openmenu_principal_admin();
    }
   private void hints() 
    {
        nom_login.setPromptText("Enter votre nom");
        password_login.setPromptText("Enter votre mot de passe");
    }
    private void styleclasses()
    {
            btn_login.getStyleClass().add("btn_login");
            main_rectangle.getStyleClass().add("main_rectangle");
            btn_creation.getStyleClass().add("btn_creation"); 
            nom_login.getStyleClass().add( "text-field-custom");
            password_login.getStyleClass().add( "text-field-custom");
    }
}
  

