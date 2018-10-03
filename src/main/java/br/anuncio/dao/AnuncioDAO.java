package br.anuncio.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.anuncio.entity.Anuncio;

@Repository
public class AnuncioDAO {

	@Autowired
	AnuncioRepository anuncioRepository;

	public Iterable<Anuncio> listarAnuncio() {
		return anuncioRepository.findAll();
	}

	public void salvar(Anuncio anuncio) {
		anuncioRepository.save(anuncio);
	}

	public Optional<Anuncio> obterAnuncio(Long id) {
		return anuncioRepository.findById(id);
	}

}
