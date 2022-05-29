package com.example.associationamal.ws;


import com.example.associationamal.bean.User;
import com.example.associationamal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("assoxiation-amal/user/")
public class UserProvided {
    @GetMapping("login/{login}")
    public User findByLogin(@PathVariable String login) {
        return userService.findByLogin(login);
    }

    @PostMapping()
    public int save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("login/{login}/role/{role}")
    public int change_role(@PathVariable String login, @PathVariable String role) {
        return userService.change_role(login, role);
    }

    @GetMapping("login/{login}/status/{status}")
    public int change_status(@PathVariable String login, @PathVariable boolean status) {
        return userService.change_status(login, status);
    }

    @GetMapping("login/{login}/password/{password}")
    public User findByLoginAndPassword(@PathVariable String login, @PathVariable String password) {
        return userService.findByLoginAndPassword(login, password);
    }

    @DeleteMapping("login/{login}")
    public int deleteByLogin(@PathVariable String Login) {
        return userService.deleteByLogin(Login);
    }

    @GetMapping("")
    public List<User> findAll() {
        return userService.findAll();
    }

    @Autowired
    private UserService userService;
}
