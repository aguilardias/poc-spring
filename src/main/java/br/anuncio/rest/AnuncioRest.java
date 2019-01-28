package br.anuncio.rest;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.anuncio.bc.AnuncioBC;
import br.anuncio.entity.Anuncio;
import br.anuncio.exception.NegocioException;
import br.util.ClasseBean;

@RestController
@RequestMapping("anuncio")
@CrossOrigin(origins = "*")
public class AnuncioRest {

	@Autowired
	private AnuncioBC anuncioBC;

	// @Autowired
	// TibjmsConnectionFactory tibjmsConnectionFactory;
	
	@Autowired
	private ClasseBean classeBean;
	
	@Bean
	public ClasseBean obterClasseBean() {
		ClasseBean classeBean = new ClasseBean();
		classeBean.nome = UUID.randomUUID().toString();
		return classeBean;
	}

	Logger logger = Logger.getLogger(AnuncioRest.class.getName());

	@GetMapping
	public Iterable<Anuncio> listarAnuncio() {
		System.out.println(classeBean.nome);
		return anuncioBC.listarAnuncio();
	}

	@GetMapping(value = "{id}")
	public Anuncio anuncio(@PathVariable("id") Long id) {
		return anuncioBC.obterAnuncio(id).orElseThrow(() -> new NegocioException("não existe"));
	}
	
	@GetMapping(value = "certificado")
	public String certificado() {
		anuncioBC.analisarCertificado();
		return null;
	}

	@GetMapping(value = "obter-por-nome")
	public Anuncio obterAnuncioPorNome(@RequestParam(value = "nome") String nome) {
		return anuncioBC.obterAnuncioPorNome(nome);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alterarAnuncio(@RequestBody Anuncio anuncio) {
		anuncioBC.alterarAnuncio(anuncio);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void inserirAnuncio(@RequestBody Anuncio anuncio) {
		anuncioBC.inserirAnuncio(anuncio);
	}

	@DeleteMapping(value = "{id}")
	public void removerAnuncio(@PathVariable("id") Long id) {
		anuncioBC.removerAnuncio(id);
	}
}
