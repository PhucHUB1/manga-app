package com.manga.api.repositories;

import com.manga.api.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {
	UserModel findByEmailAndPass(String email, String pass);
	UserModel findByEmailIgnoreCase(String email);
}
