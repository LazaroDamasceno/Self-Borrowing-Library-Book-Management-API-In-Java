package com.api.v1.borrow.domain;

import com.api.v1.book.domain.Book;
import com.api.v1.borrower.domain.Borrower;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface BorrowRepository extends ReactiveCrudRepository<Borrow, ObjectId> {

    @Query("""
            {
                'borrower': { $eq borrower },
                'book': { $eq book },
                'returnedDate': null
            }
    """)
    Mono<Borrow> findActiveBorrow(Borrower borrower, Book book);

    @Query("""
        {
            'borrower': { $eq borrower },
            'book': { $eq book }
        }
    """)
    Mono<Borrow> findAnyBorrow(Borrower borrower, Book book);

    @Query("""
        {
            'borrower': { $eq borrower },
            'returnedDate': null
        }
    """)
    Mono<Long> countHowManyActiveBorrowsByBorrower(Borrower borrower);

}
