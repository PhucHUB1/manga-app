package com.manga.api.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.manga.api.models.ChapterModel;
import com.manga.api.models.ComicModel;
import com.manga.api.repositories.IChapterRepository;
import com.manga.api.repositories.IComicRepository;
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
@RequestMapping("/api/chapters")
public class ChapterController {
	@Autowired
	private IChapterRepository chapterRepo;

	@Autowired
	private IComicRepository comicRepo;

	@GetMapping
	public ResponseEntity<List<ChapterModel>> getAll() {
		List<ChapterModel> chapters = new ArrayList<>();

		chapterRepo.findAll().forEach(chapters::add);

		if (chapters.isEmpty()) {
			return new ResponseEntity<List<ChapterModel>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<ChapterModel>>(chapters, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ChapterModel> getById(@PathVariable long id) {
		return chapterRepo.findById(id).map(chapter -> new ResponseEntity<ChapterModel>(chapter, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<ChapterModel>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("{comicId}")
	public ResponseEntity<ChapterModel> create(@RequestBody ChapterModel chapterModel, @PathVariable long comicId) {
		ComicModel comic = comicRepo.findById(comicId).orElseGet(() -> null);

		if (comic == null) {
			return new ResponseEntity<ChapterModel>(HttpStatus.BAD_REQUEST);
		}

		comic.setUpdatedTime(LocalDateTime.now());
		comicRepo.save(comic);
		
		ChapterModel newChapter = new ChapterModel(chapterModel.getName(), chapterModel.getChapterIndex());
		newChapter.setComic(comic);
		newChapter.setUpdatedTime(LocalDateTime.now());
		return new ResponseEntity<ChapterModel>(chapterRepo.save(newChapter), HttpStatus.OK);
	}

	@PostMapping("/list/{comicId}")
	public ResponseEntity<List<ChapterModel>> createList(@RequestBody List<ChapterModel> listChapter,
			@PathVariable long comicId) {
		List<ChapterModel> listResult = new ArrayList<>();
		ComicModel comic = comicRepo.findById(comicId).orElseGet(() -> null);

		if (comic == null) {
			return new ResponseEntity<List<ChapterModel>>(HttpStatus.BAD_REQUEST);
		}

		comic.setUpdatedTime(LocalDateTime.now());
		comicRepo.save(comic);
		
		listChapter.forEach(chapterModel -> {
			if (chapterModel.getId() == 0) {
				ChapterModel newChapter = new ChapterModel(chapterModel.getName(), chapterModel.getChapterIndex());
				newChapter.setComic(comic);
				newChapter.setUpdatedTime(LocalDateTime.now());
				listResult.add(chapterRepo.save(newChapter));
			} else {
				chapterModel.setComic(comic);
				chapterModel.setUpdatedTime(LocalDateTime.now());
				listResult.add(chapterRepo.save(chapterModel));
			}
		});

		listResult.sort(Comparator.comparing(ChapterModel::getId));
		return new ResponseEntity<List<ChapterModel>>(listResult, HttpStatus.OK);
	}

	@PutMapping("/{comicId}")
	public ResponseEntity<ChapterModel> update(@PathVariable long comicId, @RequestBody ChapterModel chapterModel) {
		return comicRepo.findById(comicId).map(comic -> {
			chapterModel.setComic(comic);
			chapterModel.setUpdatedTime(LocalDateTime.now());
			return new ResponseEntity<ChapterModel>(chapterRepo.save(chapterModel), HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<ChapterModel>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable long id) {
		chapterRepo.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
