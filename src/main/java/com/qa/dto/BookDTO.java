package com.qa.dto;

public class BookDTO {
    private String title;
    private String year;
    private int authorId;
    private String category;

    public BookDTO(String year, int authorId, String category) {
        this.year = year;
        this.authorId = authorId;
        this.category = category;
    }

    public BookDTO(String title, String year, String category) {
        this.title = title;
        this.year = year;
        this.category = category;
    }

    public BookDTO(String title, String year, int authorId) {
        this.title = title;
        this.year = year;
        this.authorId = authorId;
    }

    public BookDTO(String title, String year, int authorId, String category) {
        this.title = title;
        this.year = year;
        this.authorId = authorId;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
