package org.krish.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Mobile")
public class Mobile extends Device{

    @Column(name = "Camera_setup")
    private String cameraType;
}
