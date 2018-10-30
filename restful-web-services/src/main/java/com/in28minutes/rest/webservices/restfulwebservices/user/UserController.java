package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController()
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDaoService service;

	@GetMapping("/getusers")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping("/getusers/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user=service.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id-"+id);
		return user;
	}

	/*	This method will only return the created user with HTTP.status=200*/
	@PostMapping("/adduser")
	public User createUser(@RequestBody User user) {
		return service.save(user);	
	}
	
	/*	This method will only return the created user with HTTP.status=201*/
	@PostMapping("/adduser1")
	public ResponseEntity<Object> createUser1(@Valid @RequestBody User user) {
		User saveduser=service.save(user);
		URI location=ServletUriComponentsBuilder
					.fromCurrentRequest().path("/{id}")
					.buildAndExpand(saveduser.getId()).toUri();
		return 	ResponseEntity.created(location).build();
	}
	

	/*	This method will delete the user user denoted by the id
	 * if user is found => it will be deleted & the deleted user is sent in the response, else 
	 * will throw a UserNotFoundException which will be caught by the CustomizedException Handler,
	 * that in turn will return ExceptionResponse & status as per the conditions/mapping*/
	@DeleteMapping("/deleteUser/{id}")
	public User deleteUser(@PathVariable int id) {
		User user=service.deleteById(id);
		if(user==null)
			throw new UserNotFoundException("id-"+id);
		return user;
	}
	
	/*	This method will delete the user user denoted by the id
	 * if user is found => it will be deleted & the deleted user is sent in the response, else 
	 * will return HTTP.Status=204( No Content Found) */
	@DeleteMapping("/deleteUser1/{id}")
	public ResponseEntity<Object> deleteUser1(@PathVariable int id) {
		User user=service.deleteById(id);
		if(user==null)				
		return 	ResponseEntity.noContent().build();
		else
			return 	ResponseEntity.ok(user);	
	}
	
	// HATEOAS - > along with the requested user , it returns link to get all users
	@GetMapping("/getusers/{id}/hateoas")
	public Resource<User> retrieveOneUser(@PathVariable int id) {
		User user=service.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id- "+id);
		
		Resource<User> resource=new Resource<User>(user);
		ControllerLinkBuilder linkTo=linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}
}