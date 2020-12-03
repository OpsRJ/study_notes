package com.edu.studynotes.notes.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "themes")
@Entity
@Data
public class Theme extends BaseModel {

    private String title;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "theme_id")
    List<Content> contents;
}
