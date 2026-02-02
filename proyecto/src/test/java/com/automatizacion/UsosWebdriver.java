package com.automatizacion;

import org.junit.Test;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class UsosWebdriver {
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
        //Cerrar el navegador
        driver.quit();
    } 
}
