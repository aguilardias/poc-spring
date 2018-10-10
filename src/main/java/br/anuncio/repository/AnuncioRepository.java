package br.anuncio.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.anuncio.entity.Anuncio;

public interface AnuncioRepository extends PagingAndSortingRepository<Anuncio, Long> {

	Page<Anuncio> findByNome(String nome, Pageable pageable);

	// @Query("SELECT a FROM Anuncio a WHERE lower(a.nome) like lower(?1)")
	@Query("SELECT a FROM Anuncio a WHERE LOWER(a.nome) like LOWER(:nome)")
	Anuncio obterPorNome(String nome);
}
