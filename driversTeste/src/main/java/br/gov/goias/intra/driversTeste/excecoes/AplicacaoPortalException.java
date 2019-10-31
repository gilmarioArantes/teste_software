package br.gov.goias.intra.driversTeste.excecoes;

import br.gov.goias.intra.driversTeste.util.Mensagem;

@SuppressWarnings("serial")
public class AplicacaoPortalException extends Exception {

	public AplicacaoPortalException(){
		super(Mensagem.APLICACAO_PORTAL);
	}
}
