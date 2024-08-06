package com.api.v1.book.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Document(collection = "v1_books")
public class Book {

    @Id
    private UUID id;

    @Field
    private String title;

    @Field
    private String subtitle;

    @Field
    private String isbn;

    @Field
    private String author;

    @Field
    private String field;

    @Field
    private int numberOfPages;

    @Field
    private int version;

    @Field
    private String addedAt;

    @Field
    private String updatedAt;

    public Book() {}

    public Book(
            UUID id,
            String title,
            String subtitle,
            String isbn,
            String author,
            String field,
            int numberOfPages,
            int version,
            String addedAt
    ) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.isbn = isbn;
        this.author = author;
        this.field = field;
        this.numberOfPages = numberOfPages;
        this.version = version;
        this.addedAt = addedAt;
    }

    public String getFullTitle() {
        if (subtitle.isEmpty()) return title;
        return "%s: %s".formatted(title, subtitle);
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getField() {
        return field;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getVersion() {
        return version;
    }

    public String getAddedAt() {
        return addedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

}
