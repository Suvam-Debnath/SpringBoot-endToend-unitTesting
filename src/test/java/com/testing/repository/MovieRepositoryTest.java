package com.testing.repository;

import com.testing.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    private Movie avatarMovie;
    private Movie titanicMovie;

    @BeforeEach
    void init(){
        avatarMovie = new Movie();
        avatarMovie.setName("Avatar");;
        avatarMovie.setGenera("Action");
        avatarMovie.setReleaseDate(LocalDate.of(2000, Month.APRIL,22));

        titanicMovie = new Movie();
        titanicMovie.setName("Titanic");
        titanicMovie.setGenera("Romance");
        titanicMovie.setReleaseDate(LocalDate.of(1997, Month.DECEMBER, 19));
    }

    @Test
    @DisplayName("it should save the movie to the database")
    void save(){
        //Arrange - Setting up the data that required for the test case


        //Act - Calling a method/Unit that is being tested
        Movie newMovie = movieRepository.save(avatarMovie);

        //Assert - Verify that the expected result is correct or not
        assertNotNull(newMovie);
        assertThat(newMovie.getId()).isNotEqualTo(null);

    }
    @Test
    @DisplayName("it should return the movies list with size of 2")
    void getAllMovies(){

        //Arrange - Setting up the data that required for the test case
        movieRepository.save(avatarMovie);
        movieRepository.save(titanicMovie);

        List<Movie> list = movieRepository.findAll();
        assertNotNull(list);
        assertThat(list).isNotNull();
        assertEquals(2, list.size());

    }

    @Test
    @DisplayName("it should return the movie by its id")
    void getMovieId(){

        movieRepository.save(titanicMovie);

        Movie existingMovie = movieRepository.findById(titanicMovie.getId()).get();

        assertNotNull(existingMovie);
        assertEquals("Romance",existingMovie.getGenera());
        assertThat(titanicMovie.getReleaseDate()).isBefore(LocalDate.of(2000, Month.DECEMBER, 19));
    }

    @Test
    @DisplayName("It should update the existing movie with genra ACTION ")
    void updateMovie(){

        movieRepository.save(titanicMovie);

        Movie existingMovie = movieRepository.findById(titanicMovie.getId()).get();
        existingMovie.setGenera("Action");
        Movie newMovie = movieRepository.save(existingMovie);

        assertEquals("Action",newMovie.getGenera());
        assertEquals("Titanic",newMovie.getName());
    }

    @Test
    @DisplayName("It should delete the existing movie")
    void deleteMovie(){

        movieRepository.save(avatarMovie);
        Long id = avatarMovie.getId();

        movieRepository.save(titanicMovie);

        movieRepository.delete(avatarMovie);
        Optional<Movie> existingMovie = movieRepository.findById(id);
        List<Movie> list = movieRepository.findAll();

        assertEquals(1,list.size());
        assertThat(existingMovie).isEmpty();  // after deleting avatar movie it should return empty
    }

    @Test
    @DisplayName("It should return the list of movies with genera ROMANCE")
    void getMoviesByGenera(){

        movieRepository.save(avatarMovie);

        movieRepository.save(titanicMovie);

        List<Movie> list = movieRepository.findByGenera("Romance");

        assertNotNull(list);
        assertThat(list.size()).isEqualTo(1);
    }

}
