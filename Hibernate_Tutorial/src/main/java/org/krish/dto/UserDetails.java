package org.krish.dto;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private Long id;
    @Column(name = "USER_NAME",nullable = false)
    private String userName;
    @Column(name = "JOINED_DATE")
    private LocalDateTime joinedDate;
    @Column(name = "USER_DESC")
    @Basic(fetch = FetchType.LAZY,optional = false)
    private String description;
    @Column(name = "USER_ADDRESS")
    private String address;
}
