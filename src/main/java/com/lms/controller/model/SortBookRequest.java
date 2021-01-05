package com.lms.controller.model;

import javax.validation.constraints.NotNull;

public class SortBookRequest {

    @NotNull
    private String sortBy;

    @NotNull
    private Sort sortMethod;

    public enum Sort {
        ASCENDING, DESCENDING
    }

    public String getSortBy() {
        return sortBy;
    }

    public Sort getSortMethod() {
        return sortMethod;
    }
}
