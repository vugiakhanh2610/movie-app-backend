package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
	@Query("SELECT g.name from genre g INNER JOIN g.movieGenre mg ON g.id = mg.genre.id WHERE mg.movie.id = ?1")
	List<String> findByMovieId(int id);
}
