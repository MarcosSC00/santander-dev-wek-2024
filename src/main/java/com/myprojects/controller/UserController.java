package com.myprojects.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myprojects.domain.models.User;
import com.myprojects.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") Long id) {
		User user = userService.findById(id);
		return ResponseEntity.ok(user);
	}

	@PostMapping
	public ResponseEntity<User> create(@RequestBody User userToCreate) {
		User userCreated = userService.create(userToCreate);

		// Retornando a localização (url) do user criado
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id})")
				.buildAndExpand(userCreated.getId()).toUri();

		return ResponseEntity.created(location).body(userCreated);
	}

}
