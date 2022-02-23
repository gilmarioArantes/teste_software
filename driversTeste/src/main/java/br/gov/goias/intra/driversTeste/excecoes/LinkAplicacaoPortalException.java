package br.gov.goias.intra.driversTeste.excecoes;

import br.gov.goias.intra.driversTeste.util.Mensagem;

@SuppressWarnings("serial")
public class LinkAplicacaoPortalException extends Exception {

	public LinkAplicacaoPortalException(){
		super(Mensagem.LINK_APLICACAO_PORTAL);
	}
}
