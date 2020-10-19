package com.manulife.lmj.controller;

import com.manulife.lmj.model.Cases;
import com.manulife.lmj.model.Comments;
import com.manulife.lmj.model.Documents;
import com.manulife.lmj.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/lock")
public class LockTestController {
    @Autowired
    CaseService service;

    int i = 100000000;

    @GetMapping
    public Mono<String> getId() {
        return Mono.just(String.valueOf(i++));
    }

    @PostMapping("/addCase/{id}")
    public Mono<Cases> addCases(@PathVariable String id, @RequestBody Cases c) {
        return service.addCase(id, c);
    }

    @PostMapping("/addDocument/{id}")
    public Mono<Cases> addDocument(@PathVariable String id, @RequestBody Documents d) {
        return service.addDocument(id, d);
    }

    @PostMapping("/addComments/{id}")
    public Mono<Cases> addComments(@PathVariable String id, @RequestBody Comments c) {
        return service.addComment(id, c);
    }
}
