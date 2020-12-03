package com.edu.studynotes.notes.dto;

import com.edu.studynotes.notes.models.Theme;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ThemeDTO {

    private Long id;

    private String fullName;

    private Date birthDay;

    private String email;

    private String nickName;

    private String password;

    private boolean status;

    private List<Theme> themes;
}
