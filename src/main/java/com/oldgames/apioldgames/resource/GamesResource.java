package com.oldgames.apioldgames.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oldgames.apioldgames.models.Games;
import com.oldgames.apioldgames.models.Usuario;
import com.oldgames.apioldgames.repository.GamesRepository;
import com.oldgames.apioldgames.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/games")
public class GamesResource {

	@Autowired
	GamesRepository gamesRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
}
