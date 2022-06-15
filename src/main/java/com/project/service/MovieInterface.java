package com.project.service;

import java.util.List;
import java.util.Map;

import com.project.entity.Category;
import com.project.entity.Movie;
import com.project.pojo.ResponseData;

public interface MovieInterface {
	ResponseData findAll(int page, int size);

	ResponseData findBySearch(String keyword);

	Map<String, ?> findById(int id);

	List<Movie> findByCategory(Category category);

}
