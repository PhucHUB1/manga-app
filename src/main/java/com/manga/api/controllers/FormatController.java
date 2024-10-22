package com.manga.api.controllers;

import com.manga.api.models.ComicModel;
import com.manga.api.models.FormatModel;
import com.manga.api.repositories.IComicRepository;
import com.manga.api.repositories.IFormatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/formats")
public class FormatController {
	@Autowired
	private IFormatRepository formatRepo;
	
	@Autowired
	private IComicRepository comicRepo;
	
	@GetMapping
	public ResponseEntity<List<FormatModel>> getAll(){
		List<FormatModel> formats = new ArrayList<>();
		
		formatRepo.findAll().forEach(formats::add);
		if(formats.isEmpty())
		{
			return new ResponseEntity<List<FormatModel>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<FormatModel>>(formats, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FormatModel> getById(@PathVariable("id") long id){
		return formatRepo.findById(id).map(format -> new ResponseEntity<>(format, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/{id}/comics")
	public ResponseEntity<List<ComicModel>> getAllComicsByFormatId(@PathVariable("id") long id){
		if(!formatRepo.existsById(id))
		{
			return new ResponseEntity<List<ComicModel>>(HttpStatus.NOT_FOUND);
		}
		
		List<ComicModel> comics = comicRepo.findComicsByFormatsId(id);
		return new ResponseEntity<List<ComicModel>>(comics, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<FormatModel> create(@RequestBody FormatModel formatModel) {
		FormatModel newFormat = formatRepo.findByNameIgnoreCase(formatModel.getName());
		if (newFormat != null) {
			return new ResponseEntity<FormatModel>(HttpStatus.NOT_MODIFIED);
		}
		
		newFormat = new FormatModel(formatModel.getName());
		return new ResponseEntity<FormatModel>(formatRepo.save(newFormat), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<FormatModel> update(@PathVariable("id") long id, @RequestBody FormatModel formatModel) {
		return formatRepo.findById(id).map(format -> {
			formatModel.setId(format.getId());
			return new ResponseEntity<>(formatRepo.save(formatModel), HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
		formatRepo.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
