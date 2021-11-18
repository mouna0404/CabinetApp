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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MouNa
 */
public class FXMHomePageSController implements Initializable {
    @FXML
    private Button gp;
    /*@FXML
    private Button gr;
    @FXML
    private Button gf;*/
    
@FXML
private void gestion_patient(ActionEvent event) throws IOException
    {
           
           Parent patient = FXMLLoader.load(getClass().getResource("FXMLGPS.fxml"));
           Scene scene2 = new Scene(patient);
           Stage s=(Stage)((Node) event.getSource()).getScene().getWindow();
           s.setScene(scene2); 
           s.show();
           
    }
    
  /*  private void gestion_facture(ActionEvent event) throws IOException
    {
        
        /*Parent patient = FXMLLoader.load(getClass().getResource("FXMGPS.fxml"));
           Scene scene1 = new Scene(patient);
           Stage s=(Stage)((Node) event.getSource()).getScene().getWindow();
           s.setScene(scene1); 
           s.show();*/

   
   /* private void gestion_rdv(ActionEvent event) throws IOException
    {
        
        /*Parent patient = FXMLLoader.load(getClass().getResource("FXMGPS.fxml"));
           Scene scene1 = new Scene(patient);
           Stage s=(Stage)((Node) event.getSource()).getScene().getWindow();
           s.setScene(scene1); 
           s.show();*/
   // }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }


   
    }
    

