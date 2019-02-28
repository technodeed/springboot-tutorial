package com.springboot.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.demo.bean.UserBean;
import com.springboot.demo.exception.UserNotFoundException;
import com.springboot.demo.service.UserDaoService;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserDaoService userDaoService;
	
	@Autowired
	private MessageSource messageResource;
	
	@GetMapping(path= "/hello-world")
	public String helloWorld() {
		System.out.println("In Usercontroller and helloworld***.");
		
		return "Hello SpringBoot!!!";
	}
	
	@GetMapping(path= "/hello-world-internationalize")
	public String helloWorldInternationalization(
			// We don't need above step if we use LocalContextLoader shown below
			//@RequestHeader(name="Accept-Language", required=false) Locale locale 
			) {
		System.out.println("In Usercontroller and helloWorldInternationalization*** ");
		
		//return messageResource.getMessage("good.morning.message", null, locale);
		return messageResource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
		
	}

	@GetMapping(path= "/all")
	public List<UserBean> retrieveAllUsers() {
		System.out.println("In Usercontroller and retrieveAllUsers****");
		
		return userDaoService.retrieveAllUsers();
	}
	
	@GetMapping(path= "/{userId}")
	public Resource<UserBean> userDetails(@PathVariable("userId") Integer userId) {
		System.out.println("In Usercontroller and userDetails*****");
		/*UserBean user = new UserBean(userId, 
									String.format("firstTest-%s", userId), 
									String.format("firstTest-%s", userId), 
									SbUtils.createDate(1988, 1, 1).getTime());*/
		
		UserBean userbean = userDaoService.retrieveUser(userId);
		
		if(userbean == null) {
			throw new UserNotFoundException("Selected User Not Found");
		}
		
		// hateoas concepts. Add link of all users EndPoint in this response.
		Resource<UserBean> resource = new Resource<UserBean>(userbean);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
	
	@PostMapping(path= "/add")
	public ResponseEntity<UserBean> saveUser(@Valid @RequestBody UserBean user) {
		System.out.println("In Usercontroller and saveUser****");
		
		UserBean userbean = userDaoService.saveUser(user);
		
		URI location = ServletUriComponentsBuilder
							.fromCurrentRequest()
							.path("/{id}")
							.buildAndExpand(userbean.getUserId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path= "/{userId}")
	public void deleteUser(@PathVariable("userId") Integer userId) {
		System.out.println("In Usercontroller and deleteUser*****");
		/*UserBean user = new UserBean(userId, 
									String.format("firstTest-%s", userId), 
									String.format("firstTest-%s", userId), 
									SbUtils.createDate(1988, 1, 1).getTime());*/
		
		UserBean userbean = userDaoService.deleteUserById(userId);
		
		if(userbean == null) {
			throw new UserNotFoundException("Selected User Not Found");
		}
	}

}
