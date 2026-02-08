package com.automatizacion;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestFormularioMedico {
    String url = "https://katalon-demo-cura.herokuapp.com/";

    @Test
    public void solicitarTurnoMedico() {
        WebDriver driver = new EdgeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        /* PARTE I: Clic en Make Appointment */

        WebElement lnkMakeApp = driver.findElement(By.linkText("Make Appointment"));
        lnkMakeApp.click();

        // Otra Forma
        //driver.findElement(By.linkText("Make Appointment")).click();

        /* PARTE II: Inicio de Sesión */

        // Obtener el valor del usuario (está en la página principal)
        //WebElement txtUsuario = driver.findElement(By.cssSelector("input[placeholder='Username'][value='John Doe']"));
        //String valorUsuario = txtUsuario.getText();

        driver.findElement(By.name("username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");

        // Hacer clic en el botón LOGIN
        driver.findElement(By.tagName("button")).click();

        /* PARTE III: Completar Formulario Turno Medico */
        // Espera para evitar el error NoSuchElementException (no encontró un elemento)
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // implicita

        // explicita
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(15));
        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#combo_facility")));

        Select lista = new Select(driver.findElement(By.cssSelector("#combo_facility")));
        lista.selectByVisibleText("Seoul CURA Healthcare Center"); // Según el texto que se ve en la pagina

        //lista.selectByValue("Seoul CURA Healthcare Center"); // Según el atributo value
        //lista.selectByIndex(0); // Según el orden de posición de la opción 

        driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']")).click();
        driver.findElement(By.id("radio_program_medicaid")).click();

        driver.findElement(By.name("visit_date")).sendKeys("16/02/2026");

        WebElement txtArea =  driver.findElement(By.tagName("textarea"));
        txtArea.clear();
        txtArea.sendKeys("Mensaje para mi turno medico");

        driver.findElement(By.cssSelector("#btn-book-appointment")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        //Parte IV validar la página de resultados
        //validar página (URL)
        String UrlValida="https://katalon-demo-cura.herokuapp.com/appointment.php#summary";
        String UrlActual;
        UrlActual=driver.getCurrentUrl();
        System.out.println(UrlActual);
        if (UrlActual.equals(UrlValida)) {
            System.out.println("URL correcta");
        }else{
            System.out.println("URL incorrecta");
        }
        //Validar la instalación "facility"
        String Validar_facility=driver.findElement(By.id("facility")).getText();
        System.out.println(Validar_facility);
        if (Validar_facility.equals("Seoul CURA Healthcare Center")){
            System.out.println("facility correcta");
        }else{
            System.out.println("facility incorrecta");
        }
        //validar el check marcado de "Apply for hospital readmission"
        String Validar_appointment=driver.findElement(By.id("hospital_readmission")).getText();
        System.out.println(Validar_appointment);
        if (Validar_appointment.equals("Yes")){
            System.out.println("appointment confirmation correcta");
        }else{
            System.out.println("appointment confirmation incorrecta");
        }
        //Validar "Healthcare Program"
        String Validar_Program=driver.findElement(By.id("program")).getText();
        System.out.println(Validar_Program);
        if (Validar_Program.equals("Medicaid")){
            System.out.println("Program correcto");
        }else{
            System.out.println("Program incorrecto");
        }   
        //Validar la "Visit date"
        String Validar_Visit_date=driver.findElement(By.id("visit_date")).getText();
        System.out.println(Validar_Visit_date);
        if (Validar_Visit_date.equals("16/02/2026") ){
            System.out.println("Visit Date correcto");
        }else{
            System.out.println("Visit Date incorrecto");
        }  
        //Validar el mensaje del "Comment"
        String Validar_Comment=driver.findElement(By.id("comment")).getText();
        System.out.println(Validar_Comment);
        if (Validar_Comment.equals("Mensaje para mi turno medico") ){
            System.out.println("Comment correcto");
        }else{
            System.out.println("Comment incorrecto");
        } 
        //Pulsar el elemento A link "Go to homepage" 
        driver.findElement(By.linkText("Go to Homepage")).click();
    }
}