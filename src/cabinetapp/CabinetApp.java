
package cabinetapp;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CabinetApp extends Application {
private String login="root";
private String password="";
private String hostname="localhost";
private String port="3306";
private String nomDeLaBase="cabinet";
private Connection c;
private Statement st;
String qr;
ResultSet rs;

public CabinetApp()
{
    boolean statusConnexion = false;
    String urlJdbc;
    
 urlJdbc = "jdbc:mysql://"+hostname+":" + port + "/" +   nomDeLaBase ;
 urlJdbc = urlJdbc + "?user=" + login + "&password=" +  password ;
 
    try { 
     Class.forName("com.mysql.jdbc.Driver");
     
     c=DriverManager.getConnection(urlJdbc);
            System.out.println("connexion etablie");
         
          } 
    
    catch ( Exception e ) 
    
    
        {
	statusConnexion = false;
	System.out.println(e);
        }
}

   
    public Connection getC(){return c;}
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("CabinetApp");

       
        stage.getIcons().add(new Image("file:logo.png"));
        
        Parent auth = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(auth);
        stage.setScene(scene);
        stage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
