package com.manga.api.repositories;

import java.util.List;

import com.manga.api.identity.ReviewIdentity;
import com.manga.api.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IReviewRepository extends JpaRepository<ReviewModel, ReviewIdentity>{
	List<ReviewModel> findByReviewIdComicId(long id);
}
