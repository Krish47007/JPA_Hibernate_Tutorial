package org.krish.dto;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

//@Entity(name = "USER_DETAILS")
@Entity
@Table(name = "USER_DTLS")
public class UserDetails {

    @Id
    @Column(name = "user_id")
    @GeneratedValue
    private int userId;
    @Column(name = "user_name")
    private String userName;
    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    /* @Transient
     private String address;//This will not be persisted in DB*/
    @Lob
    private String description;

   /*@AttributeOverrides({
           @AttributeOverride(name = "street" , column = @Column(name = "HOME_STREET_NAME")),
           @AttributeOverride(name = "city" , column = @Column(name = "HOME_CITY_NAME")),
           @AttributeOverride(name = "state" , column = @Column(name = "HOME_STATE_NAME")),
           @AttributeOverride(name = "phone" , column = @Column(name = "HOME_PHONE_NUM")),
   })
    @Embedded   //Optional to mention here
    private Address homeAddress;

    @Embedded   //Optional to mention here
    private Address officeAddress;

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
*/
/*
   //Saving collections - a list of Addresses
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ADDRESS",
                joinColumns = @JoinColumn(name = "USER_ID")
    )
   *//* @GenericGenerator(name = "increment-gen",strategy = "increment")
    @CollectionId(columns = { @Column(name = "ADDRESS_ID") },generator = "increment-gen",type = @Type(type = "long"))*//*
    private List<Address> listOfAddress = new ArrayList<>();

    public List<Address> getListOfAddress() {
        return listOfAddress;
    }

    public void setListOfAddress(List<Address> listOfAddress) {
        this.listOfAddress = listOfAddress;
    }*/

/*    @OneToOne
    @JoinColumn(name = "VEHICLE_ID")
    private Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }*/

    /*
        @OneToMany(mappedBy = "userDetails")
        @JoinTable(name = "USER_VEHICLE", joinColumns = @JoinColumn(name = "USER_ID"),
                    inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID")
                  )*/
   /* @ManyToMany
    @JoinTable(name = "USER_VEHICLE",
               joinColumns = @JoinColumn(name = "USER_ID"),
               inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID")
    )*/
    @OneToMany(cascade = CascadeType.PERSIST)
    List<Vehicle> vList = new ArrayList<>();

    public List<Vehicle> getvList() {
        return vList;
    }

    public void setvList(List<Vehicle> vList) {
        this.vList = vList;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

   /* public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }*/

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
