package gb.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashSet;

public class DatabaseAccess {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/java_test", 
                "root", "1234");
    }
    
    
    public Collection<Entry> selectAll() throws SQLException {
        return new LinkedHashSet<>(); //db zugriff
    }
    
    public void update(Collection<Entry> entries) throws SQLException {
        //db zugriff
    }
}
