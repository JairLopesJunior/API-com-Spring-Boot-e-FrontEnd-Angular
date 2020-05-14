package com.oldgames.apioldgames.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_consoles")
public class Consoles {
	
	@Id
	@GeneratedValue(generator = "ConsolesSequence" ,strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ConsolesSequence", sequenceName = "ConsSeq", initialValue = 1, allocationSize = 1)
	private long id;
	
	@NotNull(message = "O modelo é obrigatório")
	private String modelo;
	
	@NotNull(message = "A marca é obrigatório")
	private String marca;
	
	@NotNull(message = "A informação do Produto é obrigatório")
	@Column(name = "infProduto")
	private String infProduto;
	
	@NotNull(message = "A quantidade é obrigatório")
	private int quantidade;
	
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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getInfProduto() {
		return infProduto;
	}

	public void setInfProduto(String infProduto) {
		this.infProduto = infProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
