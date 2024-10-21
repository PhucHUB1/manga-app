package com.manga.api.models;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "comment")
@Getter
@Setter
public class CommentModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String comment;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private UserModel user;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "chapter_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ChapterModel chapter;
	
	@CreatedDate
	private LocalDateTime createdTime;

	public CommentModel() {
	}

	public CommentModel(String comment) {
		this.comment = comment;
		this.createdTime = LocalDateTime.now();
	}


}
