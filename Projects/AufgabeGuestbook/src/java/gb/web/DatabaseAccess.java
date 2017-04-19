package gb.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

public class DatabaseAccess {

    static {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/java_test",
                "root", "1234");
    }

    public Collection<Entry> selectAll() throws SQLException {
        LinkedHashSet<Entry> set = new LinkedHashSet<>();

        try (Connection connection = getConnection()) {
            try (Statement stm = connection.createStatement()) {
                try (ResultSet res = stm.executeQuery("select * from guestbook")) {
                    while (res.next()) {
                        Date date = res.getTimestamp(1);
                        String userName = res.getString(2);
                        String userText = res.getString(3);

                        set.add(new Entry(date, userName, userText));
                    }
                }
            }
        }

        return set;
    }

    public void update(Collection<Entry> entries) throws SQLException {
        try (Connection connection = getConnection()) {
            try(Statement stm = connection.createStatement()) {
                stm.executeUpdate("truncate table guestbook");
            }

            String sql = "INSERT INTO guestbook (`date`, username, usertext) VALUES (?, ?, ?)";
            try (PreparedStatement stm = connection.prepareStatement(sql)) {
                for (Entry entry : entries) {
                    Timestamp ts = new Timestamp(entry.getDate().getTime());
                    stm.setTimestamp(1, ts);
                    stm.setString(2, entry.getUserName());
                    stm.setString(3, entry.getUserText());
                    stm.addBatch();
                }
                stm.executeBatch();
            }
        }
    }
}
