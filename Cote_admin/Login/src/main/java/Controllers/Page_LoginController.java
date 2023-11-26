package Controllers;



import com.mycompany.login.App;
import Classes.Compagnie_aerienne;
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
    public static Compagnie_aerienne compte_ouvert;
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
    private Text Error_text;
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
        
      switch (nom_login.getText().toString()) {
    case "Tunisair":
        if(App.searchCompagnieByNom("Tunisair") != null)
        {
        logo_notre_entreprise.setOpacity(0);
        Image imageTunisair = new Image("Images/Tunisair.png");
        Image_User.setImage(imageTunisair);
        Image_User.setOpacity(1);
        Image_circle.setOpacity(0.5);
        }
       
        break;

    case "AirFrance":
        if(App.searchCompagnieByNom("AirFrance") != null)
        {
        logo_notre_entreprise.setOpacity(0);
        Image imageAirFrance = new Image("Images/Airlines/AirFrance.png");
        Image_User.setImage(imageAirFrance);
        Image_User.setOpacity(1);
        Image_circle.setOpacity(0.5);
        }
        break;

    case "Transavia":
        if(App.searchCompagnieByNom("Transavia") != null)
        {
        logo_notre_entreprise.setOpacity(0);
        Image imageTransavia = new Image("Images/Airlines/Transavia.png");
        Image_User.setImage(imageTransavia);
        Image_User.setOpacity(1);
        Image_circle.setOpacity(0.5);
        }
        break;

    case "TurkishAirlines":
        if(App.searchCompagnieByNom("TurkishAirlines") != null)
        {
        logo_notre_entreprise.setOpacity(0);
        Image imageTurkishAirlines = new Image("Images/Airlines/TurkishAirlines.png");
        Image_User.setImage(imageTurkishAirlines);
        Image_User.setOpacity(1);
        Image_circle.setOpacity(0.5);
        }
        break;

    default:
        logo_notre_entreprise.setOpacity(1);
        Image_User.setOpacity(0);
        Image_circle.setOpacity(0);
        break;
}
    }
    
    
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
   
    public   void openmenu_principal_admin() throws Exception {
       
       try {
           
          
           if(App.searchCompagnieByNom(nom_login.getText().toString())!= null)
                   {
                      if (App.searchCompagnieByNom(nom_login.getText().toString()).getmot_pass().equals(password_login.getText())) {
                                    
                                    compte_ouvert =App.searchCompagnieByNom(nom_login.getText().toString());
                                     App.openmenu_principal_admin();
                    } else {
                                    
                                    Error_text.setText("Mot de pass invalide");
                    } 
                   }
           else
           {
           Error_text.setText("Compte invalide");  
           }
   
} catch (Exception e) {
    System.err.println("An error occurred: " + e.getMessage());
}
       
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
    
     public static Compagnie_aerienne getCompte_ouvert() {
        return compte_ouvert;
    }

    public void setCompte_ouvert(Compagnie_aerienne compte_ouvert) {
        this.compte_ouvert = compte_ouvert;
    }
}
  

