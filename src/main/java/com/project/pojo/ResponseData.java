package com.project.pojo;

import java.util.List;

import com.project.entity.Movie;

import lombok.Data;

@Data
public class ResponseData {
	private List<Movie> movies;
	private int totalItems;
	private int totalPages;
}
