package com.lms.service;

import com.lms.controller.model.AddBookRequest;
import com.lms.controller.model.DeleteBookResponse;
import com.lms.model.Status;

import java.util.List;

public interface AdminService {

    Status addBook(List<AddBookRequest> addBookRequest);

    DeleteBookResponse deleteBook(String bookName);

}
