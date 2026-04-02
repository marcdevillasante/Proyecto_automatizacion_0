//meter las importaciones necesarias
package com.automatizacion.Steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import com.automatizacion.Paginas.SauceDemo.SD_PaginaLogin;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SD_LoginSteps {
    String url = "https://www.saucedemo.com/";
    WebDriver driver;
@SuppressWarnings("null")
@Before

    public void setUp() {
        // Configuración inicial, como abrir el navegador y navegar a la página de login
        driver = new EdgeDriver();
        driver.get(url);    
        driver.manage().window().maximize();
    }
    
    /*
    Scenario: Iniciar sesion con usuario valido
    Given user is in the login page
    When user enters valid username and password
    Then the product catalog should be displayed
    */
     @Given("user is in the login page")
     public void user_is_in_the_login_page() {
         String tituloEsperado = "Swag Labs";
         String tituloActual = driver.getTitle();   
         Assert.assertEquals(tituloActual, tituloEsperado, "El título de la página no coincide con el esperado.");

     }

     @When("user enters valid username and password")
     public void user_enters_valid_username_and_password() {
         SD_PaginaLogin login = new SD_PaginaLogin(driver);
         login.escribirUsuario("standard_user");
         login.escribirPassword("secret_sauce");
         login.hacerClicEnBtnLogin();
     }

     @Then("the product catalog should be displayed")
     public void the_product_catalog_should_be_displayed() {
        try {   
            SD_PaginaLogin login = new SD_PaginaLogin(driver);
            Assert.assertTrue(login.lblProducts.isDisplayed(), "El catálogo de productos no se muestra correctamente.");
        } catch (Exception e) {
            Assert.fail("Ocurrió un error al verificar la visualización del catálogo de productos: " + e.getMessage());
        }
         // Aquí puedes agregar una validación para verificar que el catálogo de productos se muestre correctamente
         // Por ejemplo, podrías verificar que un elemento específico del catálogo esté presente en la página
         
     }

    @After
    public void tearDown() {
        // Cerrar el navegador después de cada escenario
        if (driver != null) {
            driver.quit();
        }
    }   
}
