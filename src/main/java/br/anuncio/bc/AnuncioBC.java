package br.anuncio.bc;

import java.io.File;
import java.util.Arrays;
import java.util.Optional;

import org.demoiselle.signer.core.CertificateManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.anuncio.dao.AnuncioDAO;
import br.anuncio.entity.Anuncio;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AnuncioBC {

	@Autowired
	private AnuncioDAO anuncioDAO;
	
	


	public Iterable<Anuncio> listarAnuncio() {
		Iterable<Anuncio> lista = anuncioDAO.listarAnuncio();

		Arrays.asList("").forEach(a -> tratar(a));
		
		return lista;
	}

	private void tratar(String a) {
		// TODO Auto-generated method stub
	}

	public Optional<Anuncio> obterAnuncio(Long id) {
		return anuncioDAO.obterAnuncio(id);
	}

	public void alterarAnuncio(Anuncio anuncio) {
		log.info("alterarAnuncio.inicio");
		log.info("Anuncio recebido: " + anuncio);
		Optional<Anuncio> optional = anuncioDAO.obterAnuncio(anuncio.getId());
		if (optional.isPresent()) {
			Anuncio anuncioParaAlteracao = optional.get();
			log.info("Anuncio a ser alterado: " + anuncioParaAlteracao);
			anuncioParaAlteracao.setNome(anuncio.getNome());
			anuncioParaAlteracao.setQuantidade(anuncio.getQuantidade());
			anuncioParaAlteracao.setDataAnuncio(anuncio.getDataAnuncio());
			Anuncio anuncioAlterado = anuncioDAO.salvar(anuncioParaAlteracao);
			log.info("Anuncio alterado: " + anuncioAlterado);
		}
		log.info("alterarAnuncio.fim");
	}

	public void inserirAnuncio(Anuncio anuncio) {
		log.info("inserirAnuncio.inicio");
		log.info("Anuncio recebido: " + anuncio);
		Anuncio anuncioInserido = anuncioDAO.salvar(anuncio);
		log.info("Anuncio inserido: " + anuncioInserido);
		log.info("inserirAnuncio.fim");
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

		//		File certFile = new File("classpath:certificados/certificate.pem");
		File certFile = new File("/home/05032627909/Downloads/x509/server.crt");
		//		CertificateManager cm = new CertificateManager(certFile);
		CertificateManager 		cm = 		new 		CertificateManager 		("z0x9c8v736");

		//		try{
		//			KeyStoreLoader loader = KeyStoreLoaderFactory.factoryKeyStoreLoader();
		//			KeyStore keyStore = loader.getKeyStore();
		//			System.out.println(keyStore);
		//		}catch(DriverNotAvailableException e){
		//			logger.info("Drivers de certificados não foram encontrados: " + e.getMessage());
		//		}catch (InvalidPinException e){
		//			logger.severe("Senha do certificado nula ou inválida:" + e.getMessage());
		//		}catch(KeyStoreLoaderException e){
		//			logger.info("Não foi identificado um driver compatível com o hardware: " + e.getMessage());
		//		}catch(ProviderException e){
		//			logger.severe("Token removido:" + e.getMessage());
		//		}catch(Exception e){
		//			logger.severe(e.getMessage());
		//		}
	}

}
