package com.lms.model;

import java.util.Date;
import java.util.Objects;

/**
 * Book Item Content:
 * 1. Name
 * 2. Author
 * 3. Publication Date
 * 4. Price
 * 5. Thumbnail Image
 * 6. Language
 */
public class Book {
    int id;
    String name;
    String author;
    Date publicationDate;
    Double price;
    String thumbnail;
    String URI;
    String language;


    public Book() {

    }

    public Book(String name,
                String author,
                Date publicationDate,
                Double price,
                String thumbnail,
                String URI,
                String language) {
        this.name = name;
        this.author = author;
        this.publicationDate = publicationDate;
        this.price = price;
        this.thumbnail = thumbnail;
        this.URI = URI;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public Book setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public Book setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Book setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public Book setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public String getURI() {
        return URI;
    }

    public Book setURI(String URI) {
        this.URI = URI;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public Book setLanguage(String language) {
        this.language = language;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                Objects.equals(publicationDate, book.publicationDate) &&
                Objects.equals(price, book.price) &&
                Objects.equals(thumbnail, book.thumbnail) &&
                Objects.equals(URI, book.URI) &&
                Objects.equals(language, book.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, publicationDate, price, thumbnail, URI, language);
    }
}
