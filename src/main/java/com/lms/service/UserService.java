package com.lms.service;

import com.lms.controller.model.BookResponse;
import com.lms.controller.model.SearchBookRequest;
import com.lms.controller.model.SortBookRequest;

import java.util.List;

public interface UserService {

    List<BookResponse> getBooks();

    List<BookResponse> sortBooks(SortBookRequest sortBookRequest);

    List<BookResponse> searchBooks(SearchBookRequest searchBookRequest);

}
