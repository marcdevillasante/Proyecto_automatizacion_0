package com.automatizacion;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class PrimerTest {
    @Test
    public void testEdge() {
        // Paso 1: Definir el navegador a utilizar
        WebDriver driver = new EdgeDriver();
        //Paso 2: Abrir el navegador en una URL
        driver.get("https://www.saucedemo.com/");
        //Cerrar el navegador
       // driver.quit();
    }
}
