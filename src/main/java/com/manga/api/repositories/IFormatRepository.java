package com.manga.api.repositories;

import com.manga.api.models.FormatModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFormatRepository extends JpaRepository<FormatModel, Long>{
	List<FormatModel> findFormatsByComicsId(long comicId);
	FormatModel findByNameIgnoreCase(String name);
}
