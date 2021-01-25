package kz.attractorschool.moviereviewrr.service;

import kz.attractorschool.moviereviewrr.model.Movie;
import kz.attractorschool.moviereviewrr.model.User;
import kz.attractorschool.moviereviewrr.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {
    private MovieRepository movieRepository;

    public Optional<Movie> findById(String id) {
        return movieRepository.findById(id);
    }

    public List<Movie> findMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public List<Movie> findMovieByReleaseYear(int year) {
        return movieRepository.findByReleaseYear(year);
    }

    public List<Movie> findMovieByActor(String name) {
        return movieRepository.findByActors(name);
    }

    public List<Movie> findMovieByRating(double rating) {
        return movieRepository.findByRating(rating);
    }

    public Page<Movie> sortByTitle() {
        Sort sort = Sort.by(Sort.Order.asc("title"));
        int page = 1;
        int size = 3;
        Pageable pageable = PageRequest.of(page, size, sort);
        return movieRepository.findAll(pageable);
    }

    public Page<Movie> sortingByRating() {
        Sort sort = Sort.by(Sort.Order.desc("rating"));
        int page = 1;
        int size = 3;
        Pageable pageable = PageRequest.of(page, size, sort);
        return movieRepository.findAll(pageable);
    }
}

