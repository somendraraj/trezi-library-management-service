package com.lms.controller.model;

public class BookResponse {
    String name;
    String author;
    Double price;
    String thumbnailImage;
    String URI;

    public BookResponse(String name,
                        String author,
                        Double price,
                        String thumbnailImage,
                        String URI) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.thumbnailImage = thumbnailImage;
        this.URI = URI;
    }


    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public String getURI() {
        return URI;
    }
}
