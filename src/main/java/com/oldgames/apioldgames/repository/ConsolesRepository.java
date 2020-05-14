package com.oldgames.apioldgames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oldgames.apioldgames.models.Consoles;

@Repository
public interface ConsolesRepository extends JpaRepository<Consoles, Long> {

	@Query(value = "select * from tb_consoles c where usuario_id = ?1", nativeQuery = true)
	List<Consoles> findAllById(long id);
}
