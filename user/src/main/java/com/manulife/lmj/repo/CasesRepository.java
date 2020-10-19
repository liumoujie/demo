package com.manulife.lmj.repo;

import com.manulife.lmj.model.Cases;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CasesRepository extends ReactiveMongoRepository<Cases, Long> {
    Mono<Cases> findByNumber(String number);
}
