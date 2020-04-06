package Persistance;

import Domain.Dto.TagsDto;
import Domain.Models.Tags;

import java.sql.*;

public class TagsDAO {

    public void insert(Tags tag) throws SQLException, ClassNotFoundException {
        ConnectDB connectDB = new ConnectDB();
        Connection cx = connectDB.connect();
        PreparedStatement stmt = cx.prepareStatement("Insert into tags (tag) values (?) ", Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1,tag.tag);
        int rs = stmt.executeUpdate();
        ResultSet rsGeneratedKeys = stmt.getGeneratedKeys();
        cx.close();
    }

    public TagsDto getById(int id) throws SQLException, ClassNotFoundException {
        TagsDto tag = new TagsDto();
        ConnectDB connectDB = new ConnectDB();
        Connection cx = connectDB.connect();
        PreparedStatement stmt = cx.prepareStatement("Select * from tags where id = ?");
        stmt.setInt(1,id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int idTag = rs.getInt(1);
            String tagContenu = rs.getString(2);
            tag.setId(idTag);
            tag.setTag(tagContenu);
        }
        cx.close();
        return tag;
    }
}
