package com.lms.service.impl;

import com.lms.controller.model.BookResponse;
import com.lms.controller.model.SearchBookRequest;
import com.lms.controller.model.SortBookRequest;
import com.lms.model.Book;
import com.lms.model.ModelConverter;
import com.lms.persistence.LibraryDataStore;
import com.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.lms.controller.model.SortBookRequest.Sort.ASCENDING;
import static com.lms.controller.model.SortBookRequest.Sort.DESCENDING;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    LibraryDataStore libraryDataStore;

    @Override
    public List<BookResponse> getBooks() {
        return libraryDataStore.getAllBooks();
    }

    @Override
    public List<BookResponse> sortBooks(SortBookRequest sortBookRequest) {


        String sortBy = sortBookRequest.getSortBy();

        if (sortBy.equals("name") && sortBookRequest.getSortMethod() == ASCENDING) {
            return libraryDataStore.getAllBooks().stream()
                    .sorted((b1, b2) -> b1.getName().compareTo(b2.getName()))
                    .collect(Collectors.toList());
        }

        if (sortBy.equals("name") && sortBookRequest.getSortMethod() == DESCENDING) {
            return libraryDataStore.getAllBooks().stream()
                    .sorted((b1, b2) -> b2.getName().compareTo(b1.getName()))
                    .collect(Collectors.toList());
        }

        if (sortBy.equals("price") && sortBookRequest.getSortMethod() == ASCENDING) {
            return libraryDataStore.getAllBooks().stream()
                    .sorted(Comparator.comparing(BookResponse::getPrice))
                    .collect(Collectors.toList());
        }


        if (sortBy.equals("price") && sortBookRequest.getSortMethod() == DESCENDING) {
            return libraryDataStore.getAllBooks().stream()
                    .sorted((b1, b2) -> b2.getPrice().compareTo(b1.getPrice()))
                    .collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public List<BookResponse> searchBooks(SearchBookRequest searchBookRequest) {

        //better way to store data in a separate data store (key, value) based on search criteria

        if(searchBookRequest.getFilterBy().equals("book")) {
            Book book = libraryDataStore.findByName(searchBookRequest.getName());
            if(book == null) {
                return Collections.emptyList();
            }
            return Collections.singletonList(ModelConverter.toBookResponse(book));
        }

        if(searchBookRequest.getFilterBy().equals("author")) {
            List<BookResponse> books = libraryDataStore.getAllBooks();

            return books.stream()
                    .filter(book -> book.getAuthor().equals(searchBookRequest.getName()))
                    .collect(Collectors.toList());
        }

        if(searchBookRequest.getFilterBy().equals("price")) {
            List<BookResponse> books = libraryDataStore.getAllBooks();

            return books.stream()
                    .filter(book -> book.getPrice() == Double.parseDouble(searchBookRequest.getName()))
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }
}
