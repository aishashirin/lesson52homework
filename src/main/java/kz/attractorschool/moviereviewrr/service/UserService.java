package kz.attractorschool.moviereviewrr.service;

import kz.attractorschool.moviereviewrr.model.User;
import kz.attractorschool.moviereviewrr.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean checkEmail(String email){
        return userRepository.existByEmail(email);
    }

    public User findByName(String name){
        return userRepository.findByName(name);
    }
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

}
