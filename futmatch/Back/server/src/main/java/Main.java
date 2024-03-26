import Model.Publication;
import Model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import static spark.Spark.*;


public class Main {
    public static void main(String[] args) {
        final EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab1");

        final EntityManager entityManager = factory.createEntityManager();


        sample2(entityManager);

        entityManager.close();
    }
        private static void sample2(EntityManager entityManager) {
            final EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            final User luke = new User("Luke", "Skywalker", "luke.skywalker@jedis.org");
            final User leia = new User("Leia", "Skywalker", "leia.skywalker@jedis.org");
            final User rey = new User("Rey", "Skywalker", "rey.skywalker@jedis.org");
            final User ben = new User("Ben", "Solo", "ben.sole@jedis.org");

            final Publication lukePublication01 = new Publication(
                    "Just had an epic lightsaber duel with my sister, Leia! " +
                            "May the Force be with us always. " +
                            "#JediFamily #SiblingRivalry #TheForceIsStrong");
            final Publication lukePublication02 = new Publication(
                    "Exploring the galaxy with my trusty droid R2-D2. " +
                            "It's amazing to see all the wonders of the universe. " +
                            "#SpaceExplorer");
            final Publication lukePublication03 = new Publication(
                    "Remembering my mentor and friend, Obi-Wan Kenobi. " +
                            "His wisdom and guidance continue to inspire me on my journey. " +
                            "#JediLegacy #MayTheForceBeWithYou #ObiWanKenobi");
            luke.addPublication(lukePublication01);
            luke.addPublication(lukePublication02);
            luke.addPublication(lukePublication03);

            final Publication leiaPublication01 = new Publication(
                    "Taking a break from the battlefield to enjoy some time with my husband, Han Solo. " +
                            "He may be a scoundrel, but he's the love of my life. " +
                            "#SpaceRomance #HanAndLeia #LoveInTheGalaxy");
            final Publication leiaPublication02 = new Publication(
                    "Celebrating the victories of the Rebellion with my friends and allies. " +
                            "We've been through so much together, but our bond only grows stronger. " +
                            "#RebelFamily #VictoryCelebration #TogetherWeRise");
            leia.addPublication(leiaPublication01);
            leia.addPublication(leiaPublication02);

            final Publication reyPublication01 = new Publication(
                    "Embracing my identity as a Skywalker. " +
                            "My journey has been long and difficult, but I'm proud of who I am and where I come from. " +
                            "#SkywalkerPride #TheForceIsMyFamily #NeverAlone");
            final Publication reyPublication02 = new Publication(
                    "Celebrating the victories of the Rebellion with my friends and allies. " +
                            "We've been through so much together, but our bond only grows stronger. " +
                            "#RebelFamily #VictoryCelebration #TogetherWeRise");
            rey.addPublication(reyPublication01);
            rey.addPublication(reyPublication02);

            final Publication benPublication01 = new Publication(
                    "Making amends for my past mistakes. " +
                            "I know I can never fully make up for the pain I've caused, but I will do everything in my power to make things right. " +
                            "#Redemption #Forgiveness #TheJourneyBackToTheLight");
            final Publication benPublication02 = new Publication(
                    "Discovering my true identity as Ben Solo. " +
                            "It hasn't been an easy road, but I'm grateful for the lessons I've learned. " +
                            "#SelfDiscovery #FindingMyself #TheTruthWillSetYouFree");
            final Publication benPublication03 = new Publication(
                    "Finding strength in my friendships with Finn, Poe, and BB-8. " +
                            "Together, we can accomplish anything. " +
                            "#JediFriends #TeamworkMakesTheDreamWork #TheForceIsStrong");
            ben.addPublication(benPublication01);
            ben.addPublication(benPublication02);
            ben.addPublication(benPublication03);

            rey.likes(leiaPublication01);

            ben.likes(lukePublication02);
            ben.likes(leiaPublication01);

            entityManager.persist(luke);
            entityManager.persist(leia);
            entityManager.persist(rey);
            entityManager.persist(ben);

            transaction.commit();
        }

}
