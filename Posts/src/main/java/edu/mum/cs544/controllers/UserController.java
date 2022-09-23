package edu.mum.cs544.controllers;

import edu.mum.cs544.entities.User;
import edu.mum.cs544.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
    public User get(@PathVariable int id) {
        return userService.get(id);
    }

    @PostMapping
    public User add(@RequestBody User user) {
        userService.add(user);
        return user;
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        return userService.delete((int) id);
    }

}
