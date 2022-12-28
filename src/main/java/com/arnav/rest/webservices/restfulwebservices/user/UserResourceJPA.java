package com.arnav.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserResourceJPA {

    @Autowired
    UserDaoService userDaoService;

    @Autowired
    UserRepository userRepository;

    //GET /users
    @GetMapping("/jpa/users")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    //GET /users/id
    @GetMapping("/jpa/users/{id}")
    public User getUserById(@PathVariable int id) {
        Optional<User> userByID = userRepository.findById(id);
        if (userByID.isEmpty()) {
            throw new UserNotFoundException("Not found user id: " + id);
        }
        return userByID.get();

    }

    //POST /users
    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    //DELETE /users/id
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUserById(@PathVariable int id) {
        userRepository.deleteById(id);

    }
}
