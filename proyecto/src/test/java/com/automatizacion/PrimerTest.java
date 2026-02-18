package com.automatizacion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class PrimerTest {
    @Test
    public void testEdge() {
        // Paso 1: Definir el navegador a utilizar
        WebDriver driver = new EdgeDriver();
        //Paso 2: Abrir el navegador en una URL
        driver.get("https://www.saucedemo.com/");
        //Cerrar el navegador
        driver.quit();
    } 
    @Test
    public void testChrome() {
        // Paso 1: Definir el navegador a utilizar
        WebDriver driver = new ChromeDriver();
        driver.get ("https://www.saucedemo.com/");
        //Cerrar el navegador
        driver.quit();
    }
}
