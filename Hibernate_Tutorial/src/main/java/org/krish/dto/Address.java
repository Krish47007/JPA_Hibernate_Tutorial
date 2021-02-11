package org.krish.dto;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Address {  //Its a value object now and its associated with UserDetails

    private String street;
    private String city;
    private String state;
    private String pin;
}
