import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.Dto.*;
import Domain.Models.News;
import Domain.Models.Tags;
import Persistance.Exceptions.ExceptionNews;
import Persistance.NewsDAO;
import Persistance.NewsTagDAO;
import Persistance.ReporterDAO;
import Persistance.TagsDAO;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ExceptionNews {
        ReporterDAO reporterDAO = new ReporterDAO();
        TagsDAO tagsDAO = new TagsDAO();
        NewsTagDAO newsTagsDAO = new NewsTagDAO();
        NewsDAO newsDAO = new NewsDAO();
        News news = new News("TitreTest2","contenuTest",new Date(1242984300),2);
        Tags tag = new Tags("TagTest2");
        ReporterDto reporterById = reporterDAO.readById(2);
        System.out.println("Pseudo reporterById : " + reporterById.getPseudo());
        NewsDto newsById = newsDAO.getById(1);
        System.out.println("Titre newsById : " + newsById.getTitre());
        ReporterNews reporterNews = newsDAO.reporterReadById(1);
        System.out.println("contenu DTO : " + reporterNews.getContenu());
        List<TagsById> listTagsById = newsDAO.tagsReadById(1);
        for (TagsById elmt: listTagsById) {
            System.out.println("contenu : "+ elmt.getContenu());
            System.out.println("date : "+ elmt.getDateNews());
            System.out.println("tag : "+ elmt.getTag());
            System.out.println("titre : "+ elmt.getTitre());
        }
        TagsDto tagsById = tagsDAO.getById(2);
        System.out.println("contenu Tag : "+ tagsById.getTag());
        newsDAO.insert(news);
        tagsDAO.insert(tag);
        newsTagsDAO.insert(news,tag);
    }
}
