package br.gov.goias.intra.driversTeste.util;


import com.opera.core.systems.OperaProfile;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Logger;

public class InstanciaChromeDriver {


	public static WebDriver instanciaDriver(String browser) throws Exception{

      WebDriver driver = null;
      DesiredCapabilities dc;
      ChromeOptions options = new ChromeOptions();
      String urlSoDriver = LeitorPropriedades.getUrlSoDriver();
      String urlTeste = LeitorPropriedades.getUrlTeste();
      String argument = "--ignore-certificate-errors";

		try {

			switch (browser) {

				case "1":
					configuraPropriedadesChromeDriver(urlSoDriver);
					dc = DesiredCapabilities.chrome();
					options.addArguments(argument);
                    configuraProxy(urlTeste, dc);
					dc.setCapability(ChromeOptions.CAPABILITY,options);
					driver = new ChromeDriver(dc);
					break;

				case "2":
                    configuraPropriedadesChromeDriver(urlSoDriver);
                    dc = DesiredCapabilities.firefox();
                    options.addArguments(argument);
                    configuraProxy(urlTeste, dc);
                    dc.setCapability(ChromeOptions.CAPABILITY,options);
                    driver = new FirefoxDriver(dc);
                    break;

				case "3":
                    configuraPropriedadesIEDriver(urlSoDriver);
                    dc = DesiredCapabilities.internetExplorer();
                    options.addArguments(argument);
                    configuraProxy(urlTeste, dc);
                    dc.setCapability(ChromeOptions.CAPABILITY,options);
                    driver = new InternetExplorerDriver();
                    break;

				case "4":
					configuraPropriedadesOperaDriver(urlSoDriver);
					OperaProfile profile = new OperaProfile();  // fresh, random profile
					profile.preferences().set("User Prefs", "Ignore Unrequested Popups", false);
					DesiredCapabilities capabilities = DesiredCapabilities.opera();
					capabilities.setCapability("opera.profile", profile);
					driver = new OperaDriver();
					break;

			}

			if(driver == null){
				throw new NullPointerException(Mensagem.INSTANCIA_DRIVER);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	private static void configuraPropriedadesIEDriver(String urlSoDriver){
		System.setProperty("webdriver.ie.driver", urlSoDriver);
	}

	private static void configuraPropriedadesChromeDriver(String urlSoDriver){
		System.setProperty("webdriver.chrome.driver", urlSoDriver);
	}

	private static void configuraPropriedadesOperaDriver(String urlSoDriver){
		System.setProperty("webdriver.opera.driver", urlSoDriver);
	}

	private static void configuraPropriedadesHtmlUnitDriver(String urlSoDriver){
		System.setProperty("webdriver.HtmlUnit.driver", urlSoDriver);
	}

	private static void configuraProxy(String urlTeste, DesiredCapabilities dc){
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("proxy.goias.gov.br:2303");
        proxy.setNoProxy(urlTeste);
        dc.setCapability(CapabilityType.PROXY,proxy);
    }
}
