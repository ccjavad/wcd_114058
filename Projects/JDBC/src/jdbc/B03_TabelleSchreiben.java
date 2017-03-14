package jdbc;

import ds.Stadt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B03_TabelleSchreiben {
    private static Connection createConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/java_test";
        String user = "root";
        String password = "1234";
        
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) throws SQLException {
        
        try( Connection connection = createConnection() ) {
            
            try( Statement stm = connection.createStatement() ) {

                String sql = "INSERT INTO staedte (`name`, land, einwohner) VALUES ('S3', 'L3', 55)";
                
                stm.executeUpdate(sql);
                
            } //hier: stm.close() im finally
            
        } //hier: connection.close() im finally
    }
}
