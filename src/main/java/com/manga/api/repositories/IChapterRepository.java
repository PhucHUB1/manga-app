package com.manga.api.repositories;

import com.manga.api.models.ChapterModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IChapterRepository extends JpaRepository<ChapterModel, Long>{
}
