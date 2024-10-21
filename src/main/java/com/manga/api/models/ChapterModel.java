package com.manga.api.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "chapter")
@Getter
@Setter
public class ChapterModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private int chapterIndex;

	@CreatedDate
	private LocalDateTime updatedTime;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "comic_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ComicModel comic;

	@OneToMany(mappedBy = "chapter")
	@Fetch(FetchMode.JOIN)
	@JsonIgnore
	private Set<ContentModel> contents = new HashSet<>();
	
	@OneToMany(mappedBy = "chapter")
	@Fetch(FetchMode.JOIN)
	@JsonIgnore
	private Set<CommentModel> comments = new HashSet<>();

	public ChapterModel() {
	}

	public ChapterModel(String name, int chapterIndex) {
		this.name = name;
		this.chapterIndex = chapterIndex;
		this.updatedTime = LocalDateTime.now();
	}

}
