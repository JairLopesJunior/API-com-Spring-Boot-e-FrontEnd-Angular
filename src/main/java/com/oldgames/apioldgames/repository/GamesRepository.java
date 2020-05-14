package com.oldgames.apioldgames.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.oldgames.apioldgames.models.Games;

@Repository
public interface GamesRepository extends JpaRepository<Games, Long> {

	@Query(value = "select * from tb_games c where usuario_id = ?1", nativeQuery = true)
	List<Games> findAllById(long id);
}
