package com.lms.service.impl;

import com.lms.controller.model.AddBookRequest;
import com.lms.controller.model.DeleteBookResponse;
import com.lms.model.Status;
import com.lms.persistence.LibraryDataStore;
import com.lms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private LibraryDataStore libraryDataStore;

    public AdminServiceImpl(LibraryDataStore libraryDataStore) {
        this.libraryDataStore = libraryDataStore;
    }

    @Override
    public Status addBook(List<AddBookRequest> addBookRequests) {

        if (addBookRequests.isEmpty()) {
            return Status.BAD_REQUEST;
        }

        //small validation to check book name author and price should not be empty or null
        if (!validate(addBookRequests)) {
            return Status.BAD_REQUEST;
        }
        return libraryDataStore.addBook(addBookRequests);
    }


    private boolean validate(List<AddBookRequest> addBookRequests) {
        return addBookRequests.stream()
                .anyMatch(AdminServiceImpl::validateBookNameAuthorAndPrice);
    }

    private static boolean validateBookNameAuthorAndPrice(AddBookRequest addBookRequest) {
        if (addBookRequest.getName() == null || addBookRequest.getName().equals(""))
            return false;
        if (addBookRequest.getAuthor() == null || addBookRequest.getAuthor().equals(""))
            return false;
        return addBookRequest.getPrice() != null;
    }

    @Override
    public DeleteBookResponse deleteBook(String bookName) {
        Status status = libraryDataStore.removeBook(bookName);
        DeleteBookResponse deleteBookResponse;
        if (status == Status.NOT_FOUND) {
            deleteBookResponse = new DeleteBookResponse(Status.NOT_FOUND, "Book Doesn't exist");
        } else {
            deleteBookResponse = new DeleteBookResponse(Status.SUCCESS, "Book " + bookName + " is Deleted");
        }
        return deleteBookResponse;
    }
}
