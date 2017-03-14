package ds.db;

import ds.Stadt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class MysqlStaedteDAO implements StaedteDAO {

    private static Connection createConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/java_test";
        String user = "root";
        String password = "1234";

        return DriverManager.getConnection(url, user, password);
    }

//    private void insert(Stadt s) throws SQLException {
//        
//        try( Connection connection = createConnection() ) {
//            try( Statement stm = connection.createStatement() ) {
//                String sql = "INSERT INTO staedte (`name`, land, einwohner) VALUES ('" 
//                        + s.getName() + "', '" 
//                        + s.getLand() + "', " 
//                        + s.getEinwohner() + ")";
//                
//                stm.executeUpdate(sql);
//                
//            } //hier: stm.close() im finally
//        } //hier: connection.close() im finally        
//    }
    
    @Override
    public void insert(List<Stadt> list) throws SQLException {
        try(Connection connection = createConnection()) {
            
            String sql = "INSERT INTO staedte (`name`, land, einwohner) VALUES (?, ?, ?)";
            
            try(PreparedStatement stm = connection.prepareStatement(sql)) {
                for (Stadt stadt : list) {

                    stm.setString(1, stadt.getName());
                    stm.setString(2, stadt.getLand());
                    stm.setInt(3, stadt.getEinwohner());
                    
                    stm.executeUpdate();
                }
            }
        }
    }

    @Override
    public List<Stadt> selectAll() throws SQLException {
        
        List<Stadt> list = new LinkedList<>();
        
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
                        list.add(s);
                    }
                } // hier: res.close() im finally
            } //hier: stm.close() im finally
        } //hier: connection.close() im finally
        
         return list;
    }

    
    
}
