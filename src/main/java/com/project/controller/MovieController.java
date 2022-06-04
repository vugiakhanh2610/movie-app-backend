package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Category;
import com.project.entity.Movie;
import com.project.pojo.ResponseData;
import com.project.service.MovieService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class MovieController {
	@Autowired
	private MovieService service;

	@GetMapping("/movies")
	public ResponseEntity<ResponseData> getAllMovies(@RequestParam(name = "page") int page,
			@RequestParam(name = "size") int size) {
		return ResponseEntity.ok(service.findAll(page, size));
	}

	@GetMapping("/movie/{id}")
	public ResponseEntity<Movie> getById(@PathVariable int id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@GetMapping("/movies/{categoryId}")
	public ResponseEntity<List<Movie>> getByCategory(@PathVariable int categoryId) {
		Category category = new Category();
		category.setId(categoryId);
		return ResponseEntity.ok(service.findByCategory(category));
	}
	
	@GetMapping("/movies/search")
	public ResponseEntity<ResponseData> searchMovie(@RequestParam(name = "query") String keyword) {
		return ResponseEntity.ok(service.findBySearch(keyword));
	}

}
