package com.manga.api.repositories;

import java.util.List;

import com.manga.api.models.ComicModel;
import com.manga.api.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IComicRepository extends JpaRepository<ComicModel, Long> {
	List<ComicModel> findByOrderByUpdatedTimeDesc();
	List<ComicModel> findByTitleContainingOrderByUpdatedTimeDesc(String title);
	List<ComicModel> findComicsByGenresId(long genreId);
	List<ComicModel> findComicsByAuthorId(long authorId);
	List<ComicModel> findComicsByThemesId(long themesId);
	List<ComicModel> findComicsByFormatsId(long formatsId);

	List<ComicModel> findByUserOrderByUpdatedTimeDesc(UserModel user);
}
