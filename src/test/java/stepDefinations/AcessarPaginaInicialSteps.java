package stepDefinations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class AcessarPaginaInicialSteps {
	
	private WebDriver driver;
	
	@Dado("que acesso a pagina inicial do sistema")
	public void queAcessoAUrlDoSistema() {
		// Acessa a url do sistema
		driver = new ChromeDriver();
		driver.get("https://buger-eats.vercel.app/");
	}

	@Então("o sistema exibe a pagina inicial")
	public void oSistemaExibeATelaInicialDoSistema() {
		// Valida que estou na pagina inicial
		String texto = driver.findElement(By.cssSelector("h1")).getText();
		assertEquals("Seja um parceiro entregador pela Buger Eats",texto);

	}
	
}
