package com.manulife.lmj.basic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RestController
public class GenernateController {

    int i = 0;

    @RequestMapping("/getId")
    public Mono<String> getId() {
        i++;
        return Mono.just(String.valueOf(i));
    }

    volatile int idx = 0;

    @RequestMapping("/getVolatileId")
    public Mono<String> getVolatileId() {
        idx++;
        return Mono.just(String.valueOf(idx));
    }

    AtomicInteger integer = new AtomicInteger(0);

    @RequestMapping("/getAtomicIntegerId")
    public Mono<String> getAtomicIntegerId() {
        return Mono.just(String.valueOf(integer.incrementAndGet()));
    }

    int syncInt = 0;

    @RequestMapping("/getSyncId")
    public synchronized Mono<String> getSyncId() {
        syncInt++;
        return Mono.just(String.valueOf(syncInt));
    }

    int lockInt = 0;
    Lock lock = new ReentrantLock();

    @RequestMapping("/getLockId")
    public Mono<String> getLockId() {
        lock.lock();
        try {
            lockInt++;
            return Mono.just(String.valueOf(lockInt));
        } finally {
            lock.unlock();
        }
    }

}
