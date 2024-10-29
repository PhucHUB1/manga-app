package com.manga.api.controllers;

import com.manga.api.repositories.*;
import com.manga.api.response.StatisticModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/statistic")
public class StatisticController {
	@Autowired
	IUserRepository userRepo;
	
	@Autowired
	IComicRepository comicRepo;
	
	@Autowired
	IGenreRepository genreRepo;
	
	@Autowired
	IAuthorRepository authorRepo;


	@GetMapping
	public ResponseEntity<StatisticModel> getReport(){
		StatisticModel statistic = new StatisticModel();
		statistic.setTotalUser(userRepo.count());
		statistic.setTotalComic(comicRepo.count());
		statistic.setTotalGenre(genreRepo.count());
		statistic.setTotalAuthor(authorRepo.count());

		return new ResponseEntity<StatisticModel>(statistic, HttpStatus.OK);
	}
}
