package br.gov.goias.intra.driversTeste.excecoes;

import br.gov.goias.intra.driversTeste.util.Mensagem;

@SuppressWarnings("serial")
public class NomeCampoSenhaException extends Exception {

	public NomeCampoSenhaException(){
		super(Mensagem.NOME_CAMPO_SENHA);
	}
}
