package br.anuncio.dao;

import org.springframework.data.repository.CrudRepository;

import br.anuncio.entity.Anuncio;

public interface AnuncioRepository extends CrudRepository<Anuncio, Long> {

	// List<Anuncio> findByLastName(String lastName);

}
