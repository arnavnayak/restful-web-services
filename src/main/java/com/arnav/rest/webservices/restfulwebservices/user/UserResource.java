package com.arnav.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    UserDaoService userDaoService;

    //GET /users
    @GetMapping("/users")
    public List<User> getAllUser() {
        return userDaoService.findAll();
    }

    //GET /users/id
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        User userByID = userDaoService.findById(id);
        if (userByID == null) {
            throw new UserNotFoundException("Not found user id: " + id);
        }
        return userByID;

    }

    //POST /users
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    //DELETE /users/id
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable int id) {
        userDaoService.deleteById(id);

    }
}
