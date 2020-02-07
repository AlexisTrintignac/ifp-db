package Persistance;

import Domain.News;
import Domain.Tags;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class NewsDAO {

    public void reporterReadById(int id) throws SQLException, ClassNotFoundException {
        ConnectDB connectDB = new ConnectDB();
        Connection cx = connectDB.connect();
        PreparedStatement stmt = cx.prepareStatement("Select pseudo,titre,contenu,date_news from news,reporter where news.id_reporter = reporter.id and news.id = ?");
        stmt.setInt(1,id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String pseudo = rs.getString(1);
            String titre = rs.getString(2);
            String contenu = rs.getString(3);
            Date dateNews = rs.getDate(4);
            System.out.print("titre: "+titre+'\n');
            System.out.print("contenu: "+contenu+'\n');
            System.out.print("date: "+dateNews+'\n');
            System.out.print("reporter: "+pseudo+'\n');
        }
        cx.close();
    }

    public void tagsReadById(int id) throws SQLException, ClassNotFoundException {
        List<String> listTags = new LinkedList<>();
        String tag;
        String titre;
        String contenu;
        Date dateNews;
        ConnectDB connectDB = new ConnectDB();
        Connection cx = connectDB.connect();
        PreparedStatement stmt = cx.prepareStatement("Select titre,contenu,tag,date_news from news,tags,news_tags where news.id = news_tags.id_news and tags.id = news_tags.id_tag and news.id = ?");
        stmt.setInt(1,id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            tag = rs.getString(3);
            titre = rs.getString(1);
            contenu = rs.getString(2);
            dateNews = rs.getDate(4);
            listTags.add(tag);
            System.out.print("titre: "+titre+'\n');
            System.out.print("contenu: "+contenu+'\n');
            System.out.print("date: "+dateNews+'\n');
            System.out.print("tag: "+tag+'\n');
        }
        cx.close();
    }

    public void insert(News news) throws SQLException, ClassNotFoundException {
        ConnectDB connectDB = new ConnectDB();
        Connection cx = connectDB.connect();
        PreparedStatement stmt = cx.prepareStatement("Insert into news (titre,contenu,date_news,id_reporter) values (?,?,?,?) ",Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1,news.titre);
        stmt.setString(2,news.contenu);
        stmt.setDate(3, (Date) news.date_news);
        stmt.setInt(4,news.id_reporter);
        int rs = stmt.executeUpdate();
        ResultSet rsGeneratedKeys = stmt.getGeneratedKeys();
        cx.close();
    }

    public News getById(int id) throws SQLException, ClassNotFoundException {
        News news = new News();
        ConnectDB connectDB = new ConnectDB();
        Connection cx = connectDB.connect();
        PreparedStatement stmt = cx.prepareStatement("Select * from news where id = ?");
        stmt.setInt(1,id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int idNews = rs.getInt(1);
            String titre = rs.getString(2);
            String contenu = rs.getString(3);
            Date dateNews = rs.getDate(4);
            int idReporter = rs.getInt(5);
            news.id = idNews;
            news.titre = titre;
            news.contenu = contenu;
            news.date_news = dateNews;
            news.id_reporter = idReporter;
        }
        cx.close();
        return news;
    }
}
