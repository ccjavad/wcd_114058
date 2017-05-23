package userlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;

public class DatabaseAccess {
    
    static {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch(ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void insertUser(DataSource dataSource, 
            String userName, String password, String roleName) throws SQLException, DatabaseNotUniqueUsernameException {
    
        try(Connection connection = dataSource.getConnection()) {
            String sql = "insert into java_test.users (user_name, user_pass) values (?, ?);";
            try(PreparedStatement stm = connection.prepareStatement(sql)) {
                stm.setString(1, userName);
                stm.setString(2, password);
                stm.executeUpdate();
            } catch(SQLException e) {
                if("23000".equals(e.getSQLState())) {
                    throw new DatabaseNotUniqueUsernameException();
                }
                
                throw e;
            }
            
            sql = "insert into java_test.user_roles (user_name, role_name) values (?, ?);";
            try(PreparedStatement stm = connection.prepareStatement(sql)) {
                stm.setString(1, userName);
                stm.setString(2, roleName);
                stm.executeUpdate();
            }
        }
    }
    
    public static List<User> selectAll(DataSource dataSource) throws SQLException {
        
        List<User> list = new LinkedList<>();
        
         try( Connection connection = dataSource.getConnection() ) {
            
            try( Statement stm = connection.createStatement() ) {

                String sql = "select java_test.users.user_name, java_test.user_roles.role_name from java_test.users join java_test.user_roles on java_test.users.user_name = java_test.user_roles.user_name;";
                
                try( ResultSet res = stm.executeQuery(sql) ) {
                    
                    while(res.next()) {
                        
                        String name = res.getString("user_name"); //geht auch
                        String role = res.getString("role_name");
                        
                        User u = new User(name, role);
                        list.add(u);
                    }
                } 
            } 
        } 
        
        return list;
    }
    
}
