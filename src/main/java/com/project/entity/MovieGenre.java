package com.project.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "movie_genre")
public class MovieGenre implements Serializable {
	private static final long serialVersionUID = -7817224776021728682L;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_movie")
	private Movie movie;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_genre")
	private Genre genre;
}
