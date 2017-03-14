package ds.db;

import ds.Stadt;
import java.sql.SQLException;
import java.util.List;

public interface StaedteDAO {
    
    void insert(List<Stadt> list) throws SQLException;
    List<Stadt> selectAll() throws SQLException;
    
}
