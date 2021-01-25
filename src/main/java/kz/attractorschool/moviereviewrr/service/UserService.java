package kz.attractorschool.moviereviewrr.service;

import kz.attractorschool.moviereviewrr.model.User;
import kz.attractorschool.moviereviewrr.repository.UserRepository;

public class UserService {
    private UserRepository userRepository;

    private boolean checkEmail(String email){
        return userRepository.existByEmail(email);
    }

    private User findByName(String name){
        return userRepository.findByName(name);
    }
}
