package com.edu.studynotes.notes.controllers;

import com.edu.studynotes.notes.models.BaseModel;
import com.edu.studynotes.notes.repositories.BaseRepo;
import com.edu.studynotes.notes.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericRestController<T extends BaseModel, DTO> {

    @Autowired
    private BaseRepo<T> dao;

    final Class<T> entityTypeClass = ((Class) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0]);

    final Class<DTO> dtoTypeClass = ((Class) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0]);

    @GetMapping("")
    public ResponseEntity<List<DTO>> list() {
        return new ResponseEntity<List<DTO>>(ObjectMapperUtils.mapAll(dao.findAll(), dtoTypeClass), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<DTO> create(@RequestBody DTO dto) {
        T result = ObjectMapperUtils.map(dto, entityTypeClass);
        return new ResponseEntity<DTO>(ObjectMapperUtils.map(dao.save(result), dtoTypeClass), HttpStatus.CREATED); }

    @PutMapping("")
    public ResponseEntity<DTO> update(@RequestBody DTO dto) {
        T result = ObjectMapperUtils.map(dto, entityTypeClass);
        return new ResponseEntity<DTO>(ObjectMapperUtils.map(dao.save(result), dtoTypeClass), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        dao.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DTO> get(@PathVariable(value = "id") long id) {
        T dbResult = dao.findById(id).orElseThrow(() -> new EntityNotFoundException("Invalid User id: " + id));
        return new ResponseEntity<DTO>(ObjectMapperUtils.map(dbResult, dtoTypeClass), HttpStatus.OK);
    }
}
