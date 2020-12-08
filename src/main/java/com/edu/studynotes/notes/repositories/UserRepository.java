package com.edu.studynotes.notes.repositories;

import com.edu.studynotes.notes.models.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepo<User> {

    public Optional<User> findByNickName(String nickname);
}
