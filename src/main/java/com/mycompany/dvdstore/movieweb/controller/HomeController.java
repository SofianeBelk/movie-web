package com.mycompany.dvdstore.movieweb.controller;

import java.util.List;

import com.mycompany.dvdstore.core.model.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import com.mycompany.dvdstore.movieweb.form.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/movie")
public class HomeController {

    @Autowired
    private MovieServiceInterface movieService ;

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    @GetMapping("/home")
    public String displayName(Model model){
        model.addAttribute("movies", movieService.getMovieList());
        return "dvdstore-home";
    }

    @GetMapping("/add-movie-form")
    public String displayMovieForm(@ModelAttribute  MovieForm movieForm){
        return "add-movie-form";
    }

    
}
