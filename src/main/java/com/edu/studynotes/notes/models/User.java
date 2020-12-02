package com.edu.studynotes.notes.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "users")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Temporal(TemporalType.DATE)
    private Date birthDay;

    private String nickName;

    private String password;

    private boolean status;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Theme> themes;
}
