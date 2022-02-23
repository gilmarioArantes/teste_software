package br.gov.goias.intra.driversTeste.util;


import br.gov.goias.intra.driversTeste.excecoes.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class PropertiesReader {

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


	/**
	 * Método definido para se obter o navegador (browse), que se está utilizando para se efetuar os testes
	 */
	public static String getBrowser() throws BrowserException {
		String browser;
		try {
			browser = getProp().getProperty("browser");
		} catch (Exception e) {
			throw new BrowserException();
		}

		return browser;
	}


}
