package com.edu.studynotes.notes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "users")
@Entity
@Data
public class User extends BaseModel {

    @Column(name = "full_name")
    private String fullName;

    @Temporal(TemporalType.DATE)
    private Date birthDay;

    @Column(unique = true)
    private String nickName;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    private boolean active;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<Theme> themes;
}
