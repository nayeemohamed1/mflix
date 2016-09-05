package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.entity.User;


@Repository
public class UserRespositoryImplementation implements UserRepository{
	
	@PersistenceContext //It will give the entity manager instance. If not available will create it using EntityManagerFactory.
	private EntityManager em;
	
	@Override
	public List<User> findAll() {
	TypedQuery<User> query=em.createNamedQuery("Employee.findAll",User.class);
	 return query.getResultList();
		
	}

	@Override
	public User findOne(String id) {
		return em.find(User.class,id);
	}

	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query=em.createNamedQuery("Employee.findByEmail",User.class);
		query.setParameter("pEmail", email);
		List<User> users=query.getResultList();
		if(users!=null && users.size()==1){
			return users.get(0);
		}
		
		return null;
	}
	
	
	
	@Override
	public User create(User user) {
		 em.persist(user);
		 return user;
	}

	@Override
	public User update(User user) {
		return em.merge(user);
	}

	@Override
	public void delete(User user) {
		em.remove(user);
		
	}



}
