/**
 * Classe definida para disparar mensagem de erro relativamente ao login do usuário no portal.
 * Data: 16/10/2015.
 * @author gilmar-fa
 * 
 */
package br.gov.goias.intra.driversTeste.excecoes;

public class LoginPortalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Construtor parametrizado
	 * @param message - mensagem disparada em caso de erro.
	 */
	public LoginPortalException(String message){
		super(message);
	}

}
