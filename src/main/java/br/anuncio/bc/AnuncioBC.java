package br.anuncio.bc;

import java.io.File;
import java.util.Optional;
import java.util.logging.Logger;

import org.demoiselle.signer.core.CertificateManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anuncio.dao.AnuncioDAO;
import br.anuncio.entity.Anuncio;

@Service
public class AnuncioBC {

	@Autowired
	private AnuncioDAO anuncioDAO;

	Logger logger = Logger.getLogger(AnuncioBC.class.getName());

	public Iterable<Anuncio> listarAnuncio() {
		return anuncioDAO.listarAnuncio();
	}

	public Optional<Anuncio> obterAnuncio(Long id) {
		return anuncioDAO.obterAnuncio(id);
	}

	public void alterarAnuncio(Anuncio anuncio) {
		logger.info("alterarAnuncio.inicio");
		logger.info("Anuncio recebido: " + anuncio);
		Optional<Anuncio> optional = anuncioDAO.obterAnuncio(anuncio.getId());
		if (optional.isPresent()) {
			Anuncio anuncioParaAlteracao = optional.get();
			logger.info("Anuncio a ser alterado: " + anuncioParaAlteracao);
			anuncioParaAlteracao.setNome(anuncio.getNome());
			anuncioParaAlteracao.setQuantidade(anuncio.getQuantidade());
			anuncioParaAlteracao.setDataAnuncio(anuncio.getDataAnuncio());
			Anuncio anuncioAlterado = anuncioDAO.salvar(anuncioParaAlteracao);
			logger.info("Anuncio alterado: " + anuncioAlterado);
		}
		logger.info("alterarAnuncio.fim");
	}

	public void inserirAnuncio(Anuncio anuncio) {
		logger.info("inserirAnuncio.inicio");
		logger.info("Anuncio recebido: " + anuncio);
		Anuncio anuncioInserido = anuncioDAO.salvar(anuncio);
		logger.info("Anuncio inserido: " + anuncioInserido);
		logger.info("inserirAnuncio.fim");
	}

	public void removerAnuncio(Long id) {
		anuncioDAO.removerPorId(id);
	}

	public Anuncio obterAnuncioPorNome(String nome) {
		return anuncioDAO.obterAnuncioPorNome(nome);
	}

	public void salvar(Anuncio anuncio) {
		anuncioDAO.salvar(anuncio);
	}
	
	public void analisarCertificado() {
//		CertificateManager cm = new CertificateManager(x509);
		
		//File certFile = new File("classpath:certificados/certificate.pem");
		File certFile = new File("/home/05032627909/git/poc-spring/src/main/resources/certificados/server.pem");
		CertificateManager cm = new CertificateManager(certFile);
	}

}
