package com.edu.studynotes.notes.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "contents")
@Entity
@Data
public class Content extends BaseModel {

    @Column(name = "topic_title")
    private String topicTitle;

    private String shortDescription;

    @Lob
    @Column(name = "description_text")
    private String description;

    @Column(name = "view_order", columnDefinition = "integer default 0")
    private Integer order;

    @ManyToOne(fetch = FetchType.LAZY)
    private Content parentTopic;

    @OneToMany(mappedBy = "parentTopic", fetch = FetchType.LAZY)
    List<Content> subTitles;
}
