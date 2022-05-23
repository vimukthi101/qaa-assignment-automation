package com.qa.constants;

public enum Category {
    DEFAULT("Undefined"),
    COMEDY("Comedy"),
    DRAMA("Drama"),
    HORROR_FICTION("Horror Fiction"),
    LITERARY_REALISM("Literary Realism"),
    ROMANCE("Romance"),
    SATIRE("Satire"),
    TRAGEDY("Tragedy"),
    TRAGICOMEDY("Tragicomedy"),
    FANTASY("Fantasy"),
    MYTHOLOGY("Mythology");

    private String category;

    Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
