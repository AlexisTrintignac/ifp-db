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
        reporterDB.setCredit(2);
        reporterDB.setPseudo("Blabla");
        EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("derby-persistence-unit");
        EntityManager entityManager = sessionFactory.createEntityManager();
        assertTrue(entityManager.isOpen());
        entityManager.persist(reporterDB);
        entityManager.createQuery("Update REPORTER SET CREDIT=10 WHERE PSEUDO='alexis'");
        //entityManager.find(Reporter,reporterDB);
        entityManager.close();
        sessionFactory.close();
    }
}