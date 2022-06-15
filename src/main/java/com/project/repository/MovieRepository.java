package com.project.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.entity.Category;
import com.project.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	List<Movie> findByCategory(Category category);

	@Query(value = "call GetMovieById(:id)", nativeQuery = true)
	Map<String, ?> GetMovieById(@Param("id") Integer id);

	@Query("SELECT m FROM movie m where CONCAT(m.title) LIKE %?1%")
	public List<Movie> search(String keyword);
}
