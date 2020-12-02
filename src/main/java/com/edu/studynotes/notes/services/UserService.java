package com.edu.studynotes.notes.services;

import com.edu.studynotes.notes.models.User;
import com.edu.studynotes.notes.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public User findOne(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Invalid User id: " + id));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
