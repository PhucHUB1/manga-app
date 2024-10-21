package com.manga.api.models;

import java.util.Set;

import com.manga.api.enums.RoleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	private String pass;
	
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	private boolean isDeleted;
	
	@OneToMany(mappedBy = "user")
	@Fetch(FetchMode.JOIN)
	@JsonIgnore
	private Set<ComicModel> comics;
	
	@OneToMany(mappedBy = "user")
	@Fetch(FetchMode.JOIN)
	@JsonIgnore
	private Set<ReviewModel> reviews;
	
	@OneToMany(mappedBy = "user")
	@Fetch(FetchMode.JOIN)
	@JsonIgnore
	private Set<CommentModel> comments;
	
	public UserModel() {
	}

	public UserModel(String name, String email, String pass, RoleType role) {
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.role = role;
		this.isDeleted = false;
	}
	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
