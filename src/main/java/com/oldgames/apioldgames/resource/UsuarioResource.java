package com.oldgames.apioldgames.resource;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.oldgames.apioldgames.models.Consoles;
import com.oldgames.apioldgames.models.Games;
import com.oldgames.apioldgames.models.Usuario;
import com.oldgames.apioldgames.repository.ConsolesRepository;
import com.oldgames.apioldgames.repository.GamesRepository;
import com.oldgames.apioldgames.repository.UsuarioRepository;

import sun.util.calendar.LocalGregorianCalendar.Date;


@RestController
@RequestMapping(value = "/api")
public class UsuarioResource {
	
	//Importar UsuarioRepository para utilizar os metodos para conectar com o Banco de Dados
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	GamesRepository gamesRepository;
	
	@Autowired
	ConsolesRepository consolesRepository;
	
	@GetMapping("/usuarios")
	public List<Usuario> listaUsuarios(){
		return usuarioRepository.findAll();
	}
	
	//A anotação @RequestBody significa que o produto vai vim no corpo da requisição
	@PostMapping("/usuarios/{email}")
	public ResponseEntity<Usuario> salvarUsuario(@Valid @RequestBody Usuario usuario) {
		String email = usuario.getEmail();
		Usuario e = usuarioRepository.findByEmail(email);
		if(e != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}else {
			usuarioRepository.save(usuario);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@GetMapping("/hello")
	ResponseEntity<Usuario> hello(@Valid @RequestBody Usuario usuario) {
	    return new ResponseEntity<>(usuario, HttpStatus.CONFLICT);
	}
	
	@PostMapping("/usuarios/{id}/games")
	public ResponseEntity<Games> cadastrarGames(@Valid @RequestBody Games games, @PathVariable("id") long id){
		Usuario usuario = usuarioRepository.findById(id);
		games.setUsuario(usuario);
		String nome = games.getNome();
		String prod = games.getProdutora();
		
		if(nome.equals("") || prod.equals("")) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			gamesRepository.save(games);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@GetMapping("/usuarios/{id}/games")
	public List<Games> listarGames(@PathVariable("id") long id){
		return gamesRepository.findAllById(id);
	}
	
	@PostMapping("/usuarios/{id}/consoles")
	public ResponseEntity<Consoles> cadastrarConsoles(@Valid @RequestBody Consoles consoles, @PathVariable("id") long id){
		Usuario usuario = usuarioRepository.findById(id);
		consoles.setUsuario(usuario);
		String produto = consoles.getInfProduto();
		String marca = consoles.getMarca();
		String modelo = consoles.getModelo();
		
		if(produto.equals("") || marca.equals("") || modelo.equals("")) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			consolesRepository.save(consoles);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@GetMapping("/usuarios/{id}/consoles")
	public List<Consoles> listarConsoles(@PathVariable("id") long id){
		return consolesRepository.findAllById(id);
	}

}
