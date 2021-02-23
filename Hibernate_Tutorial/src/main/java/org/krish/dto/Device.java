package org.krish.dto;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Device")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "DEVICE",
        discriminatorType = DiscriminatorType.STRING
)
public abstract class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Device_ID")
    private Long id;
    @Column(name = "Device_TYPE")
    private String deviceType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="EMP_ID")
    private Employee employee;
}
