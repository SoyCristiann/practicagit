package Tests;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.PlatanitosHomePage;
import utils.DriverManager;

public class BuscaProducto {
	@BeforeMethod //BeforeMethod para indicar que esté método se ejecuta antes de cada test
	public void configruacion() {
		//Configuración inicial para abrir el navegador e ir al sitio
		DriverManager.getDriver().get("https://platanitos.com/pe");
		DriverManager.getDriver().manage().window().maximize();
	}
	
	@Test(dataProvider = "productosValidos")
	public void buscarProductoExistente(String producto) {
		// Instanciar la página
		PlatanitosHomePage homePage = new PlatanitosHomePage();		
		
		//Realizar la búsqueda de un producto
		homePage.ingresarTextoBuscar(producto);
		homePage.clickBotonBuscar();
		
		//Verificar los resultados de la búsqueda
		verificarBusqueda(producto, true);
	}
	
	@Test(dataProvider="productosNoValidos")
	public void buscarProductoInexistente(String producto) {
		// Instanciar la página
		PlatanitosHomePage homePage = new PlatanitosHomePage();		
		
		//Realizar la búsqueda de un producto
		homePage.ingresarTextoBuscar(producto);
		homePage.clickBotonBuscar();
		
		//Verificar los resultados de la búsqueda
		verificarBusqueda(producto, false);
	}
	
	@AfterMethod //AfterMethod para indicar que esté método se ejecuta después de cada test
	public void tearDown() {
		//Cerrar el navegador
		DriverManager.quitDriver();	
	}
	
	
	
	
	
	private static void verificarBusqueda(String producto, boolean valorEsperado) {
		List<WebElement> resultadoProductos= DriverManager.getDriver().findElements(By.xpath("(//div[@class='nd-ct__item'])[1]"));
		
		if(valorEsperado) { //Se ejecuta solo si se espera una prueba con True, es decir un producto existente.
			Assert.assertFalse(resultadoProductos.isEmpty(), "No se encontraron productos para " + producto); //Si la lista devuelve vacío, es decir True, fallará.
					
			for(WebElement e: resultadoProductos) {
				String tituloProducto= e.getText().toLowerCase();
				Assert.assertTrue(tituloProducto.contains(producto.toLowerCase()), "Resultado relacionado: " + tituloProducto);
			}
			System.out.println("Todos los resultados están relacionados con el producto: " + producto);
		}else {
			Assert.assertTrue(resultadoProductos.isEmpty(), "Se encuentran productos para " + producto + " el cual no debería existir.");
			System.out.println("No se encontraton resultados para el producto " + producto + " el cual es inexistente.");
		}
		
		
	}
	
	public static void verificarBusqueWrapper(String producto, boolean valorEsperado) {
		verificarBusqueda(producto, valorEsperado);
	}
	
	
	
	// Creación de DataProvider para el manejo de múltiples pruebas
	@DataProvider(name="productosValidos")
	public Object[][] obtenerProductoValido(){
		return new Object[][] {
			{"calzado"},
			{"ropa"},
			{"perfume"}
		};
	}
	
	
	@DataProvider(name="productosNoValidos")
	public Object[][] obtenerProductoInvalido(){
		return new Object[][] {
			{"cualquiercosa"}
		};
	}
}
