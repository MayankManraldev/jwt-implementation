package com.example.demo.serviceImpl;

import com.example.demo.service.UserService;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.User;
import com.example.demo.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserSeviceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public ResponseEntity<List<User>> findallUser() {
    	System.out.println("all users");
        List<User> all = (List<User>) userRepository.findAll();
        return new ResponseEntity<List<User>>(all, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> findbyName(String username) {
            Optional<User> user = userRepository.findByUsername(username);
            if(user.isPresent()) {
                return new ResponseEntity<User>(user.get(), HttpStatus.OK);
            }else{
                throw new UserNotFoundException(username+" "+"not found");
            }
    }

    @Override
    public ResponseEntity<List<User>> saveUsers(List<User> users){
        try{
            List<User> savedusers =new ArrayList<>();
            for(User user:users){
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                User save = userRepository.save(user);
                savedusers.add(save);
            }
            return new ResponseEntity<List<User>>(savedusers,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(users,HttpStatus.BAD_REQUEST);
        }
    }
}
