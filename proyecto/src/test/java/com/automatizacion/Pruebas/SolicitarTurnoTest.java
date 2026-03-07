package com.automatizacion.Pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automatizacion.Paginas.PaginaFormulario;
import com.automatizacion.Paginas.PaginaInicio;
import com.automatizacion.Paginas.PaginaLogin;
import com.automatizacion.Paginas.PaginaSumario;

public class SolicitarTurnoTest {
    String url = "https://katalon-demo-cura.herokuapp.com/profile.php";
    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new EdgeDriver();
        driver.get(url); // es igual driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @Test
    public void solicitarTurno_CaminoFeliz() {
        PaginaInicio inicio = new PaginaInicio(driver);
        inicio.hacerEnClicEnBtnPedirTurno();

        PaginaLogin login = new PaginaLogin(driver);
        login.escribirUsuario("John Doe");
        login.escribirPassword("ThisIsNotAPassword");
        login.hacerClicEnBtnLogin();

        PaginaFormulario formulario = new PaginaFormulario(driver);
        formulario.seleccionarFacility("Seoul CURA Healthcare Center");
        formulario.hacerClicEnHospital();
        formulario.hacerClicEnPrograma("Medicaid");
        formulario.rellenarFechaVisita("01/02/2026");
        formulario.rellenarComentario("Este es un texto para el comentario.");
        formulario.hacerClicEnBtnBookAppointment();

        PaginaSumario sumario = new PaginaSumario(driver);
        sumario.hacerClicEnGoToHomepage();
        
        // Hacer Logout
        
    }

    @Test
    public void solicitarTurno_DatosInvalidos() {
        PaginaInicio inicio = new PaginaInicio(driver);
        inicio.hacerEnClicEnBtnPedirTurno();

        PaginaLogin login = new PaginaLogin(driver);
        login.escribirUsuario("Marc");
        login.escribirPassword("1234");
        login.hacerClicEnBtnLogin();

        // Hacer Logout
        
    }

    @Test
    public void solicitarTurno_CampoVacio() {
        PaginaInicio inicio = new PaginaInicio(driver);
        inicio.hacerEnClicEnBtnPedirTurno();

        PaginaLogin login = new PaginaLogin(driver);
        login.escribirUsuario("John Doe");
        login.hacerClicEnBtnLogin();
        
        // Hacer Logout
    }

    @AfterSuite
    public void tearDown() {
        //driver.quit();
    }
}
