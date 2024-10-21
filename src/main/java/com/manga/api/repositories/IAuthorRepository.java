package com.manga.api.repositories;

import com.manga.api.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<AuthorModel, Long>{
	AuthorModel findByNameIgnoreCase(String name);
}
