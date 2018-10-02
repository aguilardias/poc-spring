package br.spring1.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.spring1.entity.Anuncio;

@Repository
public class AnuncioDAO {

	public List<Anuncio> listarAnuncio() {
		return Arrays.asList(new Anuncio(1L, "carro2"), new Anuncio(2L, "bicicleta"));
	}

}
