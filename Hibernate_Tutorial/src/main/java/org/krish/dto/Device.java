package org.krish.dto;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Device")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Device {

    @Id
    @TableGenerator(
            name = "DEVICE_GEN",
            table = "DEVICE_SEQUENCE",
            pkColumnName = "name",
            valueColumnName = "sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "DEVICE_GEN")
    @Column(name = "Device_ID")
    private Long id;
    @Column(name = "Device_TYPE")
    private String deviceType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="EMP_ID")
    private Employee employee;
}
