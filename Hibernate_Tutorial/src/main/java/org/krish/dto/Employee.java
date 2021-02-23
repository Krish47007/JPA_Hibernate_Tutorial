package org.krish.dto;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_ID")
    private Long id;
    @Column(name = "EMP_NAME")
    private String name;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Device> deviceList;
}
