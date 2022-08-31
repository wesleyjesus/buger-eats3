package stepDefinations;

import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.CadastrarEntregadorPage;

public class CadastrarEntregadorSteps {

	private WebDriver driver;

	private CadastrarEntregadorPage cadastrarEntregador;

	@Dado("que eu acesse a tela de cadastro")
	public void queEuAcesseATelaDeCadastro() {
		driver = new ChromeDriver();
		driver.get("https://buger-eats.vercel.app/");
		driver.findElement(By.linkText("Cadastre-se para fazer entregas")).click();
	}

	@Dado("informo os campos obrigatórios")
	public void informoCamposObrigatorios() {
		cadastrarEntregador = new CadastrarEntregadorPage(driver);

		cadastrarEntregador.preencheNome("Joaquim Fulano").preencheCpf("84657318020").preencheEmail("teste@teste.com")
				.preencheCep("72335-001").clicaBuscarCep().preencheNumero("001").preencheComplemento("Casa");

	}

	@Dado("seleciono o metodo de entrega")
	public void selecionoOMetodoDeEntrega() {
		cadastrarEntregador.clicaMetodoEntrega("bicicleta");
	}

	@Dado("insiro a foto da cnh")
	public void insiroAFotoDaCnh() throws URISyntaxException, InterruptedException {
		cadastrarEntregador.inserirFotoCnh();
	}

	@Quando("seleciono a opção cadastrar")
	public void acionoOpcaoCadastrar() throws Exception {
		// Selecionar opção cadastrar
		cadastrarEntregador = new CadastrarEntregadorPage(driver);
		cadastrarEntregador.clicaOpcaoCadastrar();

	}

	@Então("o sistema apresenta mensagem cadastro realizado com sucesso")
	public void apresentaMensagemSucesso() {
		System.out.println("Cadastro realizado com sucesso!");
	}

	@Então("o sistem exibe os campos que devem ser preenchidos")
	public void oSistemExibeOsCamposQueDevemSerPreenchidos() {
		System.out.println("Campos obrigatórios devem ser preenchidos");
	}

	@Quando("eu informar um cpf invalido")
	public void euInformarUmCpfInvalido() {
		cadastrarEntregador = new CadastrarEntregadorPage(driver);
		cadastrarEntregador.preencheCpf("abcdef");
	}

	@Quando("eu informar mais de um método de entrega")
	public void informarMaisDeUmMetodoDeEntrega() {
		cadastrarEntregador = new CadastrarEntregadorPage(driver);
		cadastrarEntregador.clicaMetodoEntrega("moto");
		cadastrarEntregador.clicaMetodoEntrega("van/carro");
	}

	@Então("o sistema exibe a mensagem {string}")
	public void exibeAMensagem(String string) throws InterruptedException {
		cadastrarEntregador.validaMsgObrigatorio(string);
		
	}
	

}
