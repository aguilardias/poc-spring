package anuncio.bc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anuncio.dao.AnuncioDAO;
import anuncio.entity.Anuncio;

@Service
public class AnuncioBC {

	@Autowired
	private AnuncioDAO anuncioDAO;

	public List<Anuncio> listarAnuncio() {
		return anuncioDAO.listarAnuncio();
	}

}
