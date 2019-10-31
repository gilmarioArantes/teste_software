package br.gov.goias.intra.driversTeste.excecoes;

import br.gov.goias.intra.driversTeste.util.Mensagem;

public class NomeCampoLoginException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = -5593490227311223033L;

	public NomeCampoLoginException(){
		super(Mensagem.NOME_CAMPO_USUARIO);
	}
}
