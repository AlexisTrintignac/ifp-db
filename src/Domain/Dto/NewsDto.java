package Domain.Dto;

import java.util.Date;

public class NewsDto {
    private int id;
    private String titre;
    private String contenu;
    private Date date_news;
    private int id_reporter;

    public NewsDto(){}

    public NewsDto(String titre,String contenu,Date date_news,int id_reporter){
        this.titre = titre;
        this.contenu = contenu;
        this.date_news = date_news;
        this.id_reporter = id_reporter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDate_news(Date date_news) {
        this.date_news = date_news;
    }

    public void setId_reporter(int id_reporter) {
        this.id_reporter = id_reporter;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getContenu() {
        return contenu;
    }

    public Date getDate_news() {
        return date_news;
    }

    public int getId_reporter() {
        return id_reporter;
    }
}
