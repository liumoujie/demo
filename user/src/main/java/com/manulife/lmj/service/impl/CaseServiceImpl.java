package com.manulife.lmj.service.impl;

import com.manulife.lmj.model.Cases;
import com.manulife.lmj.model.Comments;
import com.manulife.lmj.model.Documents;
import com.manulife.lmj.repo.CasesRepository;
import com.manulife.lmj.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CaseServiceImpl implements CaseService {
    @Autowired
    CasesRepository repository;

    int caseid = 12345678;

    @Override
    public Mono<Cases> addCase(String number, Cases cases) {
        cases.setId(getCaseId());
        return repository.findByNumber(number).flatMap(cases1 -> {
            cases.setId(cases1.getId());
            return repository.save(cases);
        }).switchIfEmpty(repository.save(cases));
    }

    @Override
    public Mono<Cases> addDocument(String id, Documents doc) {

        return null;
    }

    @Override
    public Mono<Cases> addComment(String id, Comments comments) {
        return null;
    }

    private synchronized Long getCaseId() {
        return Long.valueOf(caseid++);
    }
}
