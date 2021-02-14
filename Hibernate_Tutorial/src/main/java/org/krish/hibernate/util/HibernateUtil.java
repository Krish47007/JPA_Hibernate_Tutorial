package org.krish.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static SessionFactory getSessionFactory() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        return factory;
    }
}
