package com.ab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ab.entities.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, String> {

	@Query("SELECT s FROM Session s WHERE s.sessionId=:sessionId")
	public Session getBySessionId(String sessionId);

}
