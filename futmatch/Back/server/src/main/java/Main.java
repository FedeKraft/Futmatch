import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        get("/hello", (req, res) -> "Hello World");
        final EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab1");

        final EntityManager entityManager = factory.createEntityManager();

        entityManager.close();

    }
}