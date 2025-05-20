package steps;

import Tests.BuscaProducto;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PlatanitosHomePage;
import utils.DriverManager;

public class BuscarProductoSteps {
	
	private PlatanitosHomePage homepage;
	
	@Given("que estoy en la pagina principal de platanitos")
	public void queEstoyEnLaPaginaPrincipalDePlatanitos(){
		DriverManager.getDriver().get("https://platanitos.com/pe");
		DriverManager.getDriver().manage().window().maximize();
		homepage= new PlatanitosHomePage();
	}
	
	@When("busco el producto {string}")
	public void buscoElProducto(String producto) {
		homepage.ingresarTextoBuscar(producto);
		homepage.clickBotonBuscar();
	}
	
	@Then("debo encontrar productos relacionados con {string}")
	public void deboEncontrarProductosRelacionadosCon(String producto) {
		BuscaProducto.verificarBusqueWrapper(producto, true);
	}
	
	@And("debo cerrar el navegador")
	public void deboCerrarElNavegador() {
		DriverManager.quitDriver();
	}
}
