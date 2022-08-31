package pages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.File;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.FormUtils;

public class CadastrarEntregadorPage {
	private WebDriver driver;
	private FormUtils formUtils;

	File imagem = new File("src/test/resources/imagens/novo-modelo-cnh.jpg");

	public CadastrarEntregadorPage(WebDriver driver) {
		this.driver = driver;
		formUtils = new FormUtils(driver);
	}

	public CadastrarEntregadorPage preencheNome(String valor) {
		driver.findElement(By.name("name")).clear();
		limparEEnviarDados(By.name("name"), valor);
		return this;
	}

	public CadastrarEntregadorPage preencheEmail(String valor) {
		driver.findElement(By.name("email")).clear();
		limparEEnviarDados(By.name("email"), valor);
		return this;
	}

	public CadastrarEntregadorPage preencheCpf(String valor) {
		driver.findElement(By.name("cpf")).clear();
		limparEEnviarDados(By.name("cpf"), valor);
		return this;
	}

	public CadastrarEntregadorPage preencheCep(String valor) {
		driver.findElement(By.name("postalcode")).clear();
		limparEEnviarDados(By.name("postalcode"), valor);
		return this;
	}

	public CadastrarEntregadorPage clicaBuscarCep() {
		driver.findElement(
				By.cssSelector("fieldset:nth-child(3) > .field-group:nth-child(2) > .field:nth-child(2) > input"))
				.click();
		return this;
	}

	public CadastrarEntregadorPage preencheNumero(String valor) {
		driver.findElement(By.name("address-number")).clear();
		limparEEnviarDados(By.name("address-number"), valor);
		return this;
	}

	public CadastrarEntregadorPage preencheComplemento(String valor) {
		driver.findElement(By.name("address-details")).clear();
		limparEEnviarDados(By.name("address-details"), valor);
		return this;
	}

	public CadastrarEntregadorPage clicaMetodoEntrega(String metodoEntrega) {
		if (metodoEntrega.equals("moto"))
			formUtils.selecionarMetodoEntrega("1");
		if (metodoEntrega.equals("bicicleta"))
			formUtils.selecionarMetodoEntrega("2");
		if (metodoEntrega.equals("van/carro"))
			formUtils.selecionarMetodoEntrega("3");
		return this;
	}

	public CadastrarEntregadorPage inserirFotoCnh() throws URISyntaxException, InterruptedException {

		WebElement uploadFile = driver.findElement(By.xpath("//input[@type=\'file\']"));
		uploadFile.sendKeys(imagem.getAbsolutePath());

		Thread.sleep(2000);

		if (driver.findElement(By.xpath("//input[@type=\'file\']")).isDisplayed()) {
			assertFalse(true, "A foto não foi carregada!");
			System.out.println("A foto não foi carregada!");
		} else {
			assertFalse(false, "A foto foi carregada com sucesso!");
			System.out.println("A foto foi carregada com sucesso!");
		}

		return this;
	}

	public CadastrarEntregadorPage clicaOpcaoCadastrar() throws InterruptedException {
		driver.findElement(By.cssSelector(".button-success")).click();
		Thread.sleep(2000);
		return this;
	}


	public CadastrarEntregadorPage validaMsgObrigatorio(String mensagem) throws InterruptedException {
		
		
 		if (mensagem.equals("Oops! CPF inválido")) {
 			String mensagemCapturada = formUtils.capturaMensagem(By.cssSelector(".field:nth-child(2) > .alert-error")).getText();
			assertEquals(mensagemCapturada, mensagem);
        } else if (mensagem.equals("Oops! Selecione apenas um método de entrega")) {
        	String mensagemCapturada = formUtils.capturaMensagem(By.cssSelector(".alert-error:nth-child(3)")).getText();
        	assertEquals(mensagemCapturada, mensagem); 
        } else {
        	return this;
        }
		return null;
		
	}

	public CadastrarEntregadorPage limpaCampo() {
		driver.findElement(By.name("name")).sendKeys("limpa campo");
		driver.findElement(By.name("name")).clear();
		return this;
	}

	public By limparEEnviarDados(By locator, String txt) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(txt);
		return locator;
	}

}
