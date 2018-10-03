package anuncio.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import anuncio.entity.Anuncio;

@Repository
public class AnuncioDAO {

	public List<Anuncio> listarAnuncio() {
		return Arrays.asList(new Anuncio(1L, "carro"), new Anuncio(2L, "bicicleta"));
	}

}
