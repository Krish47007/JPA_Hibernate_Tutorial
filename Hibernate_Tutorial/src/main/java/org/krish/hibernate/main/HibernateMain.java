package org.krish.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.krish.dto.UserDetails;
import org.krish.hibernate.util.HibernateUtil;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class HibernateMain {

    void saveUser_1(SessionFactory sf)
    {
        UserDetails user = UserDetails.builder()
                                      .userName("Krish").build();

        //Creating a session
        Session session = sf.openSession();
        try
        {
            //Begin a transaction
            session.beginTransaction();

            //Persist the object
            session.save(user);

            //Commit transaction
            session.getTransaction().commit();

        }catch (Exception e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            if(session != null)
                session.close();
        }
    }

    void saveUser_2(SessionFactory sf)
    {
        UserDetails user = UserDetails.builder()
                .userName("Krish")
                .joinedDate(LocalDateTime.now())
                .address("Kolkata")
                //.description("Java Developer")
                .build();

        //Creating a session
        Session session = sf.openSession();
        try
        {
            //Begin a transaction
            session.beginTransaction();

            //Persist the object
            session.save(user);

            //Commit transaction
            session.getTransaction().commit();

        }catch (Exception e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            if(session != null)
                session.close();
        }
    }

    UserDetails getUser(Long userId,SessionFactory sf)
    {
        Session session = sf.openSession();

        session.beginTransaction();

        try
        {
            UserDetails userDetails = session.load(UserDetails.class,userId);
            System.out.println(userDetails.getDescription());
            System.out.println(userDetails.getAddress());
            session.getTransaction().commit();
            return userDetails;

        }catch (Exception e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args)
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        HibernateMain main = new HibernateMain();

        //main.saveUser_1(sf);
        main.saveUser_2(sf);

        //main.getUser(2L,sf);
    }
}
