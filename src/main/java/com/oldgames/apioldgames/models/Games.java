package com.oldgames.apioldgames.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tb_games")
public class Games implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator ="GamesSequence" ,strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "GamesSequence", sequenceName = "GamesSeq", initialValue = 1, allocationSize = 1)
	private long id;
	
	@NotNull(message = "A produtora é obrigatório")
	private String produtora;
	
	@NotNull(message = "A data é obrigatório")
	@Column(name = "anoDeLancamento")
	private Date anoDeLancamento;
	
	@NotNull(message = "O nome é obrigatório")
	private String nome;
	
	@NotNull(message = "A imagem é obrigatório")
	private String imagem;
	
	@NotNull(message = "O preço é obrigatório")
	private double preco;
	
	@ManyToOne
	private Usuario usuario;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProdutora() {
		return produtora;
	}
	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}
	public Date getAnoDeLancamento() {
		return anoDeLancamento;
	}
	public void setAnoDeLancamento(Date anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
