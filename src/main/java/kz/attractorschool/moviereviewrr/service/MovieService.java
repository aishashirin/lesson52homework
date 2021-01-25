package kz.attractorschool.moviereviewrr.service;

import kz.attractorschool.moviereviewrr.model.Movie;
import kz.attractorschool.moviereviewrr.repository.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class MovieService {
    private MovieRepository movieRepository;

   public List<Movie> findMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public List<Movie> findMovieByReleaseYear(int year){
       return movieRepository.findByReleaseYear(year);
    }

    public List<Movie> findMovieByActor(String name){
       return movieRepository.findByActors(name);
    }

    public List<Movie> findMovieByRating(double rating){
       return movieRepository.findByRating(rating);
    }


}

