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
@Table(name = "DEPARTMENT")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPT_ID")
    private Long id;
    @Column(name = "DEPT_NAME")
    private String deptName;

    @OneToMany(mappedBy = "department")
  /*  @JoinTable(
            name = "USER_DEPT",
            joinColumns = @JoinColumn(name = "DEPT_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID")
    )*/
    private List<UserDetails> employeeList;
}
