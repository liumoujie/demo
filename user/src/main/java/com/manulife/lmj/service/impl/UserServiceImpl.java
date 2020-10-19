package com.manulife.lmj.service.impl;

import com.manulife.lmj.model.User;
import com.manulife.lmj.repo.UserRepository;
import com.manulife.lmj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public Flux<User> queryAllUsers() {
        return repository.findAll();
    }

    @Override
    public Mono<User> addUser(User u) {
        return repository.save(u);
    }

    @Override
    public Mono<User> updateUser(User u) {
        return repository.save(u);
    }

    @Override
    public Mono<Void> deleteUser(Long id) {
        return repository.deleteById(id);
    }

    @Override
    public Mono<User> queryUser(Long id) {
        return repository.findById(id);
    }
}
