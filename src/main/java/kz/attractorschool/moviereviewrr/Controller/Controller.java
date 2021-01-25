package kz.attractorschool.moviereviewrr.Controller;

import kz.attractorschool.moviereviewrr.model.Movie;
import kz.attractorschool.moviereviewrr.model.Review;
import kz.attractorschool.moviereviewrr.model.User;
import kz.attractorschool.moviereviewrr.service.MovieService;
import kz.attractorschool.moviereviewrr.service.ReviewService;
import kz.attractorschool.moviereviewrr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    UserService userService;
    @Autowired
    ReviewService reviewService;
    @Autowired
    MovieService movieService;

    @GetMapping("/email")
    public boolean checkUserById(@RequestParam("email") String email) {
        return userService.checkEmail(email);
    }

    @GetMapping("/review/byReviewer")
    public List<Review> reviewsByReviewer(@RequestParam("user_id") String userId) {
        Optional<User> user = userService.findById(userId);
        return reviewService.findByReviewer(user);
    }

    @GetMapping("/review/byMovie")
    public List<Review> reviewsByMovie(@RequestParam("movie_id") String movieId) {
        Optional<Movie> movie = movieService.findById(movieId);
        return reviewService.findByMovie(movie);
    }

    @GetMapping("/review/checkReviewByUser")
    public boolean checkReviewerByUser(@RequestParam("userId") String userId, @RequestParam("movieId") String movieId) {
        Optional<Movie> movie = movieService.findById(movieId);
        Optional<User> user = userService.findById(userId);
        return reviewService.checkReviewFromUser(user, movie);
    }

    @GetMapping("/movies/byTitle")
    public List<Movie> findMovieByTitle(@RequestParam("title") String title) {
        return movieService.findMovieByTitle(title);
    }

    @GetMapping("/movies/byReleaseYear")
    public List<Movie> findMovieByReleaseYear(@RequestParam("releaseYear") int year) {
        return movieService.findMovieByReleaseYear(year);
    }

    @GetMapping("/movies/byActor")
    public List<Movie> findMoviesByActor(@RequestParam("actor") String name) {
        return movieService.findMovieByActor(name);
    }

    @GetMapping("/movie/byRating")
    public List<Movie> findMoviesByRating(@RequestParam("rating") double rating) {
        return movieService.findMovieByRating(rating);
    }

    @GetMapping("/moviePage/sortByTitle")
    public Page<Movie> pageSortByTitle() {
        return movieService.sortByTitle();
    }

    @GetMapping("/moviePage/sortByRating")
    public Page<Movie> pageSortByRating() {
        return movieService.sortingByRating();
    }

    @GetMapping("/user/findByName")
    public User findUserByName(@RequestParam("name") String name) {
        return userService.findByName(name);
    }

}
