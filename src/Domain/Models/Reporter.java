package Domain.Models;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "REPORTER")
public class Reporter {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    //@GenericGenerator(name="increment", strategy = "increment")
    private int id;

    @Column(name = "PSEUDO")
    private String pseudo;

    @Column(name = "CREDIT")
    private int credit;

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
