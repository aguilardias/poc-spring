package br.anuncio.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.anuncio.entity.Anuncio;

@Repository
public class AnuncioDAO {

	@Autowired
	AnuncioRepository anuncioRepository;

	public List<Anuncio> listarAnuncio() {
		return Arrays.asList(new Anuncio(1L, "carro"), new Anuncio(2L, "bicicleta"));
	}

	public Iterable<Anuncio> listarAnuncioBanco() {
		return anuncioRepository.findAll();
	}

	public void inserir(Anuncio anuncio) {
		anuncioRepository.save(anuncio);
	}

}
