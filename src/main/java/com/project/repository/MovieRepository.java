package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entity.Category;
import com.project.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	List<Movie> findByCategory(Category category);
	
	@Query("SELECT m FROM movie m where CONCAT(m.title,' ',m.overview) LIKE %?1%")
	public List<Movie> search(String keyword);
}
