package kz.attractorschool.moviereviewrr.repository;

import kz.attractorschool.moviereviewrr.model.Movie;
import kz.attractorschool.moviereviewrr.model.Review;
import kz.attractorschool.moviereviewrr.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends CrudRepository<Review, String> {
    List<Review> findByReviewerOrMovie(Optional<User> reviewer, Optional<Movie> movie);

    List<Review> findByMovie(Optional<Movie> movie);

    boolean existsByReviewerAndMovie(Optional<User> reviewer, Optional<Movie> movie);


}
