package com.ab.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ab.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	
	@Query("SELECT u from User u WHERE u.email=:email")
	List<User> getAllByEmail(String email);

	@Query("SELECT u from User u WHERE u.email=:email")
	User getUserByEmail(String email);
	
	
	@Query("SELECT u from User u WHERE u.email=:email")
	Optional<User> getByEmail(String email);

 
	/**
//	REGISTER
	
	@Query(value="SELECT e from User e WHERE e.email LIKE %:eName%, e.passowrd LIKE %password%",nativeQuery=true)
	public List<User> findLoginDetails(@Param("eName")String name, @Param("password") String password);
**/
}
