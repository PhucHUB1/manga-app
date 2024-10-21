package com.manga.api.repositories;

import java.util.List;

import com.manga.api.models.ChapterModel;
import com.manga.api.models.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICommentRepository extends JpaRepository<CommentModel, Long>{
	List<CommentModel> findByChapterOrderByCreatedTimeDesc(ChapterModel chapterModel);
}
