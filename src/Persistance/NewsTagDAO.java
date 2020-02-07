package Persistance;

import Domain.News;
import Domain.Tags;

import java.sql.*;

public class NewsTagDAO {

    public void insert(News news, Tags tag) throws SQLException, ClassNotFoundException {
        ConnectDB connectDB = new ConnectDB();
        Connection cx = connectDB.connect();
        PreparedStatement stmt = cx.prepareStatement("Insert into news_tags (id_news,id_tag) values (?,?) ", Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1,news.id);
        stmt.setInt(2,tag.id);
        int rs = stmt.executeUpdate();
        ResultSet rsGeneratedKeys = stmt.getGeneratedKeys();
        cx.close();
    }
}
