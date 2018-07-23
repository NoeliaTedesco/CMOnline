package ar.com.osde.cmonline.selenium;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base_Test {

	protected WebDriver driver;
	private String paginaInicial = "https://tconsultamedica.osde.com.ar";

	public WebDriver getDriver() {
		return driver;
	}

	public Base_Test(String rol, String ipNodo) {

		switch (rol) {

		case "Prestador":
			paginaInicial = paginaInicial + "/prestadores";
			break;

		case "Medico":
			paginaInicial = paginaInicial + "/medico";
			break;

		case "Administrador":
			paginaInicial = paginaInicial + "/admin";
			break;

		}

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		try {
			driver = new RemoteWebDriver(new URL(ipNodo), capabilities);
		} catch (MalformedURLException e) {
			System.out.println("Ocurrio un error al inicializar driver en nodo - " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}
	
	public void ingresarPagina() {
		driver.get(paginaInicial);
	}

	public void refrescarPagina() {
		this.driver.navigate().refresh();
	}

	public void closeDriver() {
		driver.close();
		driver.quit();
		finalizarProcesoDriver();
	}
	
	private void finalizarProcesoDriver() {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		} catch (IOException e) {
			System.out.println("Ocurrio un error al matar el proceso -" + e);
			e.printStackTrace();
		}
	}

}
