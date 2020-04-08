package Domain.Models;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class HibernateBasicTest {

    @Test
    void sessionOk() {
        Reporter reporterDB = new Reporter();
        EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("derby-persistence-unit");
        EntityManager entityManager = sessionFactory.createEntityManager();
        assertTrue(entityManager.isOpen());
        entityManager.persist(reporterDB);
        reporterDB.setCredit(2);
        entityManager.close();
        sessionFactory.close();
    }
}