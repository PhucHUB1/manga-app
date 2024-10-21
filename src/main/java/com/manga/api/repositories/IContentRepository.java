package com.manga.api.repositories;

import java.util.List;

import com.manga.api.models.ChapterModel;
import com.manga.api.models.ContentModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IContentRepository extends JpaRepository<ContentModel, Long>{
	List<ContentModel> findByChapter(ChapterModel chapterModel);
}
