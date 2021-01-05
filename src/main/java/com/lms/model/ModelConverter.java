package com.lms.model;

import com.lms.controller.model.AddBookRequest;
import com.lms.controller.model.BookResponse;

public class ModelConverter {

    public static Book convertToBook(AddBookRequest addBookRequest) {
        Book book = new Book();
        book.setName(addBookRequest.getName());
        book.setAuthor(addBookRequest.getAuthor());
        book.setThumbnail(addBookRequest.getThumbNail());
        book.setURI(addBookRequest.getUri());
        book.setPrice(addBookRequest.getPrice());
        book.setLanguage(addBookRequest.getLanguage());
        return book;
    }

    public static BookResponse toBookResponse(Book book) {
        BookResponse bookResponse = new BookResponse(book.getName(),
                book.getAuthor(),
                book.getPrice(),
                book.getThumbnail(),
                book.getURI());
        return bookResponse;
    }
}
