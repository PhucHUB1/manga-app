package com.manga.api.controllers;

import com.manga.api.models.ComicModel;
import com.manga.api.models.ThemeModel;
import com.manga.api.repositories.IComicRepository;
import com.manga.api.repositories.IThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/themes")
public class ThemeController {
	@Autowired
	private IThemeRepository themeRepo;
	
	@Autowired
	private IComicRepository comicRepo;
	
	@GetMapping
	public ResponseEntity<List<ThemeModel>> getAll(){
		List<ThemeModel> themes = new ArrayList<>();

		themeRepo.findAll().forEach(themes::add);
		
		if(themes.isEmpty())
		{
			return new ResponseEntity<List<ThemeModel>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<ThemeModel>>(themes, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ThemeModel> getById(@PathVariable("id") long id){
		return themeRepo.findById(id).map(theme -> new ResponseEntity<>(theme, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/{id}/comics")
	public ResponseEntity<List<ComicModel>> getAllComicsByThemeId(@PathVariable("id") long id){
		if(!themeRepo.existsById(id))
		{
			return new ResponseEntity<List<ComicModel>>(HttpStatus.NOT_FOUND);
		}
		
		List<ComicModel> comics = comicRepo.findComicsByThemesId(id);
		return new ResponseEntity<List<ComicModel>>(comics, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ThemeModel> create(@RequestBody ThemeModel themeModel) {
		ThemeModel newTheme = themeRepo.findByNameIgnoreCase(themeModel.getName());
		if (newTheme != null) {
			return new ResponseEntity<ThemeModel>(HttpStatus.NOT_MODIFIED);
		}
		
		newTheme = new ThemeModel(themeModel.getName());
		return new ResponseEntity<ThemeModel>(themeRepo.save(newTheme), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ThemeModel> update(@PathVariable("id") long id, @RequestBody ThemeModel themeModel) {
		return themeRepo.findById(id).map(theme -> {
			themeModel.setId(theme.getId());
			return new ResponseEntity<>(themeRepo.save(themeModel), HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
		themeRepo.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
