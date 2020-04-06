package Persistance;

import Domain.Dto.ReporterDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReporterDAO {

    public ReporterDto readById(int id) throws SQLException, ClassNotFoundException {
        ReporterDto reporter = new ReporterDto();
        ConnectDB connectDB = new ConnectDB();
        Connection cx = connectDB.connect();
        PreparedStatement stmt = cx.prepareStatement("Select * from reporter where id = ?");
        stmt.setInt(1,id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int idReporter = rs.getInt(1);
            String pseudo = rs.getString(2);
            int credit = rs.getInt(3);
            reporter.setId(idReporter);
            reporter.setPseudo(pseudo);
            reporter.setCredit(credit);
        }
        cx.close();
        return reporter;
    }

}
