/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinetapp;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FXMGCMController implements Initializable {
    // chercher
    @FXML
   private Button gu;
   @FXML
   private Button acc;
   @FXML
   private Button chercher;
   @FXML
   private TableView<Consultation> table;
         
    @FXML
     private TableColumn<Consultation,Date> date_c;
    @FXML
     private TableColumn<Consultation,String> commentaire;
    @FXML
     private TableColumn<Consultation,String> ordonnance;
    @FXML
    private TextField ncin= new TextField();
    ObservableList<Consultation> data=FXCollections.observableArrayList(); 
    // ajouter 
   @FXML
   private Button eng;
   @FXML
   private Button ann;
   @FXML
   private TextField cin=new TextField() ;
   @FXML
   private DatePicker d_cons=new DatePicker();
   @FXML
   private TextArea com=new TextArea();
   @FXML
   private TextArea ord=new TextArea();

      @FXML
public void cherch_cons(ActionEvent event) throws IOException
    {
        int cond=Integer.parseInt(ncin.getText());
        ResultSet rs ;
        CabinetApp cp=new CabinetApp();
        PreparedStatement stmt ;
        try {
            stmt = cp.getC().prepareStatement("Select date_c,commentaire,ordonnance from consultation where ncin="+cond);
            rs=stmt.executeQuery();
            while(rs.next())
            {
              data.add(new Consultation(rs.getDate(1),rs.getString(2),rs.getString(3)));
            }
       
        } catch (SQLException ex) {
            Logger.getLogger(FXMLGPSController.class.getName()).log(Level.SEVERE, null, ex);
      
        }
      date_c.setCellValueFactory(new PropertyValueFactory<Consultation,Date>("date_c"));
      commentaire.setCellValueFactory(new PropertyValueFactory<Consultation,String>("commentaire"));
      ordonnance.setCellValueFactory(new PropertyValueFactory<Consultation,String>("ordonnace"));
      table.setItems(data);     
           
    }
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
public void acceuil(ActionEvent event) throws IOException
    {
           
           Parent user = FXMLLoader.load(getClass().getResource("FXMHomePageM.fxml"));
           Scene scene2 = new Scene(user);
           Stage s=(Stage)((Node) event.getSource()).getScene().getWindow();
           s.setScene(scene2); 
           s.show();
           
    }
@FXML
public void engistrer_cons(ActionEvent event) throws IOException, SQLException
       
{    
    
    System.out.println("here enregistrer 1");
        String cino=cin.getText();
        System.out.println("here enregistrer 2");
        
        System.out.println("here enregistrer 3");
        LocalDate date_cons=d_cons.getValue();
        System.out.println("here enregistrer4");
        
        String comm=com.getText();
        System.out.println("here enregistrer5");
        String ordo=ord.getText();
        System.out.println("here enregistrer6");
        
        System.out.println("here enregistrer7");
        CabinetApp conn=new CabinetApp();
        if((!cino.equals(""))&&(!comm.equals(""))&&(!(date_cons==null))&&(!ordo.equals("")))
        {
            int cin_p=Integer.parseInt(cino);
            System.out.println("here enregistrer9");
        String query = "insert into consultation (num_c,date_c, commentaire,ordonnance,ncin) VALUES (NULL,'"+date_cons+"','"+comm+"','"+ordo+"',"+cin_p+")";
        PreparedStatement preparedStmt = conn.getC().prepareStatement(query);
        
        // execute the java preparedstatement
        preparedStmt.executeUpdate();
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("L\'inserstion a été bien faite");
        alert.showAndWait();
        cin.clear();
        d_cons.setValue(null);
        com.clear();
        ord.clear();
       }
        else 
        {
            System.out.println("here enregistrer9");
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Vous devez remplir le formulaire");
            alert.showAndWait();
             cin.clear();
        d_cons.setValue(null);
        com.clear();
        ord.clear();
        }
           
    }
public void annuler_cons(ActionEvent event) throws IOException
    {
           
        cin.clear();
        d_cons.setValue(null);
        com.clear();
        ord.clear();
           
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
