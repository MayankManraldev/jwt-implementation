package com.example.demo.Service;

import com.example.demo.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    ResponseEntity<List<User>> findallUser();
    ResponseEntity<User> findbyName(String username);
    ResponseEntity<List<User>> saveUsers(List<User> users);
}
