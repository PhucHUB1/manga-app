package com.manga.api.models;

import java.util.Set;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "author")
@Getter
@Setter
public class AuthorModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@OneToMany(mappedBy = "author")
	@Fetch(FetchMode.JOIN)
	@JsonIgnore
	private Set<ComicModel> comics;
	
	public AuthorModel() {
	}

	public AuthorModel(String name) {
		this.name = name;
	}



}
