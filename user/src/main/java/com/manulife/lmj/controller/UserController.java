package com.manulife.lmj.controller;

import com.manulife.lmj.model.User;
import com.manulife.lmj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RefreshScope
@RequestMapping("/user")
public class UserController {

    @Value("${first}")
    String name;

    @Value("${greed}")
    String greed;

    @Autowired
    UserService service;

    @GetMapping("")
    public Flux<User> getUsers() {
        System.out.println(name + greed);
        return service.queryAllUsers();
    }

    @PostMapping("")
    public Mono<User> addUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @GetMapping("/{id}")
    public Mono<User> queryUser(@PathVariable Long id) {
        return service.queryUser(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable Long id) {
        return service.deleteUser(id);
    }
}
