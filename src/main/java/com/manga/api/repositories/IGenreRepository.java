package com.manga.api.repositories;

import java.util.List;

import com.manga.api.models.GenreModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenreRepository extends JpaRepository<GenreModel, Long>{
	List<GenreModel> findGenresByComicsId(long comicId);
	GenreModel findByNameIgnoreCase(String name);
}
