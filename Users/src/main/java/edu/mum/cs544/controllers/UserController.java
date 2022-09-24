package edu.mum.cs544.controllers;

import edu.mum.cs544.dtos.GetUser;
import edu.mum.cs544.dtos.UpdateUser;
import edu.mum.cs544.entities.User;
import edu.mum.cs544.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public GetUser get(@PathVariable int id) {
        return userService.get(id);
    }

    @PostMapping
    public User add(@RequestBody User user) throws Exception {
        userService.add(user);
        return user;
    }

    @PutMapping
    public UpdateUser update(@RequestBody UpdateUser user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        return userService.delete((int) id);
    }
}
