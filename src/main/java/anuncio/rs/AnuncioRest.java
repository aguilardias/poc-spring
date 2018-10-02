package anuncio.rs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import anuncio.bc.AnuncioBC;
import anuncio.entity.Anuncio;

@RestController
@RequestMapping("anuncio")
public class AnuncioRest {

	@Autowired
	private AnuncioBC anuncioBC;

	@RequestMapping(method = RequestMethod.GET, value = "lista")
	public List<Anuncio> listarAnuncio() {
		return anuncioBC.listarAnuncio();
	}
}
