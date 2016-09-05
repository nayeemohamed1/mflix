package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.entity.Movie;

@Repository
public class MovieRepositoryImplementation implements MovieRepository{
	
	@PersistenceContext
	EntityManager em1;

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query=em1.createNamedQuery("Movie.findAll",Movie.class);
		return query.getResultList();
	}

		
	@Override
	public Movie findOne(String id) {
		return em1.find(Movie.class, id);
	}
	
	@Override
	public Movie findByTitle(String title) {
		TypedQuery<Movie> query=em1.createNamedQuery("Movie.findByTitle",Movie.class);
		query.setParameter("pTitle", title);
		List<Movie> movies=query.getResultList();
		if(movies!=null && movies.size()==1)
		{
			return movies.get(0);
		}
		
		return null;
	}

	@Override
	public Movie create(Movie mov) {
		em1.persist(mov);
		return mov;
	}

	@Override
	public Movie update(Movie mov) {
		return em1.merge(mov);
	}

	@Override
	public void delete(Movie mov) {
		em1.remove(mov);
		
	}

	
	
	

}
