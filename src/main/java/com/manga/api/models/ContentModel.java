package com.manga.api.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "content")
@Getter
@Setter
public class ContentModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int contentIndex;

	@ManyToOne(optional = false)
	@JoinColumn(name = "chapter_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ChapterModel chapter;

	public ContentModel() {
	}

	public ContentModel(int contentIndex) {
		this.contentIndex = contentIndex;
	}


}
