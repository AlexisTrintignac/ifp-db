package Persistance;

import Domain.Dto.NewsDto;
import Domain.Dto.ReporterNews;
import Domain.Dto.TagsById;
import Domain.Models.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;

public class NewsDAO {

    public ReporterNews reporterReadById(int id) throws SQLException, ClassNotFoundException {
        ReporterNews news = new ReporterNews();
        ConnectDB connectDB = new ConnectDB();
        Connection cx = connectDB.connect();
        PreparedStatement stmt = cx.prepareStatement("Select pseudo,titre,contenu,date_news,id_reporter from news,reporter where news.id_reporter = reporter.id and news.id = ?");
        stmt.setInt(1,id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
             String pseudo = rs.getString(1);
             String titre = rs.getString(2);
             String contenu = rs.getString(3);
             Date dateNews = rs.getDate(4);
             int id_reporter = rs.getInt(5);
             news.setPseudo(pseudo);
             news.setTitre(titre);
             news.setContenu(contenu);
             news.setDateNews(dateNews);
             news.setIdReporter(id_reporter);
        }
        cx.close();
        return news;
    }

    public List<TagsById> tagsReadById(int id) throws SQLException, ClassNotFoundException {
        List<TagsById> listTags = new LinkedList<TagsById>();
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
            TagsById tagDto = new TagsById(tag,titre,contenu,dateNews);
            listTags.add(tagDto);
        }
        cx.close();
        return listTags;
    }

    public void insert(News news) throws SQLException, ClassNotFoundException {
        ConnectDB connectDB = new ConnectDB();
        Connection cx = connectDB.connect();
        PreparedStatement stmt = cx.prepareStatement("Insert into news (titre,contenu,date_news,id_reporter) values (?,?,?,?) ",Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1,news.titre);
        stmt.setString(2,news.contenu);
        stmt.setDate(3, (java.sql.Date) news.date_news);
        stmt.setInt(4,news.id_reporter);
        int rs = stmt.executeUpdate();
        ResultSet rsGeneratedKeys = stmt.getGeneratedKeys();
        cx.close();
    }

    public NewsDto getById(int id) throws SQLException, ClassNotFoundException {
        NewsDto news = new NewsDto();
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
            news.setId(idNews);
            news.setTitre(titre);
            news.setContenu(contenu);
            news.setDate_news(dateNews);
            news.setId_reporter(idReporter);
        }
        cx.close();
        return news;
    }
}
