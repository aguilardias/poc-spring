package br.spring1.bc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.spring1.dao.AnuncioDAO;
import br.spring1.entity.Anuncio;

@Service
public class AnuncioBC {

	@Autowired
	private AnuncioDAO anuncioDAO;

	public List<Anuncio> listarAnuncio() {
		return anuncioDAO.listarAnuncio();
	}

}
