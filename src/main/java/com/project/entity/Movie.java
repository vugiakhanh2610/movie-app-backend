package com.project.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "movie")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;

	@Column(name = "vote_average")
	private double vote;

	@Column(name = "overview")
	private String overview;
	
	@Column(name = "release_date")
	private String date;
	
	@Column(name = "poster_path")
	private String posterPath;
	
	@Column(name = "backdrop_path")
	private String backdropPath;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToMany(mappedBy = "movie")
	private Set<MovieGenre> movieGenre;
	
	@Transient
	private List<String> genres;
}
