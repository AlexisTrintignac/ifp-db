package Persistance;

import java.sql.*;

public class ConnectDB {

    public Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        var cx = DriverManager.getConnection("jdbc:derby:db/ifp-db");
        return cx;
    }
}
