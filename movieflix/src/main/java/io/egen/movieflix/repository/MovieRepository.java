package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.entity.Movie;

public interface MovieRepository {

	public List<Movie> findAll();
	
	public Movie findOne(String id);
	
	public Movie create(Movie mov);
	
	public Movie update(Movie mov);
	
	public void delete(Movie mov);
}
