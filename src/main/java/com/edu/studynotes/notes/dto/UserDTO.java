package com.edu.studynotes.notes.dto;

import com.edu.studynotes.notes.models.Theme;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private Long id;

    private String fullName;

    private Date birthDay;

    private String email;

    private String nickName;

    private String password;

    private boolean active;

    private List<Theme> themes;
}
