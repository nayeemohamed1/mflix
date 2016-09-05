package io.egen.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.entity.User;
import io.egen.movieflix.service.UserService;


//@Controller
@RequestMapping(path="Users")
//@ResponseBody

@RestController 	//@RestController combines @Controller and @ResponseBody
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findOne(@PathVariable("id") String UserId){//@PathVariable is used to pass the path value id to String UserId
		return userService.findOne(UserId);
	}
	
	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User create(@RequestBody User user){ //@RequestBody is used to transform the JSON RequestBody to Java object of type user and assigns the values to the variables in user
		return userService.create(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update(@PathVariable("id") String UserId, @RequestBody User user){
		return userService.update(UserId, user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="{id}")
	public void delete(@PathVariable("id") String UserId){
		userService.delete(UserId);
	}

}
