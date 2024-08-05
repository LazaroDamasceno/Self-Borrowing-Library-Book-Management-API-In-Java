package com.api.v1.borrower.helpers;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.domain.BorrowerRepository;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public final class FindBorrowerBySsn {

    @Autowired
    private BorrowerRepository repository;

    public Mono<Borrower> findBySsn(@NotNull @Size(min=9, max=9) String ssn) {
        return repository
                .getBySsn(ssn)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Borrower was not found.")));
    }

}
