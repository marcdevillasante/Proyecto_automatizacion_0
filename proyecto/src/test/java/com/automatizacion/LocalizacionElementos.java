package com.automatizacion;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LocalizacionElementos {
    @Test
    public void testEdge() {
        // Paso 1: Definir el navegador a utilizar
        WebDriver driver = new EdgeDriver();
        //Paso 2: Abrir el navegador en una URL
        driver.get("https://www.saucedemo.com/");
        //maximizar la ventana del navegador
        driver.manage().window().maximize();
        // borrar las cookies
        driver.manage().deleteAllCookies();
        // introducir usuario
        WebElement txtUsuario = driver.findElement(By.id("user-name"));
        txtUsuario.sendKeys("standard_user");
        // introducir contraseña
        WebElement txtPassword = driver.findElement(By.id("password"));
        txtPassword.sendKeys("secret_sauce");
        // pulsar el boton
        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();

        //Cerrar el navegador
        //driver.quit();
    } 
    
}
