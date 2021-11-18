
package cabinetapp;

import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
public class FXMLGPSController implements Initializable {
    @FXML
    private TableView<Patient> t;
    @FXML
     private TableColumn<Patient,String> ncin_c;       
    @FXML
     private TableColumn<Patient,String> nom_c;
    @FXML
     private TableColumn<Patient,String> prenom_c;
    @FXML
     private TableColumn<Patient,Date> date_c; 
    @FXML
     private TableColumn<Patient,String> sexe_c;
    @FXML
     private TableColumn<Patient,String> tel_c;
    @FXML
     private TableColumn<Patient,String>alergie_c;
    @FXML
     private TableColumn<Patient,String>adresse_c;
    
    ObservableList<Patient> oblist=FXCollections.observableArrayList(); 
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
   
     
        ResultSet rs ;
        CabinetApp cp=new CabinetApp();
        System.out.println("hereeeeeeeeeeeeeeeeeee:::::");
        PreparedStatement stmt ;
        try {
            stmt = cp.getC().prepareStatement("Select* from patient ");
            rs=stmt.executeQuery();
            while(rs.next())
            {
              oblist.add(new Patient(rs.getString("ncin"),rs.getString("nom"),rs.getString("prenom"),rs.getString("date_nais")
              ,rs.getString("sexe"),rs.getString("tel"),rs.getString("alergie"),rs.getString("adresse")));
            }
       
        } catch (SQLException ex) {
            Logger.getLogger(FXMLGPSController.class.getName()).log(Level.SEVERE, null, ex);
      
      ncin_c.setCellValueFactory(new PropertyValueFactory<>("ncin"));
      nom_c.setCellValueFactory(new PropertyValueFactory<>("nom"));
      prenom_c.setCellValueFactory(new PropertyValueFactory<>("prenom"));
      date_c.setCellValueFactory(new PropertyValueFactory<>("date_naiss"));
      sexe_c.setCellValueFactory(new PropertyValueFactory<>("sexe"));
      tel_c.setCellValueFactory(new PropertyValueFactory<>("tel"));
      alergie_c.setCellValueFactory(new PropertyValueFactory<>("alergie"));
      alergie_c.setCellValueFactory(new PropertyValueFactory<>("adresse"));
      t.setItems(oblist);
    }    
    
}}
