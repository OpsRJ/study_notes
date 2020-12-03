package com.edu.studynotes.notes.repositories;

import com.edu.studynotes.notes.models.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface BaseRepo<T extends BaseModel> extends JpaRepository<T, Serializable> {

}
