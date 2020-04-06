package Domain.Dto;

import java.util.Date;

public class TagsById {
    private String tag;
    private String titre;
    private String contenu;
    private Date dateNews;

    public TagsById(String tag, String titre, String contenu, Date dateNews) {
        this.tag = tag;
        this.titre = titre;
        this.contenu = contenu;
        this.dateNews = dateNews;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDateNews(Date dateNews) {
        this.dateNews = dateNews;
    }

    public String getTag() {
        return tag;
    }

    public String getTitre() {
        return titre;
    }

    public String getContenu() {
        return contenu;
    }

    public Date getDateNews() {
        return dateNews;
    }
}
