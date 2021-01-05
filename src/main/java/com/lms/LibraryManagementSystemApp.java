package com.lms;

import com.lms.persistence.LibraryDataStore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class LibraryManagementSystemApp {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementSystemApp.class, args);
        System.out.println("Service Started Successfully on Port: 8080");
    }

    /**
     * Initialize Library data store to store books info
     */
    private static void init() {
        LibraryDataStore libraryDataStore = new LibraryDataStore();
    }
}
