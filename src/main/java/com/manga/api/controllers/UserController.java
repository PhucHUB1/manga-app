package com.manga.api.controllers;

import java.util.ArrayList;
import java.util.List;

import com.manga.api.models.UserModel;
import com.manga.api.repositories.IUserRepository;
import com.manga.api.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private IUserRepository userRepo;

	@Autowired
	StorageService storageService;
	
	@GetMapping
	public ResponseEntity<List<UserModel>> getAll() {
		List<UserModel> users = new ArrayList<>();

		userRepo.findAll().forEach(users::add);

		if (users.isEmpty()) {
			return new ResponseEntity<List<UserModel>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<UserModel>>(users, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserModel> getById(@PathVariable long id) {
		return userRepo.findById(id).map(user -> new ResponseEntity<UserModel>(user, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<UserModel> create(@RequestBody UserModel userModel) {
		UserModel newUser = userRepo.findByEmailIgnoreCase(userModel.getEmail());
		if (newUser != null) {
			return new ResponseEntity<UserModel>(HttpStatus.NOT_MODIFIED);
		}
		
		newUser = new UserModel(userModel.getName(), userModel.getEmail(), userModel.getPass(),
				userModel.getRole());
		newUser = userRepo.save(newUser);
		
		storageService.copyDefaultAvatar(newUser.getId()+".jpg");
		return new ResponseEntity<UserModel>(newUser, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserModel> update(@PathVariable long id, @RequestBody UserModel userModel) {
		return userRepo.findById(id).map(user -> {
			userModel.setId(user.getId());
			return new ResponseEntity<UserModel>(userRepo.save(userModel), HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable long id) {
		userRepo.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<UserModel> login(@RequestBody UserModel userModel) {
		UserModel auditUser = userRepo.findByEmailAndPass(userModel.getEmail(), userModel.getPass());
		if (auditUser == null) {
			return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
		}

		if(auditUser.getIsDeleted()) {
			return new ResponseEntity<UserModel>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		return new ResponseEntity<UserModel>(auditUser, HttpStatus.OK);
	}
}
