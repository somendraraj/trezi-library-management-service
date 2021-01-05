package com.lms.controller.model;

import javax.validation.constraints.NotNull;

public class SearchBookRequest {

    @NotNull
    private String filterBy;

    @NotNull
    private String name;

    public String getFilterBy() {
        return filterBy;
    }

    public String getName() {
        return name;
    }
}
