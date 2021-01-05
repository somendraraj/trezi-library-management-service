package com.lms.controller;

import com.lms.controller.model.BookResponse;
import com.lms.controller.model.SearchBookRequest;
import com.lms.controller.model.SortBookRequest;
import com.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/books")
    @ResponseBody
    public List<BookResponse> getBooks() {
        return userService.getBooks();
    }

    @PostMapping("/books")
    @ResponseBody
    public List<BookResponse> sortBooks(@Valid @RequestBody @NotNull SortBookRequest sortBookRequest) {
        return userService.sortBooks(sortBookRequest);
    }

    @PostMapping("search/books")
    @ResponseBody
    public List<BookResponse> searchBooks(@Valid @RequestBody @NotNull SearchBookRequest searchBookRequest) {
        return userService.searchBooks(searchBookRequest);
    }

}
