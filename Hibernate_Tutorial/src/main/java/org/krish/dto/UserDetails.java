package org.krish.dto;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "USER_DTLS")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;
    @Column(name = "USER_NAME",nullable = false)
    private String userName;
    @Column(name = "JOINED_DATE")
    private LocalDateTime joinedDate;
    @Column(name = "USER_DESC")
    private String description;
    /*@Column(name = "USER_ADDRESS")
    private String address;*/

/*    @Embedded
    @AttributeOverrides(
            {
                    @AttributeOverride(name = "street",column = @Column(name = "HOME_STREET_NAME")),
                    @AttributeOverride(name = "city",column = @Column(name = "HOME_CITY_NAME")),
                    @AttributeOverride(name = "state",column = @Column(name = "HOME_STATE_NAME")),
                    @AttributeOverride(name = "pin",column = @Column(name = "HOME_PIN_CODE"))
            }
    )
    private Address homeAddress;

    @Embedded
    @AttributeOverrides(
            {
                    @AttributeOverride(name = "street",column = @Column(name = "OFFICE_STREET_NAME")),
                    @AttributeOverride(name = "city",column = @Column(name = "OFFICE_CITY_NAME")),
                    @AttributeOverride(name = "state",column = @Column(name = "OFFICE_STATE_NAME")),
                    @AttributeOverride(name = "pin",column = @Column(name = "OFFICE_PIN_CODE"))
            }
    )
    private Address officeAddress;*/

    @ElementCollection
    private Set<Address> listOfAddress;
}
