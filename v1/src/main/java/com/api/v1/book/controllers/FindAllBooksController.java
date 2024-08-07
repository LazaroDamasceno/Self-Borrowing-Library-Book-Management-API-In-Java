package com.api.v1.book.controllers;

import com.api.v1.book.helpers.BookResponse;
import com.api.v1.book.services.FindAllBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/v1/books")
public class FindAllBooksController {

    @Autowired
    private FindAllBooksService service;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponse> findAll() {
        return service.findAll();
    }

}
