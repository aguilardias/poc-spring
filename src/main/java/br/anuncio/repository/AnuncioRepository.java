package br.anuncio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.anuncio.entity.Anuncio;

public interface AnuncioRepository extends CrudRepository<Anuncio, Long> {

	List<Anuncio> findByNome(String nome);

	// @Query("SELECT a FROM Anuncio a WHERE lower(a.nome) like lower(?1)")
	@Query("SELECT a FROM Anuncio a WHERE LOWER(a.nome) like LOWER(:nome)")
	Anuncio obterPorNome(String nome);
}
