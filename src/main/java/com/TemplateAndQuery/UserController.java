package com.TemplateAndQuery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;
    
    
    @PostMapping("/saveAll")
    public List<User> postTheField(@RequestBody List<User> users) {
        if (users == null || users.isEmpty()) {
            throw new IllegalArgumentException("The given Iterable of entities cannot be null or empty");
        }
        return userRepository.saveAll(users);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/by-name")
    public List<User> getUsersByName(@RequestParam(name="enterthename") String name) {
        return userRepository.findByName(name);
    }

    @GetMapping("/users/younger-than")
    public List<User> getUsersYoungerThan(@RequestParam(name="entertheage") int age) {
        return userService.findUsersYoungerThan(age);
    }

    @GetMapping("/users/younger-than-or-equal")
    public List<User> getUsersYoungerThanOrEqual(@RequestParam(name="enterage") int age) {
        return userService.findUsersYoungerThanOrEqual(age);
    }

    @GetMapping("/users/older-than")
    public List<User> getUsersOlderThan(@RequestParam(name="enteryourage") int age) {
        return userService.findUsersOlderThan(age);
    }

    @GetMapping("/users/older-than-or-equal")
    public List<User> getUsersOlderThanOrEqual(@RequestParam(name="enteryoursage") int age) {
        return userService.findUsersOlderThanOrEqual(age);
    }

    @GetMapping("/users/by-name-and-age")
    public List<User> getUsersByNameAndAge(@RequestParam(name="enteryourname") String name, @RequestParam(name="entertheages") int age) {
        return userService.findByNameAndAge(name, age);
    }

    @GetMapping("/users/by-name-or-age")
    public List<User> getUsersByNameOrAge(@RequestParam(name="enteryoursname") String name, @RequestParam(name="entertheage1") int age) {
        return userService.findByNameOrAge(name, age);
    }
}

