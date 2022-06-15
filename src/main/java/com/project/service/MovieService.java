package com.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.project.entity.Category;
import com.project.entity.Movie;
import com.project.exception.MovieNotFoundException;
import com.project.pojo.ResponseData;
import com.project.repository.MovieRepository;

@Service
public class MovieService implements MovieInterface {
	@Autowired
	MovieRepository movieRepository;

	@Override
	public ResponseData findAll(int page, int size) {
		List<Movie> movies = movieRepository.findAll(PageRequest.of(page, size)).getContent();
		int totalItems = movieRepository.findAll().size();
		int totalPages = (int) Math.ceil((double) totalItems / size);

		ResponseData data = new ResponseData();
		data.setMovies(movies);
		data.setTotalItems(totalItems);
		data.setTotalPages(totalPages);
		return data;
	}

	@Override
	public Map<String, ?> findById(int id) {
		Map<String, ?> map = movieRepository.GetMovieById(id);
		if (map.size() > 0) {
			return map;
		} else
			throw new MovieNotFoundException("Movie not found !");
	}

	@Override
	public List<Movie> findByCategory(Category category) {
		List<Movie> movies = movieRepository.findByCategory(category);
		if (movies.size() > 0) {
			return movies;
		} else
			throw new MovieNotFoundException("Movie not found !");
	}

	@Override
	public ResponseData findBySearch(String keyword) {
		List<Movie> movies = movieRepository.search(keyword);
		int totalItems = movies.size();
		int totalPages = 1;

		ResponseData data = new ResponseData();
		data.setMovies(movies);
		data.setTotalItems(totalItems);
		data.setTotalPages(totalPages);
		return data;
	}
}
