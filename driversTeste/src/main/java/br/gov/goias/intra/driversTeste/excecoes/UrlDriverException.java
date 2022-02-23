package br.gov.goias.intra.driversTeste.excecoes;

import br.gov.goias.intra.driversTeste.util.Mensagem;

public class UrlDriverException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public UrlDriverException(){
		super(Mensagem.URL_DRIVER);
	}

}
