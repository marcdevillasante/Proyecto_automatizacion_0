package com.automatizacion;

import java.time.Duration;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Practica1 {
    @Test
    public void testEdge() {
        //Practica 4 - Proyecto real
        //Abrir una página web de pruebas.
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        //Localizar un input por ID e introducir un texto correcto
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Localizar un input por name e introducir un texto correcto
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        // esperar unos segundos en esta página
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //salir de la página
        driver.get("https://the-internet.herokuapp.com/login");
        //probar a entrar a la página con un usuario y una contraseña erroneos
        driver.findElement(By.id("username")).sendKeys("johnsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.className("radius")).click();
        // esperar unos segundos en esta página
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //revisar el mensaje de error mostrado
        // esperar unos segundos en esta página
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        boolean Mensaje_error = driver.findElement(By.className("flash error")).isDisplayed();
        System.out.println(Mensaje_error);
        if (Mensaje_error){
            System.out.println("el mensaje existe");
        }else{
            System.out.println("el mensaje no existe");
        }
        driver.close();  
    } 
}
