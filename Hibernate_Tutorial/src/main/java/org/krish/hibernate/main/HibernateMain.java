package org.krish.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.krish.dto.*;
import org.krish.hibernate.util.HibernateUtil;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
    {/*
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

    */}

    void saveUser_4(SessionFactory sf)
    {/*

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
                    .listOfAddress(List.of(homeAddress,officeAddress))
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
*/}

    void saveUser_5(SessionFactory sf)
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

            Vehicle vehicle = Vehicle.builder()
                                .name("Honda")
                                .build();

            UserDetails userDetails = UserDetails.builder()
                    .userName("Krish")
                    .listOfAddress(List.of(homeAddress,officeAddress))
                    .description("Java Developer")
                    .joinedDate(LocalDateTime.now())
                    .vehicle(vehicle)
                    .build();


            //Saving
            session.beginTransaction();

            session.save(userDetails);
            /*
            *   Since Vehicle in UserDetails is non-transient and non-static and we dont have cascade types for this
            *  1-1 relationship we have to manually persist the vehicle as well while saving UserDetails otherwise
            *   hibernate will throw an exception.
            * */
            session.save(vehicle);

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

    void saveUser_6(SessionFactory sf)
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

            Vehicle vehicle = Vehicle.builder()
                    .name("Honda")
                    .build();

            UserDetails userDetails = UserDetails.builder()
                    .userName("Krish")
                    .listOfAddress(List.of(homeAddress,officeAddress))
                    .description("Java Developer")
                    .joinedDate(LocalDateTime.now())
                    .vehicle(vehicle)
                    .build();

            Department department = Department.builder()
                                              .deptName("IT")
                                              .build();

            userDetails.setDepartment(department);
            department.setEmployeeList(List.of(userDetails));


            //Saving
            session.beginTransaction();

            session.save(userDetails);
            /*
             *   Since Vehicle in UserDetails is non-transient and non-static and we dont have cascade types for this
             *  1-1 relationship we have to manually persist the vehicle as well while saving UserDetails otherwise
             *   hibernate will throw an exception.
             * */
            session.save(vehicle);

            session.save(department);

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

    void saveUser_7(SessionFactory sf)
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

            Vehicle vehicle = Vehicle.builder()
                    .name("Honda")
                    .build();

            UserDetails userDetails = UserDetails.builder()
                    .userName("Krish")
                    .listOfAddress(List.of(homeAddress,officeAddress))
                    .description("Java Developer")
                    .joinedDate(LocalDateTime.now())
                    .vehicle(vehicle)
                    .build();

            Department department = Department.builder()
                    .deptName("IT")
                    .build();

            userDetails.setDepartment(department);
            department.setEmployeeList(List.of(userDetails));

            Project p1 = Project.builder().projectName("TEST-A")
                                          .empList(Arrays.asList(userDetails))
                                           .build();
            userDetails.setProjectList(Arrays.asList(p1));

            //Saving
            session.beginTransaction();

            session.save(userDetails);
            /*
             *   Since Vehicle in UserDetails is non-transient and non-static and we dont have cascade types for this
             *  1-1 relationship we have to manually persist the vehicle as well while saving UserDetails otherwise
             *   hibernate will throw an exception.
             * */
            session.save(vehicle);

            session.save(department);

            session.save(p1);

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

        try
        {
            UserDetails userDetails = session.load(UserDetails.class,userId);
            /*System.out.println(userDetails.getDescription());
            System.out.println(userDetails.getAddress());*/

            System.out.println(userDetails.getUserName());


            System.out.println(userDetails.getListOfAddress().size());

            return userDetails;

        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally {
            if(session!=null)
                session.close();
        }
    }

    void saveUser_8(SessionFactory sf)
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

            Vehicle vehicle = Vehicle.builder()
                    .name("Honda")
                    .build();

            UserDetails userDetails = UserDetails.builder()
                    .userName("Krish")
                    .listOfAddress(List.of(homeAddress,officeAddress))
                    .description("Java Developer")
                    .joinedDate(LocalDateTime.now())
                    .vehicle(vehicle)
                    .build();

            Department department = Department.builder()
                    .deptName("IT")
                    .build();

            userDetails.setDepartment(department);
            department.setEmployeeList(List.of(userDetails));

            Project p1 = Project.builder().projectName("TEST-A")
                    .empList(Arrays.asList(userDetails))
                    .build();
            userDetails.setProjectList(Arrays.asList(p1));

            //Saving
            session.beginTransaction();

            session.save(userDetails);
            /*
             *   Since Vehicle in UserDetails is non-transient and non-static and we dont have cascade types for this
             *  1-1 relationship we have to manually persist the vehicle as well while saving UserDetails otherwise
             *   hibernate will throw an exception.
             * */
           /* session.save(vehicle);

            session.save(department);

            session.save(p1);*/

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
    public static void main(String[] args)
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        HibernateMain main = new HibernateMain();

        //main.saveUser_1(sf);
        //main.saveUser_2(sf);

        //main.saveUser_3(sf);

        //main.saveUser_4(sf);

        //main.saveUser_5(sf);

        //main.saveUser_7(sf);

        main.saveUser_8(sf);

        //main.getUser(1L,sf);
    }
}
