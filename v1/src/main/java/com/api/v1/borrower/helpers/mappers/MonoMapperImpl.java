package com.api.v1.borrower.helpers.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.helpers.dtos.BorrowerResponse;

import reactor.core.publisher.Mono;

@Component
final class MonoMapperImpl implements MonoMapper {

    @Autowired
    private BorrowerResponseMapper mapper;

    @Override
    public Mono<BorrowerResponse> mapFromMono(Mono<Borrower> mono) {
        return mono.map(mapper::mapFromBorrower);
    }
    
}
