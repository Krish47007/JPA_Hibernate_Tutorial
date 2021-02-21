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
@Table(name = "Project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "P_ID")
    private Long id;
    @Column(name = "PROJECT_NAME")
    private String projectName;

    @ManyToMany(mappedBy = "projectList",cascade = CascadeType.ALL)
    private List<UserDetails> empList;

}
