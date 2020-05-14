package com.oldgames.apioldgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oldgames.apioldgames.models.Usuario;

//Extender a Classe JpaRepository que precisa passar 2 parametros <Entidade, E o tipo do ID>, Esta Classe possui varias metodos para realizar persistencia no Banco de Dados
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByEmail(String email);
	Usuario findById(long id);

}
