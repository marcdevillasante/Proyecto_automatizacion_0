package com.automatizacion;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automatizacion.Resources.utilities.Utils;

public class herokuapp_login_captura_de_evidencias {
    String url = "https://the-internet.herokuapp.com/login";
    WebDriver driver;
    File screen;
    String directorioEvidencias = "./Evidencias/";

    @BeforeSuite
    public void setUp() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("-inprivate"); // start-maximized, headless

        driver = new EdgeDriver(options);
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void login() throws Exception {
        driver.findElement(By.id("username")).sendKeys("tomsmith"); // Usuario
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Validación del mensaje You logged into a secure area!
        WebElement mensaje = driver.findElement(By.id("flash"));
        String mensajeActual = mensaje.getText();
        String mensajeEsperado = "You logged into a secure area!";
        Assert.assertTrue(mensajeActual.contains(mensajeEsperado), "ERR-002: El mensaje luego de iniciar sesión no es correcto");
    }

    // Cuando sólo queremos capturar evidencia si la prueba falla
    @AfterMethod
    public void capturaEnCasoDeError(ITestResult result) throws Exception{
        if (result.getStatus() == ITestResult.FAILURE) {
            Utils.capturarEvidencia(driver, directorioEvidencias, "resultadoLogin");
        }
    }

    @AfterSuite
    public void tearDown() {
        //driver.quit();
    }
}
