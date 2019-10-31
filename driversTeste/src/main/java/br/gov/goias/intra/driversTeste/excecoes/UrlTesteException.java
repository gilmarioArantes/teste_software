/**
 * Classe definida para disparar mensagem de erro relativamente à obtenção da URL da aplicação em teste.
 * Data: 16/10/2015.
 * @author gilmar-fa.
 */
package br.gov.goias.intra.driversTeste.excecoes;

import br.gov.goias.intra.driversTeste.util.Mensagem;

public class UrlTesteException extends Exception{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Construtor parametrizado
	 */
	public UrlTesteException(){
		super(Mensagem.URL_APLICACAO);
	}

}
