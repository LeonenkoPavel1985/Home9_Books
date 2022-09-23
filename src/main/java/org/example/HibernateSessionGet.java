package org.example;

import org.example.Models.Books;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionGet {
    private static SessionFactory sessionFactory = null;
    HibernateSessionGet() {}
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            Configuration config = new Configuration().configure();
            config.addAnnotatedClass(Books.class);

            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(config.getProperties());
            sessionFactory = config.buildSessionFactory(builder.build());
        }
        return sessionFactory;
    }
}
