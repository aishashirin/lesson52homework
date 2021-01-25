package kz.attractorschool.moviereviewrr.service;

import kz.attractorschool.moviereviewrr.model.Movie;
import kz.attractorschool.moviereviewrr.model.Review;
import kz.attractorschool.moviereviewrr.model.User;
import kz.attractorschool.moviereviewrr.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewService {
    private ReviewRepository reviewRepository;

    public List<Review> findByReviewer(Optional<User> user){
        return reviewRepository.findByReviewer(user);
    }

    public List<Review> findByMovie(Optional<Movie> movie){
        return reviewRepository.findByMovie(movie);
    }

    public boolean checkReviewFromUser(Optional<User> user,Optional<Movie> movie){
        return reviewRepository.existsByReviewerAndMovie(user,movie);
    }

}
