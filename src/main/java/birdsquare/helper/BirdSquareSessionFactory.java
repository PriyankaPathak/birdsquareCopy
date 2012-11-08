package birdsquare.helper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class BirdSquareSessionFactory {
    private SessionFactory ourSessionFactory ;

    private static BirdSquareSessionFactory birdSquareSessionFactory = new BirdSquareSessionFactory();
    private final String hibernateConfigFile = "hibernate.cfg.xml";

    private BirdSquareSessionFactory() {
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                .applySettings(new Configuration().addResource(hibernateConfigFile).configure().getProperties())
                .buildServiceRegistry();

        ourSessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);
    }

    public static BirdSquareSessionFactory getInstance() {
        return birdSquareSessionFactory;
    }

    public synchronized Session createSession() {
        return ourSessionFactory.openSession();
    }
}
