package jdbc;

import ds.Stadt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B02_TabelleLesen {
    
    private static Connection createConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/java_test";
        String user = "root";
        String password = "1234";
        
        return DriverManager.getConnection(url, user, password);
    }
    

    public static void main(String[] args) throws SQLException {
        
        try( Connection connection = createConnection() ) {
            
            try( Statement stm = connection.createStatement() ) {

                String sql = "select * from staedte";
                
                try( ResultSet res = stm.executeQuery(sql) ) {
                    
                    while(res.next()) {
                        
//                        String name = res.getString("name"); //geht auch
                        String name = res.getString(1); 
                        
                        String land = res.getString("land");
                        
                        int einwohner = res.getInt(3);
                        
                        Stadt s = new Stadt(name, land, einwohner);
                        System.out.println(s);
                    }
                    
                } // hier: res.close() im finally
                
                
            } //hier: stm.close() im finally
            
            
        } //hier: connection.close() im finally
        
        
    }
    
}
