package com.lms.controller.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Valid
public class AddBookRequest {

    @NotNull
    private String name;

    private String uri;

    private String thumbnail;

    @NotNull
    private String author;

    @NotNull
    private Double price;

    private String language;

    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }

    public String getThumbNail() {
        return thumbnail;
    }

    public String getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }

    public String getLanguage() {
        return language;
    }
}
