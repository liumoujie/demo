package com.manulife.lmj.service;

import com.manulife.lmj.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<User> queryAllUsers();

    Mono<User> addUser(User u);

    Mono<User> updateUser(User u);

    Mono<Void> deleteUser(Long id);

    Mono<User> queryUser(Long id);
}
