
package cabinetapp;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXMGUMController implements Initializable {
    ObservableList<String> type_user= FXCollections.observableArrayList("Aucun Choix","Médecin","Secretaire");
    @FXML
    private ComboBox user=new ComboBox();
    @FXML
    private TextField login=new TextField();
    @FXML
    private TextField pwd=new TextField();
    @FXML
    private TextField pwd_c=new TextField();
    @FXML
    private Button changu;
    @FXML
    private Button cancel;
    @FXML
    private Button acc;
    @FXML
    private Button cons;
    @FXML
    public void ChangeUser(ActionEvent event) throws SQLException
    {   
        String nvlogin=login.getText();
        String nvpwd=pwd.getText();
        String pwdc=pwd_c.getText();
        String u=(String) user.getValue();
        CabinetApp conn=new CabinetApp();
        if((!nvlogin.equals(""))&&(!nvpwd.equals(""))&&(!pwdc.equals(""))&&(!u.equals("Aucun Choix")))
        {
        String query = "update user set login=? ,password=? where role ='"+u+"'";
        PreparedStatement preparedStmt = conn.getC().prepareStatement(query);
        preparedStmt.setString(1,nvlogin);
        preparedStmt.setString(2,nvpwd);
        // execute the java preparedstatement
        preparedStmt.executeUpdate();
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("la mise à jour a été bien faite");
        alert.showAndWait();
       }
        else 
        {
            Alert alert=new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Vous devez remplir le formulaire");
            alert.showAndWait();
        }
    }     
 
    @FXML
    public void ChangeUserAnnuler(ActionEvent event)
    {   
        login.clear();
        pwd.clear();
        pwd_c.clear();
        user.setValue("Aucun Choix");
        
    }
    @FXML
    public void acceuil(ActionEvent event) throws IOException
    {
           
           Parent user = FXMLLoader.load(getClass().getResource("FXMHomePageM.fxml"));
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
       user.setValue("Aucun Choix");
       user.setItems(type_user);
    }    
    
}
