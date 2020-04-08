package Domain.Models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

//@Entity
//@Table(name = "NEWS")
public class News {
    public int id;
    public String titre;
    public String contenu;
    public Date date_news;
    public int id_reporter;

    public News(){}

    public News(String titre,String contenu,Date date_news,int id_reporter){
        this.titre = titre;
        this.contenu = contenu;
        this.date_news = date_news;
        this.id_reporter = id_reporter;
    }
}
