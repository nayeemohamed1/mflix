package io.egen.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.entity.Movie;
import io.egen.movieflix.service.MovieService;

@RestController
@RequestMapping(path="movies")

public class MovieController {
	
	@Autowired
	MovieService movieService;

	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll(){
		return movieService.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findOne(@PathVariable("id") String movieId){
		return movieService.findOne(movieId);
	}
	
	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie mov){
		return movieService.create(mov);
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="{title}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("title") String title, @RequestBody Movie mov){
		return movieService.update(title, mov);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="{id}")
	public void delete(@PathVariable("id") String movieId){
		movieService.delete(movieId);
	}
	
}
