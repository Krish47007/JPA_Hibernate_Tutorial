package org.krish.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue
    private int vehicleId;
    private String vehicleName;

   /* @ManyToOne
    @JoinColumn(name = "User_ID")
    private UserDetails userDetails;

    public UserDetails getUserDetails() {
        return userDetails;
    }
    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }*/

/*   @ManyToMany(mappedBy = "vList")
   private List<UserDetails> listOfUsers = new ArrayList<>();


    public List<UserDetails> getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(List<UserDetails> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }*/

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
