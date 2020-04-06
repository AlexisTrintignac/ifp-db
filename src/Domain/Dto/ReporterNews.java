package Domain.Dto;

import java.util.Date;

public class ReporterNews {
    private String pseudo;
    private String titre;
    private String contenu;
    private Date dateNews;
    private int idReporter;

    public ReporterNews(){

    }
    public ReporterNews(String pseudo, String titre, String contenu, Date dateNews, int id_reporter) {
        this.pseudo = pseudo;
        this.titre = titre;
        this.contenu = contenu;
        this.dateNews = dateNews;
        this.idReporter = id_reporter;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
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

    public void setIdReporter(int idReporter) {
        this.idReporter = idReporter;
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

    public int getIdReporter() {
        return idReporter;
    }
}
