package com.manga.api.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import com.manga.api.enums.StatusType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "comic")
@Getter
@Setter
public class ComicModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	private String title;

	@Column(length = 65555)
	private String description;

	private long view;

	@Enumerated(EnumType.STRING)
	private StatusType status;

	private LocalDateTime updatedTime;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private UserModel user;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "author_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private AuthorModel author;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	@JoinTable(name = "comic_genre", joinColumns = @JoinColumn(name = "comic_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private Set<GenreModel> genres = new HashSet<>();

	@OneToMany(mappedBy = "comic", fetch = FetchType.EAGER)
	private Set<ChapterModel> chapters = new HashSet<>();
	
	@OneToMany(mappedBy = "comic")
	@Fetch(FetchMode.JOIN)
	@JsonIgnore
	private Set<ReviewModel> reviews;

	public ComicModel() {
	}

	public ComicModel(String title, String description, long view, StatusType status) {
		this.title = title;
		this.description = description;
		this.view = view;
		this.status = status;
		this.updatedTime = LocalDateTime.now();
	}

}
