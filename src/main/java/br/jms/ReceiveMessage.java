package br.jms;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveMessage {

	@JmsListener(destination = "${app.jms.fila.envio}")
	public void receberMensagem(TextMessage mensagem) {
		System.out.println(mensagem);

		logarNumeroTentativa(mensagem);

		String textoMensagem = obterTextoMensagem(mensagem);
		System.out.println("mensagem recebida: " + textoMensagem);

		// lancarExcecaoMensagem1(textoMensagem);
	}

	private void logarNumeroTentativa(TextMessage mensagem) {
		try {
			System.out.println("JMSXDeliveryCount: " + mensagem.getIntProperty("JMSXDeliveryCount"));
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	private String obterTextoMensagem(TextMessage mensagem) {
		try {
			return mensagem.getText();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("não foi possível obter mensagem");
	}

	private void lancarExcecaoMensagem1(String mensagem) {
		if (mensagem.equals("mensagem1")) {
			throw new RuntimeException("erro ao processar mensagem1");
		}
	}

	private void tratarExcecaoMensagem1(String mensagem) {
		try {
			if (mensagem.equals("mensagem1")) {
				throw new RuntimeException("erro ao processar mensagem1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
