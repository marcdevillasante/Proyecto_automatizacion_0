package com.automatizacion.Pruebas.FormularioMedico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automatizacion.Paginas.FormularioMedico.FM_PaginaLogin;
import com.automatizacion.Paginas.FormularioMedico.FM_PaginaMakeAppointment;
import com.automatizacion.Paginas.FormularioMedico.FM_PaginaSumario;
import com.automatizacion.utilities.DatosExcel;

public class FM_FormularioMedicoTest {
    String url="https://katalon-demo-cura.herokuapp.com/profile.php#login";
    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new EdgeDriver();
        driver.get(url); // es igual driver.navigate().to(url);
        driver.manage().window().maximize();
        FM_PaginaLogin login = new FM_PaginaLogin(driver);
                
        login.escribirUsername("John Doe");
        login.escribirPassword("ThisIsNotAPassword");
        login.hacerClicEnBtnLogin();
    }

    @Test (dataProvider = "Datos Appointment Excel")
    public void FM_FormularioMedico(String opcion, String aplicacion, String programa, String fecha, String comentario){
        

        FM_PaginaMakeAppointment appointment = new FM_PaginaMakeAppointment(driver);
        appointment.seleccionarFacility(opcion);
        if (aplicacion.equalsIgnoreCase("Yes")){
            appointment.hacerClicEnHospital(aplicacion);
        }
        
        switch (programa) {
            case "medicare":
                driver.findElement(By.id("radio_program_medicare")).click();
                break;
            case "medicaid":
                driver.findElement(By.id("radio_program_medicaid")).click();
                break;
            default:
                driver.findElement(By.id("radio_program_none")).click();
                break;
        }
        
        appointment.rellenarFechaVisita(fecha);
        appointment.rellenarComentario(comentario);
        appointment.hacerClicEnBtnBookAppointment();
        
        FM_PaginaSumario sumario = new FM_PaginaSumario(driver);
        sumario.hacerClicEnGoToHomepage();

    } 
    @DataProvider(name="Datos Appointment Excel")
    public Object[][] obtenerDatosLoginExcel() throws Exception{
        String directorioEvidencias=".//src//test//java//com//automatizacion//resources//";
        String nombreArchivo="DatosAppointment.xlsx";
        String nombreHoja="Hoja 1";

        return DatosExcel.readExcel(directorioEvidencias+nombreArchivo, nombreHoja);
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
