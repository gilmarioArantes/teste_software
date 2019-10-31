/**
 * Classe definida para disparar mensagem de erro relativamente à seleção do browser utilizado pelo usuário
 * Data: 16/10/2015.
 * @author gilmar-fa
 *
 */
package br.gov.goias.intra.driversTeste.excecoes;

import br.gov.goias.intra.driversTeste.util.Mensagem;

public class BrowserException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Construtor parametrizado
	 *
	 */
	public BrowserException(){
		super(Mensagem.NAVEGADOR);
	}
}
