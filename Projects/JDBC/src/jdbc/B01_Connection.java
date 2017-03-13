package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class B01_Connection {

    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/java_test";
        String user = "root";
        String password = "1234";
        
        // Class.forName("org.gjt.mm.mysql.Driver"); //manuell den Treiber laden, wen der nach einer älteren JDBC-Spec. realisiert wurde
        
        try ( Connection connection = DriverManager.getConnection(url, user, password) ) {
            
            System.out.println("Verbindung steht: " + connection);
            
        } catch(SQLException e) {
            System.out.println("Fehler beim Erzeugen der Verbindung");
            e.printStackTrace();
            
        } // hier auch finally mit connection.close() !!! close sollte sein !!!
        
        System.out.println("Keine Verbindung (mehr)");
        
    }
    
}
