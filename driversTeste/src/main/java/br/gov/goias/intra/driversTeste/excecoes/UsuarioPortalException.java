/**
 * Classe definida para disparar mensagem de erro relativamente à obtenção do usuário do portal.
 * Data: 16/10/2015.
 * @author gilmar-fa.
 */
package br.gov.goias.intra.driversTeste.excecoes;

import br.gov.goias.intra.driversTeste.util.Mensagem;

public class UsuarioPortalException extends Exception{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Construtor parametrizado
	 * */
	public UsuarioPortalException(){
		super(Mensagem.USUARIO_PORTAL);
	}
}