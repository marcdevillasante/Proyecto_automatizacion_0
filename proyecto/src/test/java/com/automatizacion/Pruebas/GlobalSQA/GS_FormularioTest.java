package com.automatizacion.Pruebas.GlobalSQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automatizacion.Paginas.GlobalSQA.GS_PaginaFormulario;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GS_FormularioTest {
    String url="https://www.globalsqa.com/samplepagetest/";
    WebDriver driver;

    @BeforeSuite
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void completarFormulario(){
        GS_PaginaFormulario form = new GS_PaginaFormulario(driver);
        form.cargarArchivo("d://imagen.jpg");
        form.escribirNombre("Marc");
        form.escribirCorreo("marc@mailinator.com");
        form.escribirSitioWeb("www.mipagina.com");
        form.elegirExperiencia("5-7");
        form.marcaExpFuncional();
        form.marcaExpAutomatizacion();
        form.marcaExpManual();
        form.marcarEducacion();
        form.hacerClicEnBtnAlerta();
        form.aceptarEnAlerta();
        form.aceptarEnAlerta();
        form.escribirEnComentario("Mensaje en el formulario");
        //form.hacerClicEnBtnEnviar();
    }



    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
