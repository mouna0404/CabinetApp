/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinetapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MouNa
 */
public class FXMHomePageMController implements Initializable {
   @FXML
   private Button gu;
   @FXML
   private Button gc;
   @FXML
public void gestion_user(ActionEvent event) throws IOException
    {
           
           Parent user = FXMLLoader.load(getClass().getResource("FXMGUM.fxml"));
           Scene scene2 = new Scene(user);
           Stage s=(Stage)((Node) event.getSource()).getScene().getWindow();
           s.setScene(scene2); 
           s.show();
           
    }
@FXML
public void gestion_consultation(ActionEvent event) throws IOException
    {
           
           Parent user = FXMLLoader.load(getClass().getResource("FXMGCM.fxml"));
           Scene scene2 = new Scene(user);
           Stage s=(Stage)((Node) event.getSource()).getScene().getWindow();
           s.setScene(scene2); 
           s.show();
           
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
