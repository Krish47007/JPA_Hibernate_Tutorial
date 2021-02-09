package org.krish.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static volatile SessionFactory factory = null;

    public static SessionFactory getSessionFactory()
    {
        if(factory == null)
        {
            synchronized (HibernateUtil.class)
            {
                if(factory == null)
                    factory = new Configuration().configure().buildSessionFactory();
            }
        }
        return factory;
    }
}
