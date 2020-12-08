package com.edu.studynotes.notes.services;

import com.edu.studynotes.notes.models.MyUserPrincipal;
import com.edu.studynotes.notes.models.User;
import com.edu.studynotes.notes.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public User findOne(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Invalid User id: " + id));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User save(User user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<User> findByNickName(String nickName) {
        return repository.findByNickName(nickName);
    }

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        User user = repository.findByNickName(nickname)
                    .orElseThrow(() -> new UsernameNotFoundException("No user Found!"));

        return new MyUserPrincipal(user);
    }
}
