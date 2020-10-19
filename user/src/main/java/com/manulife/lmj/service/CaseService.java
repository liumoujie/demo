package com.manulife.lmj.service;

import com.manulife.lmj.model.Cases;
import com.manulife.lmj.model.Comments;
import com.manulife.lmj.model.Documents;
import reactor.core.publisher.Mono;

public interface CaseService {
    Mono<Cases> addCase(String id, Cases cases);

    Mono<Cases> addDocument(String id, Documents doc);

    Mono<Cases> addComment(String id, Comments comments);
}
