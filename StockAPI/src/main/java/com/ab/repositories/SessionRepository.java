package com.ab.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ab.entities.Session;
import com.ab.entities.User;

@Repository
public interface SessionRepository extends JpaRepository<Session, String> {

	@Query("SELECT s FROM Session s WHERE s.sessionId=:sessionId")
	public Session getBySessionId(String sessionId);

	@Query("SELECT s.user FROM Session s WHERE s.sessionId=:sessionId")
	public Optional<User> getUserBySessionId(String sessionId);

}
