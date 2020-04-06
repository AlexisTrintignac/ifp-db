package Domain.Dto;

public class ReporterDto {
    private int id;
    private String pseudo;
    private int credit;

    public ReporterDto(){

    }
    public ReporterDto(int id, String pseudo, int credit){
        this.id = id;
        this.pseudo = pseudo;
        this.credit = credit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public int getCredit() {
        return credit;
    }
}
