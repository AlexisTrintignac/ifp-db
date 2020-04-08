package Domain.Models;
import javax.persistence.Persistence;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class HibernateBasicTest {

    @Test
    void sessionOk() {
        Persistence.createEntityManagerFactory("derby-persistence-unit");
    }
}