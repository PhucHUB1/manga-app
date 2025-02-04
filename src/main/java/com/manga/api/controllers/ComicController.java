package com.manga.api.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.manga.api.enums.StatusType;
import com.manga.api.models.ComicModel;
import com.manga.api.models.GenreModel;
import com.manga.api.models.UserModel;
import com.manga.api.repositories.IComicRepository;
import com.manga.api.repositories.IUserRepository;
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
@RequestMapping("/api/comics")
public class ComicController {
	@Autowired
	private IComicRepository comicRepo;

	@Autowired
	private IUserRepository userRepo;

	@GetMapping
	public ResponseEntity<List<ComicModel>> getAll() {
		return new ResponseEntity<List<ComicModel>>(comicRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ComicModel> getById(@PathVariable("id") long id) {
		return comicRepo.findById(id).map(comic -> new ResponseEntity<>(comic, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/new")
	public ResponseEntity<List<ComicModel>> getAllOrderByTime() {
		return new ResponseEntity<List<ComicModel>>(comicRepo.findByOrderByUpdatedTimeDesc(), HttpStatus.OK);
	}

	@GetMapping("/published")
	public ResponseEntity<List<ComicModel>> getAllPublishedOrderByTime() {
		List<ComicModel> listComic = comicRepo.findByOrderByUpdatedTimeDesc();
		listComic.removeIf(comic -> comic.getStatus() != StatusType.PUBLISH);

		return new ResponseEntity<List<ComicModel>>(listComic, HttpStatus.OK);
	}

	@GetMapping("/published/{keyword}")
	public ResponseEntity<List<ComicModel>> getByTitleContainingOrderByTime(@PathVariable String keyword) {
		List<ComicModel> listComic = comicRepo.findByTitleContainingOrderByUpdatedTimeDesc(keyword);
		listComic.removeIf(comic -> comic.getStatus() != StatusType.PUBLISH);

		return new ResponseEntity<List<ComicModel>>(listComic, HttpStatus.OK);
	}

	@GetMapping("/genre/{genreId}")
	public ResponseEntity<List<ComicModel>> getByGenreIdOrderByTime(@PathVariable long genreId) {
		List<ComicModel> listComics = comicRepo.findByOrderByUpdatedTimeDesc();
		List<ComicModel> listResult = new ArrayList<>();

		listComics.forEach(comic -> {
			List<Long> genreIds = comic.getGenres().stream().map(GenreModel::getId).collect(Collectors.toList());

			if (genreIds.contains(genreId) && comic.getStatus() == StatusType.PUBLISH) {
				listResult.add(comic);
			}
		});

		return new ResponseEntity<List<ComicModel>>(listResult, HttpStatus.OK);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<ComicModel>> getByUserIdOrderByTime(@PathVariable long userId) {
		UserModel user = userRepo.findById(userId).orElseGet(null);

		if (user == null) {
			return new ResponseEntity<List<ComicModel>>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<List<ComicModel>>(comicRepo.findByUserOrderByUpdatedTimeDesc(user), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ComicModel> create(@RequestBody ComicModel comicModel) {
		ComicModel newComic = new ComicModel(comicModel.getTitle(), comicModel.getDescription(), 0,
				comicModel.getStatus());
		newComic.setAuthor(comicModel.getAuthor());
		newComic.setUser(comicModel.getUser());
		newComic.setGenres(comicModel.getGenres());

		return new ResponseEntity<ComicModel>(comicRepo.save(newComic), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ComicModel> update(@PathVariable("id") long id, @RequestBody ComicModel comicModel) {
		return comicRepo.findById(id).map(comic -> {
			comicModel.setId(comic.getId());
			comicModel.setUpdatedTime(LocalDateTime.now());
			return new ResponseEntity<>(comicRepo.save(comicModel), HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
		comicRepo.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
