package com.automatizacion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CrearOrdenSauceDemo {
    String url = "https://www.saucedemo.com";
    WebDriver driver;

    @BeforeSuite
    public void abrirNavegador() {
        driver = new EdgeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test(priority=1, description="CP-255 Inicio de Sesión Contraseña Erronea")
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
    public void CrearOrden(){
        

        //Iniciar sesión
        WebElement txtUsername = driver.findElement(By.cssSelector("#user-name"));
        txtUsername.clear();
        txtUsername.sendKeys("standard_user");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='password']"));
        txtPassword.clear();
        txtPassword.sendKeys("secret_sauce");
        
        WebDriverWait waitLogin = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitLogin.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        driver.findElement(By.id("login-button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.name("add-to-cart-sauce-labs-backpack")));
        //Elegir producto
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();

        //Ir al carrito
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();

        //Completar la compra
        Faker faker = new Faker();
        driver.findElement(By.id("first-name")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("lastName")).sendKeys(faker.name().lastName());
        driver.findElement((By.xpath("(//input[@id='postal-code'])[1]"))).sendKeys(faker.address().zipCode());

        driver.findElement(By.cssSelector("#continue")).click();
        driver.findElement(By.xpath("//button[@id='finish']")).click();

        //Cerrar sesión
     //   WebDriverWait esperaLogout = new WebDriverWait(driver, Duration.ofSeconds(10));
     //   esperaLogout.until(ExpectedConditions.elementToBeClickable(By.id("react-burguer-menu-btn")));
        driver.findElement(By.id("react-burger-menu-btn")).click();
        
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
        espera.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
        driver.findElement(By.linkText("Logout")).click();

    }

    @Test(priority=2, description="TEST-125 Crear orden en SauceDemo")
    public void crearOrdenProfesor() {
        // Paso 1: Iniciar Sesion
        WebElement txtUsername = driver.findElement(By.cssSelector("#user-name"));
        txtUsername.clear();
        txtUsername.sendKeys("standard_user");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='password']"));
        txtPassword.clear();
        txtPassword.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.name("add-to-cart-sauce-labs-fleece-jacket")));

        // Paso 2: Elegir producto
        driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket")).click();

        // Paso 3: Ir al carrito
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();

        // Paso 4: Completar formulario
        Faker faker = new Faker();

        driver.findElement(By.id("first-name")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("lastName")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(faker.address().zipCode());

        driver.findElement(By.cssSelector("#continue")).click();

        driver.findElement(By.xpath("//button[@id='finish']")).click();

        // Cerrar sesión
        driver.findElement(By.id("react-burger-menu-btn")).click();

        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
        espera.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));

        driver.findElement(By.linkText("Logout")).click();
    }

    @AfterSuite
    public void cerrarNavegador() {
        driver.quit();
    }


}
