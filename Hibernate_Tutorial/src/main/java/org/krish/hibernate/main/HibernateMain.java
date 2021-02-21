package org.krish.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.krish.dto.Address;
import org.krish.dto.UserDetails;
import org.krish.dto.Vehicle;
import org.krish.hibernate.util.HibernateUtil;

import java.util.Date;

public class HibernateMain {

    public static void main(String[] args) {

       /* //Home Address
        Address homeAddress = new Address();
        homeAddress.setCity("NY");
        homeAddress.setPhone("123455");
        homeAddress.setStreet("XYZ Lane");

        //OfficeAddress
        Address officeAddress = new Address();
        officeAddress.setCity("Atlanta");
        officeAddress.setPhone("97845");
        officeAddress.setStreet("ABC Lane");*/

        UserDetails userDetails = new UserDetails();
        //setting values
        //userDetails.setUserId(1);
        userDetails.setUserName("Kirk");
        userDetails.setJoinedDate(new Date());
        /*userDetails.setHomeAddress(homeAddress);
        userDetails.setOfficeAddress(officeAddress);*/
      /*  userDetails.getListOfAddress().add(homeAddress);
        userDetails.getListOfAddress().add(officeAddress);*/
        userDetails.setDescription("Star Trek TOS Captain");

      /*  UserDetails userDetails1 = new UserDetails();
        userDetails1.setUserName("Picard");
        userDetails1.setJoinedDate(new Date());
        //userDetails1.setAddress("XYZ Lane,CA");
        userDetails1.setDescription("Star Trek TNG Captain");*/

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Lamborghini");
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("Mercedes Benz");
        //Map Vehicle to User
       /* vehicle.setUserDetails(userDetails);
        vehicle2.setUserDetails(userDetails);*/
      /* vehicle.getListOfUsers().add(userDetails);
        vehicle.getListOfUsers().add(userDetails1);

        vehicle2.getListOfUsers().add(userDetails);*/
        //Map vehicle to user
        userDetails.getvList().add(vehicle);
        userDetails.getvList().add(vehicle2);
        //userDetails1.getvList().add(vehicle2);

        //Obtaining SessionFactory
        SessionFactory factory = HibernateUtil.getSessionFactory();
        //creating a session
        Session session = factory.openSession();
        //creating a new transaction
        session.beginTransaction();

        try {
            //Saving the object
            //session.save(userDetails);
            //session.save(userDetails1);
            /*session.save(vehicle);
            session.save(vehicle2);*/
            session.persist(userDetails);

            //Committing and ending the transaction
            session.getTransaction().commit();

/*            //Closing the current session
            session.close();
            userDetails = null;

            //Creating a new session
            session = factory.openSession();
            session.beginTransaction();
            //userDetails = session.get(UserDetails.class,1);
            userDetails = session.load(UserDetails.class,1);
            System.out.println("User retrieved is: "+userDetails.getUserName());

            System.out.println("Address list size: "+userDetails.getListOfAddress().size());
            System.out.println("Fetch Ends");*/


        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }
       /* finally {
            if(session != null)
                session.close();
        }*/
    }
}
