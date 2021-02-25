package org.krish.dto;

import lombok.*;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Laptop")
public class Laptop extends Device{

    @Column(name = "SSD_TYPE")
    private String ssdType;
}
