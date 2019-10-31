package br.gov.goias.intra.driversTeste.util;


import br.gov.goias.intra.driversTeste.excecoes.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class LeitorPropriedades {

	/**
	 * Método para instanciar o arquivo de propriedades do projeto.
	 * @return Properties
	 * @throws IOException
	 */
	protected static Properties getProp() throws IOException
    {
		Properties props = new Properties();

        try {
			FileInputStream file = new FileInputStream("src/test/resources/teste.properties");
        	props.load(file);
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(Mensagem.ARQUIVO_NAO_ENCONTRADO);
		} catch (IOException e) {
			throw new IOException(Mensagem.CARGA_ARQUIVO_PROPRIEDADES);
		}

        return props;

    }

	/*
	 * Método para instanciar o arquivo de propriedades do driver do selenium.
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * descontinuado em 08/02/2017 - Foi decidido que cada projeto terá o driver na sua pasta /src/test/resources
	public static Properties getDriverProps() throws FileNotFoundException, IOException
    {
        props = new Properties();

        try {
        	file = new FileInputStream("src/test/resources/driver.properties");
        	props.load(file);
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(Mensagem.ARQUIVO_NAO_ENCONTRADO);
		} catch (IOException e) {
			throw new IOException(Mensagem.CARGA_ARQUIVO);
		}

        return props;

    }
	 */
	/**
	 * Método para obter a instância correta do driver, de acordo com o Sistema Operacional do usuário.
	 * @return String
	 * @throws UrlDriverException
	 */
	public static String getUrlSoDriver() throws UrlDriverException
	{
		final String OS = System.getProperty("os.name").toLowerCase();
		String navegador;
		String url = null;

		try {
			navegador = getNavegador();
			switch (navegador) {
			case "1":
				url = OS.contains("win") ? getProp().getProperty("driverWindowsChrome") : getProp().getProperty("driverLinuxChrome");
				break;
			case "2":
				url = OS.contains("win") ? getProp().getProperty("driverWindowsChrome") : getProp().getProperty("driverLinuxChrome");
				break;
			case "3"	:
				url = getProp().getProperty("driverWindowsIE");
				break;
			case "4":
				url = OS.contains("win") ? getProp().getProperty("driverWindowsOpera") :
				getProp().getProperty("driverLinuxOpera");
				break;
			case "5":
				url = OS.contains("win") ? getProp().getProperty("driverWindowsHtmlUnit") :
				getProp().getProperty("driverLinuxHtmlUnit");
				break;
			}
		} catch (Exception e) {
			throw new UrlDriverException();
		}

		return url;
	}

	/**
	 * Método para obter o nome do usuário que se logará no portal.
	 * @return
	 * @throws UsuarioPortalException
	 */
	public static String getUsuarioPortal() throws UsuarioPortalException {
		String usuarioPortal;
		try {
			usuarioPortal = getProp().getProperty("usuarioPortal");
		} catch (Exception e) {
			throw new UsuarioPortalException();
		}

		return usuarioPortal;
	}

	/**
	 * Método para obter a senha do usuário que irá logar no portal.
	 * @return
	 * @throws
	 */
	public static String getSenhaPortal() throws SenhaPortalException {
		String senhaPortal;
		try {
			senhaPortal = getProp().getProperty("senhaPortal");
		} catch (Exception e) {
			throw new SenhaPortalException();
		}

		return senhaPortal;
	}

	/**
	 * Método para obter a URL da aplicação que será testada, após o login no portal.
	 * @return
	 * @throws
	 */
	public static String getUrlTeste() throws UrlTesteException {
		String urlTeste;
		try {
			urlTeste = getProp().getProperty("urlBase");
		} catch (Exception e) {
			throw new UrlTesteException();
		}

		return urlTeste;
	}


	/**
	 * Método definido para se obter o navegador (browse), que se está utilizando para se efetuar os testes
	 */
	public static String getNavegador() throws BrowserException {
		String navegador;
		try {
			navegador = getProp().getProperty("navegador");
		} catch (Exception e) {
			throw new BrowserException();
		}

		return navegador;
	}

	/*
	 * Método definido para obter o nome do sistema que está sendo testado
	 * @return
	 * @throws SistemaException
	 * método comentado em 08/02/2017 por não estar mais sendo utilizado.
	public static String getNomeSistema() throws SistemaException{
		String nomeSistema = null;
		try {
			nomeSistema = getProp().getProperty("nomeSistema");
		} catch (Exception e) {
			throw new SistemaException(Mensagem.NOME_SISTEMA);
		}
		return nomeSistema;
	}
	 */


	/*
	 * Método definido para obter o arquivo de senhas gerado pela aplicação SAVV.
	 * @return
	 * @throws FileNotFoundException
	 * método comentado em 08/02/2017 por ser uma particularidade do sistema SIOFI - funcionalidade transferida para a classe LeitorPropriedadesSIOFI, do projeto de testes do SIOFI.
	public static String getArquivoSenha() throws FileNotFoundException{
		String nomeArquivo = null;
		try {
			nomeArquivo = getProp().getProperty("arquivoSenha");
		} catch (Exception e) {
			throw new FileNotFoundException(Mensagem.ARQUIVO_PDF_NAO_ENCONTRADO);
		}
		return nomeArquivo;
	}

	 */
	public static String getNomeCampoUsuario() throws NomeCampoLoginException{
		String nomeCampoUsuario;
		try {
			nomeCampoUsuario = getProp().getProperty("nomeCampoUsuario");
		} catch (Exception e) {
			throw new NomeCampoLoginException();
		}
		return nomeCampoUsuario;
	}

	public static String getNomeCampoSenha() throws NomeCampoSenhaException{
		String nomeCampoSenha;
		try {
			nomeCampoSenha = getProp().getProperty("nomeCampoSenha");
		} catch (Exception e) {
			throw new NomeCampoSenhaException();
		}
		return nomeCampoSenha;
	}

	public static String getCaminhoBotaoLogar() throws NomeCampoSenhaException{
		String caminhoBotaoLogar;
		try {
			caminhoBotaoLogar = getProp().getProperty("caminhoBotaoLogar");
		} catch (Exception e) {
			throw new NomeCampoSenhaException();
		}
		return caminhoBotaoLogar;
	}

	public static String getAplicacaoNoPortal() throws AplicacaoPortalException{
		String aplicacaoPortal;
		try {
			aplicacaoPortal = getProp().getProperty("aplicacaoPortal");
		} catch (Exception e) {
			throw new AplicacaoPortalException();
		}
		return aplicacaoPortal;
	}

	public static String getLinkAplicacaoNoPortal() throws LinkAplicacaoPortalException{
		String linkAplicacaoPortal;
		try {
			linkAplicacaoPortal = getProp().getProperty("linkAplicacaoPortal");
		} catch (Exception e) {
			throw new LinkAplicacaoPortalException();
		}
		return linkAplicacaoPortal;
	}



	/*
	 * os métodos que estão comentados, foram transferidos para a classe LeitorPropriedadesSiofi,
	 * pois são particulares a este sistema
	 *
	public static String getUsuarioPortalSIOFI() throws UsuarioPortalException{
		String usuarioPortal = null;
		try {
			usuarioPortal = getProp().getProperty("usuarioPortalSIOFI");
		} catch (Exception e) {
			throw new UsuarioPortalException(Mensagem.USUARIO_PORTAL);
		}

		return usuarioPortal;
	}

	public static String getSenhaPortalSIOFI() throws SenhaPortalException{
		String senhaPortal = null;
		try {
			senhaPortal = getProp().getProperty("senhaPortalSIOFI");
		} catch (Exception e) {
			throw new SenhaPortalException(Mensagem.SENHA_PORTAL);
		}

		return senhaPortal;
	}

	public static String getUrlTesteSIOFI() throws UrlTesteException{
		String urlTeste = null;
		try {
			urlTeste = getProp().getProperty("urlBaseSIOFI");
		} catch (Exception e) {
			throw new UrlTesteException(Mensagem.URL_APLICACAO);
		}

		return urlTeste;
	}

		public static String getArquivoPDFnormal() throws FileNotFoundException{
		String nomeArquivo = null;
		try {
			nomeArquivo = getProp().getProperty("arquivoPDFnormal");
		} catch (Exception e) {
			throw new FileNotFoundException(Mensagem.ARQUIVO_PDF_NAO_ENCONTRADO);
		}
		return nomeArquivo;
	}

	public static String getArquivoEmpenhoNormal() throws FileNotFoundException{
		String nomeArquivo = null;
		try {
			nomeArquivo = getProp().getProperty("arquivoEmpenhoNormal");
		} catch (Exception e) {
			throw new FileNotFoundException(Mensagem.ARQUIVO_PDF_NAO_ENCONTRADO);
		}
		return nomeArquivo;
	}

	public static String getArquivoSolicitacaoPPT() throws FileNotFoundException{
		String nomeArquivo = null;
		try {
			nomeArquivo = getProp().getProperty("arquivoSolicitacaoPPT");
		} catch (Exception e) {
			throw new FileNotFoundException(Mensagem.ARQUIVO_PDF_NAO_ENCONTRADO);
		}
		return nomeArquivo;
	}

	public static String getArquivoInclusaoPDF() throws FileNotFoundException{
		String nomeArquivo = null;
		try {
			nomeArquivo = getProp().getProperty("arquivoInclusaoPDF");
		} catch (Exception e) {
			throw new FileNotFoundException(Mensagem.ARQUIVO_PDF_NAO_ENCONTRADO);
		}
		return nomeArquivo;
	}

	public static String getArquivoOPF() throws FileNotFoundException{
		String nomeArquivo = null;
		try {
			nomeArquivo = getProp().getProperty("arquivoOPF");
		} catch (Exception e) {
			throw new FileNotFoundException(Mensagem.ARQUIVO_PDF_NAO_ENCONTRADO);
		}
		return nomeArquivo;
	}
	*/
}
