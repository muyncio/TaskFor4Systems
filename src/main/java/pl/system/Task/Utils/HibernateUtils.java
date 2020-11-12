package pl.system.Task.Utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtils {
    private static HibernateUtils instance;

    private SessionFactory sessionFactory;

    private EntityManager HibernateUtils() {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(standardRegistry)
                .getMetadataBuilder()
                .build();

        sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();
        EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("pl.system.Task.Entity.Users");

        public EntityManager getEntityManager(){

        }
    }

    public static HibernateUtils getInstance() {
        if(instance == null) {
            instance = new HibernateUtils();
        }
        return instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }


}