package br.anuncio.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.anuncio.entity.Anuncio;

public interface AnuncioRepository extends CrudRepository<Anuncio, Long> {

	List<Anuncio> findByNome(String nome);

}
