package br.anuncio.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Anuncio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "quantidade")
	private Long quantidade;

	@Column(name = "data_anuncio")
	private Date dataAnuncio;

	public Anuncio(String nome) {
		super();
		this.nome = nome;
	}


}
