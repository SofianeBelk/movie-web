package com.mycompany.dvdstore.movieweb.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class MovieForm {

    @NotBlank
    private String title;

    private String genre;
    private Long id;

    @Size(max=255)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
