package br.anuncio.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.anuncio.entity.Anuncio;
import br.anuncio.repository.AnuncioRepository;

@Repository
public class AnuncioDAO {

	@Autowired
	private AnuncioRepository anuncioRepository;

	@PersistenceContext
	private EntityManager em;

	public Iterable<Anuncio> listarAnuncio() {
		return anuncioRepository.findAll();
	}

	public Anuncio salvar(Anuncio anuncio) {
		return anuncioRepository.save(anuncio);
	}

	public Optional<Anuncio> obterAnuncio(Long id) {
		return anuncioRepository.findById(id);
	}

	public void removerPorId(Long id) {
		anuncioRepository.deleteById(id);
	}

	public Anuncio obterAnuncioPorNome(String nome) {
		String sql = "select a from Anuncio a where a.nome like '%" + nome + "%'";
		TypedQuery<Anuncio> query = em.createQuery(sql, Anuncio.class);

		query.setMaxResults(1);

		try {
			return query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
