package com.automatizacion.Pruebas.GlobalSQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automatizacion.Paginas.GlobalSQA.GS_PaginaFormulario;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GS_FormularioCrossBrowsingTest {
    String url = "https://www.globalsqa.com/samplepagetest/";
    WebDriver driver;

    @SuppressWarnings("null")
    @Parameters("navegador")
    @BeforeTest
    public void setUp(String navegador) {
        if (navegador.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (navegador.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (navegador.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        }
        
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void completarFormulario() {
        GS_PaginaFormulario form = new GS_PaginaFormulario(driver);

        form.cargarArchivo("C://imagen.png");
        form.escribirNombre("Marc");
        form.escribirCorreo("marc@mailinator.com");
        form.escribirSitioWeb("www.mipagina.com");
        form.elegirExperiencia("5-7");
        form.marcaExpFuncional();
        form.marcaExpAutomatizacion();
        form.marcaExpManual();
        form.marcarEducacion();
        form.escribirEnComentario("Mensaje en el Formulario");

        // Manejo de alertas (al final para no afectar el llenado del formulario)
        form.hacerClicEnBtnAlerta();
        form.aceptarEnAlerta();
        form.cancelarEnAlerta();

        //form.hacerClicEnBtnEnviar();
    }

    @AfterSuite
    public void tearDown() {
        //driver.quit();
    }
}
