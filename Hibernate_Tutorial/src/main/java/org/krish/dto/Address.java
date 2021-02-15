package org.krish.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Address {  //Its a value object now and its associated with UserDetails

    @Column(name = "STREET_NAME")
    private String street;
    @Column(name = "CITY_NAME")
    private String city;
    @Column(name = "STATE_NAME")
    private String state;
    @Column(name = "PIN_CODE")
    private String pin;
}
