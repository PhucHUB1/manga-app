package com.manga.api.identity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewIdentity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "comic_id")
	private Long comicId;

	@Override
	public int hashCode() {
		return Objects.hash(userId, comicId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		ReviewIdentity indentity = (ReviewIdentity) obj;

		return userId.equals(indentity.userId) && comicId.equals(indentity.comicId);
	}
}
