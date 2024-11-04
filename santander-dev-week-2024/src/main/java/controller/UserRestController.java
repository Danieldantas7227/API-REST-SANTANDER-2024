package controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import model.User;
import service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
	
	User user = userService.findById(id);	
	return ResponseEntity.ok(user);
    }
	
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		
	User responseUser = userService.create(user);	
	
	URI location = ServletUriComponentsBuilder.fromCurrentRequest()//Para retornar a localização do Novo usuário criado!!! 
			.path("/{id}")
			.buildAndExpand(responseUser.getId())
			.toUri();
	
	return ResponseEntity.created(location).body(responseUser);
	}
}
