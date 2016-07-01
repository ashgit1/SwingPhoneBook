package Connect;
import java.sql.*;
import javax.swing.*;

public class Connect {
	
	String  userName="root";  // text var
	String  password="root"; // text var
	String  url="jdbc:mariadb://localhost:3306/phonebook" ;     // text var
	Connection cn;

    public Connect() {}

    public Connection getConnection() { 
         try {
        	 Class.forName("org.mariadb.jdbc.Driver");
         } catch(ClassNotFoundException  con) {
        	 JOptionPane.showMessageDialog(null, " \n Class Not Found Exception \n " +con.getMessage());            
         }
         
         try {
        	 cn=DriverManager.getConnection(url, userName, password);
        	 
         } catch(SQLException sqlx) {
        	 JOptionPane.showMessageDialog(null, " \n SQLException \n " +sqlx.getMessage());               
         }
         return cn;
    }
}