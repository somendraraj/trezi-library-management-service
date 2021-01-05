package com.lms.persistence;

import com.lms.controller.model.AddBookRequest;
import com.lms.controller.model.BookResponse;
import com.lms.model.Book;
import com.lms.model.ModelConverter;
import com.lms.model.Status;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LibraryDataStore {

    private LinkedHashMap<String, Book> bookMap;

    public LibraryDataStore() {
        this.bookMap = new LinkedHashMap<>();
    }

    public List<BookResponse> getAllBooks() {
        return bookMap.values().stream()
                .map(ModelConverter::toBookResponse)
                .collect(Collectors.toList());
    }

    public Status addBook(List<AddBookRequest> addBookRequests) {
        for (AddBookRequest addBookRequest : addBookRequests) {
            Book book = ModelConverter.convertToBook(addBookRequest);
            if (bookMap.get(book.getName()) == null) {
                bookMap.put(book.getName(), book);
            } else {
                return Status.FAILED;
            }

        }
        System.out.println(bookMap);
        return Status.SUCCESS;
    }

    public Status removeBook(String bookName) {
        if (bookMap.containsKey(bookName)) {
            bookMap.remove(bookName);
            return Status.SUCCESS;
        }
        return Status.NOT_FOUND;
    }

    public Book findByName(String bookName) {
        return bookMap.get(bookName);
    }

}
