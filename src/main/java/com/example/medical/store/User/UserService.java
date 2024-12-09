package com.example.medical.store.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<?> registerUser(User user) {
        userRepository.save(user);
        return new ResponseEntity<>("Registration Successfull", HttpStatus.OK);
    }

    public ResponseEntity<?> loginUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            return new ResponseEntity<>("Login Succefull",HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid Credentials",HttpStatus.BAD_REQUEST);
    }
}
