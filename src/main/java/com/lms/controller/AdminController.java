package com.lms.controller;

import com.lms.controller.model.AddBookRequest;
import com.lms.controller.model.DeleteBookResponse;
import com.lms.model.Status;
import com.lms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/add-book")
    @ResponseBody
    public Status addBook(@Valid @RequestBody @NotNull List<AddBookRequest> addBookRequests) {
        if (addBookRequests.isEmpty()) {
            return Status.FAILED;
        }
        return adminService.addBook(addBookRequests);
    }

    @DeleteMapping("/delete-book")
    @ResponseBody
    public DeleteBookResponse deleteBook(@RequestParam(name = "name", required = true) @NotNull String bookName) {
        return adminService.deleteBook(bookName);
    }
}
