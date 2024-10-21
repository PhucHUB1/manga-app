package com.manga.api.models;

import java.time.LocalDateTime;
import com.manga.api.enums.ReviewType;
import com.manga.api.identity.ReviewIdentity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "review")
@Getter
@Setter
public class ReviewModel {
	@EmbeddedId
	private ReviewIdentity reviewId;
	
	@Enumerated(EnumType.STRING)
	private ReviewType type;
	
	@CreatedDate
	private LocalDateTime createdTime;
	
	@ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    UserModel user;
	
	@ManyToOne()
	@MapsId("comicId")
	@JoinColumn(name = "comic_id")
	ComicModel comic;

	public ReviewModel() {
	}
	public ReviewModel(UserModel user, ComicModel comic, ReviewType type) {
		super();
		this.user = user;
		this.comic = comic;
		this.type = type;
		this.reviewId = new ReviewIdentity(user.getId(), comic.getId());
		this.createdTime = LocalDateTime.now();
	}
}
