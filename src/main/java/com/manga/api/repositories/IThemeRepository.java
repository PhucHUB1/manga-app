package com.manga.api.repositories;

import com.manga.api.models.ThemeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IThemeRepository extends JpaRepository<ThemeModel, Long> {
    List<ThemeModel> findThemesByComicsId(long comicId);
    ThemeModel findByNameIgnoreCase(String name);
}
