package Persistance;

import Domain.Reporter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReporterDAO {

    public void readById(int id) throws SQLException, ClassNotFoundException {
        ConnectDB connectDB = new ConnectDB();
        Connection cx = connectDB.connect();
        PreparedStatement stmt = cx.prepareStatement("Select * from reporter where id = ?");
        stmt.setInt(1,id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int idReporter = rs.getInt(1);
            String pseudo = rs.getString(2);
            int credit = rs.getInt(3);
            System.out.print("pseudo: "+pseudo+'\n');
            System.out.print("credit: "+credit+'\n');
        }
        cx.close();
    }

}
