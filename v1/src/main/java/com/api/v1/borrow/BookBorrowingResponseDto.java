package com.api.v1.borrow;

import com.api.v1.book.domain.Book;
import com.api.v1.borrower.domain.Borrower;

import java.math.BigInteger;

public record BookBorrowingResponseDto(
        BigInteger id,
        Borrower borrower,
        Book book,
        String borrowingDate,
        String dueDate
) {
}
