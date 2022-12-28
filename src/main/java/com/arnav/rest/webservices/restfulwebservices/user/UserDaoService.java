package com.arnav.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    //JPA/Hibernate to access DB
    //for now static list will create

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 0;
    static {
        users.add(new User(++usersCount,"Arnav", LocalDate.now().minusYears(27)));
        users.add(new User(++usersCount,"Neil", LocalDate.now().minusYears(22)));
        users.add(new User(++usersCount,"NeilArnav", LocalDate.now().minusYears(25)));
    }
    //list all users from static list
    public List<User> findAll() {
        return users;
    }

    //list user by id
    public User findById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    //save user in a static list
    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    //deletes an user by id
    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
