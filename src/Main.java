import java.sql.Date;
import java.sql.SQLException;
import Domain.News;
import Domain.Tags;
import Persistance.NewsDAO;
import Persistance.NewsTagDAO;
import Persistance.ReporterDAO;
import Persistance.TagsDAO;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ReporterDAO reporterDAO = new ReporterDAO();
        TagsDAO tagsDAO = new TagsDAO();
        NewsTagDAO newsTagsDAO = new NewsTagDAO();
        NewsDAO newsDAO = new NewsDAO();
        News news = new News("TitreTest2","contenuTest",new Date(1242984300),2);
        Tags tag = new Tags("TagTest2");
        reporterDAO.readById(2);
        newsDAO.reporterReadById(1);
        newsDAO.tagsReadById(1);
        newsDAO.insert(news);
        tagsDAO.insert(tag);
        newsTagsDAO.insert(news,tag);
    }
}
