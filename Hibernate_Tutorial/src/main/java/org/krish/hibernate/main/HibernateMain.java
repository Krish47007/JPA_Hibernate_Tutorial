package org.krish.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.krish.dto.Address;
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
    {/*
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
    */}

    void saveUser_3(SessionFactory sf)
    {
        Session session = sf.openSession();

        try
        {
            Address homeAddress = Address.builder()
                                     .city("Kolkata")
                                     .pin("700096")
                                     .street("P-14")
                                     .state("West Bengal")
                                      .build();
            Address officeAddress = Address.builder()
                                        .city("Bangalore")
                                        .pin("560037")
                                        .street("5th & 6th Block")
                                        .state("Karnataka")
                                        .build();

            UserDetails userDetails = UserDetails.builder()
                                        .userName("Krish")
                                        .homeAddress(homeAddress)
                                        .officeAddress(officeAddress)
                                        .description("Java Developer")
                                        .joinedDate(LocalDateTime.now())
                                        .build();

            //Saving
            session.beginTransaction();

            session.save(userDetails);

            session.getTransaction().commit();


        }catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
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
            /*System.out.println(userDetails.getDescription());
            System.out.println(userDetails.getAddress());*/
            session.getTransaction().commit();
            return userDetails;

        }catch (Exception e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally {
            if(session!=null)
                session.close();
        }
    }

    public static void main(String[] args)
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        HibernateMain main = new HibernateMain();

        //main.saveUser_1(sf);
        //main.saveUser_2(sf);

        main.saveUser_3(sf);

        //main.getUser(2L,sf);
    }
}
