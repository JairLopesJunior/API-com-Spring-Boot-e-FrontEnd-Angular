package com.oldgames.apioldgames.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_usuarios") //O @Table serve para definir o nome da tabela no BD, caso não informado ele cria com o nome da Classe
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull(message = "O nome é obrigatório")
	private String nome;

	@NotNull(message = "O e-mail é obrigatório")
	private String email;

	@NotNull(message = "O telefone é obrigatório")
	private int telefone;

	@NotNull(message = "A senha é obrigatória")
	private String senha;
	
	@OneToMany
	private List<Games> games;
	
	@OneToMany
	private List<Consoles> consoles;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
