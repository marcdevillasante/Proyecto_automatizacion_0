package com.automatizacion;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CrearOrdenSauceDemo_CapturaEvidencias {
    String url = "https://www.saucedemo.com/";
    WebDriver driver;
    File screen;
    String directorioEvidencias = ".//Evidencias/";

    @SuppressWarnings("null")
    @BeforeSuite(alwaysRun=true)
    public void abrirNavegador() {
        driver = new EdgeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test(priority=1, description="CP-255 Inicio de Sesión Contraseña Erronea", groups="casos-negativos")
    public void iniciarSesionFallido() {
         // Paso 1: Iniciar Sesion
        WebElement txtUsername = driver.findElement(By.cssSelector("#user-name"));
        txtUsername.sendKeys("standard_user");

        WebElement txtPassword = driver.findElement(By.id("password"));
        txtPassword.sendKeys("XXX");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.cssSelector(".error-button")).click(); 

        txtUsername.clear();
        txtPassword.clear();
    }

    @Test(priority=2, description="TEST-125 Crear orden en SauceDemo")
    public void crearOrden() throws Exception {
        // Paso 1: Iniciar Sesion
        WebElement txtUsername = driver.findElement(By.cssSelector("#user-name"));
        txtUsername.clear();
        txtUsername.sendKeys("standard_user");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='password']"));
        txtPassword.clear();
        txtPassword.sendKeys("secret_sauce");

        // Capturar Evidencia
        capturarEvidencia("01_InicioSesion");

        driver.findElement(By.id("login-button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.name("add-to-cart-sauce-labs-fleece-jacket")));

        // Paso 2: Elegir producto
        driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket")).click();

        // Capturar Evidencia
        capturarEvidencia("02_seleccionproducto");

        // Paso 3: Ir al carrito
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();

        // Paso 4: Completar formulario
        Faker faker = new Faker();

        driver.findElement(By.id("first-name")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("lastName")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(faker.address().zipCode());

        // Capturar Evidencia
        capturarEvidencia("03_datospersonales");

        driver.findElement(By.cssSelector("#continue")).click();

        driver.findElement(By.xpath("//button[@id='finish']")).click();

        // Capturar Evidencia
        capturarEvidencia("04_comprafinalizada");

        // Cerrar sesión
        driver.findElement(By.id("react-burger-menu-btn")).click();

        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
        espera.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));

        driver.findElement(By.linkText("Logout")).click();
    }

    @AfterSuite(alwaysRun=true)
    public void cerrarNavegador() {
        //driver.quit();
    }

    public void capturarEvidencia(String nombreArchivo) throws Exception {
        screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen, new File(directorioEvidencias + nombreArchivo + ".jpg"));
    }
}
