package com.edu.studynotes.notes.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Base64;
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

    private String nickName;

    private String email;

    private String password;

    private boolean status;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<Theme> themes;

    @PrePersist
    @PreUpdate
    private void hashPwd() {
        this.password = Base64.getEncoder().encodeToString(this.password.getBytes());
    }
}
