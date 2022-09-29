package com.mycompany.dvdstore.movieweb.controller;

import com.mycompany.dvdstore.core.model.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import com.mycompany.dvdstore.movieweb.form.MovieForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieServiceInterface movieService ;

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    @GetMapping("/{id}")
    public String displayMovieCard(@PathVariable("id") Long number, Model model){
        model.addAttribute("movie",movieService.getMovieById(number));
        return "movie-details";
    }

    @PostMapping
    public String addMovie(@Valid @ModelAttribute MovieForm movieForm, BindingResult result){
        if(result.hasErrors()){
            return "add-movie-home";
        }
        System.out.println(result.hasErrors());
        System.out.println(result.toString());
        Movie movie = new Movie();
        movie.setId(movieForm.getId());
        movie.setTitle(movieForm.getTitle());
        movie.setGenre(movieForm.getGenre());
        movie.setDescription(movieForm.getDescription());
        movieService.registerMovie(movie);
        return "movie-added";
    }

}
