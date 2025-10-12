package com.testing.repository;

import com.testing.model.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    @DisplayName("it should save the movie to the database")
    void save(){
        //Arrange - Setting up the data that required for the test case
        Movie avatarMovie = new Movie();
        avatarMovie.setName("Avatar");;
        avatarMovie.setGenera("Action");
        avatarMovie.setReleaseDate(LocalDate.of(2000, Month.APRIL,22));

        //Act - Calling a method/Unit that is being tested
        Movie newMovie = movieRepository.save(avatarMovie);

        //Assert - Verify that the expected result is correct or not
        assertNotNull(newMovie);
        assertThat(newMovie.getId()).isNotEqualTo(null);

    }

}
