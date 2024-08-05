package com.api.v1.borrower.services;

import com.api.v1.borrower.helpers.dtos.BorrowerResponse;

import reactor.core.publisher.Flux;

public interface FindAllBorrowersService {

    Flux<BorrowerResponse> findAll();

}