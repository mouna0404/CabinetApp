/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinetapp;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author MouNa
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label=new Label();
    @FXML
    private Button btn;
    @FXML
    private TextField l=new TextField();;
    @FXML
    private PasswordField p=new PasswordField();
    
    
    @FXML
    private void Connecter(ActionEvent event) throws SQLException, IOException {
      String qr;
        ResultSet rs;
        qr="Select* from user where password='"+p.getText()+"' and login='"+l.getText()+"'";
        CabinetApp cp=new CabinetApp();
        PreparedStatement stmt = cp.getC().prepareStatement(qr);
        rs = stmt.executeQuery(); 
  if(rs.next()) 
   {
      
       if (rs.getString("role").equals("Médecin"))
       {   Parent root1 = FXMLLoader.load(getClass().getResource("FXMHomePageM.fxml"));
           Scene scene1 = new Scene(root1);
           Stage s=(Stage)((Node) event.getSource()).getScene().getWindow();
           s.setScene(scene1); 
           s.show();
           System.out.println("medddddd");
       }
       else if(rs.getString("role").equals("Secretaire")) 
       {
           Parent root1 = FXMLLoader.load(getClass().getResource("FXMHomePageS.fxml"));
           Scene scene1 = new Scene(root1);
           Stage s=(Stage)((Node) event.getSource()).getScene().getWindow();
           s.setScene(scene1); 
           s.show();
       }
   }
  else 
       {
          
             label.setText("Password ou Login est incorrect !!!");
              
       }

        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
