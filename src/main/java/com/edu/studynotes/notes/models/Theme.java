package com.edu.studynotes.notes.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "themes")
@Entity
@Data
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @OneToMany
    @JoinColumn(name = "theme_id")
    List<Content> contents;
}
