package com.automatizacion.Pruebas.SauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automatizacion.Paginas.SauceDemo.SD_PaginaCatalogo;
import com.automatizacion.Paginas.SauceDemo.SD_PaginaLogin;
import com.automatizacion.utilities.DatosExcel;

public class SauceDemo_LoginTest {
    String url="https://www.saucedemo.com/";
    WebDriver driver;

    @SuppressWarnings("null")
    @BeforeSuite
    public void setUp(){
        driver = new EdgeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

        @Test (dataProvider = "Datos Login Excel")
    public void login(String usuario, String password){
        SD_PaginaLogin login = new SD_PaginaLogin(driver);
        login.ingresarCredenciales(usuario, password);

        //volver a la posición inicial
        try{
            SD_PaginaCatalogo catalogo = new SD_PaginaCatalogo(driver);
            catalogo.hacerClicEnMenu();
            catalogo.hacerClicEnLogout();
        }catch (Exception e){
            login.limpiarCampos();
        }
    }

    @DataProvider(name="Datos Login Excel")
    public Object[][] obtenerDatosLoginExcel() throws Exception{
        String directorioEvidencias=".//src//test//java//com//automatizacion//resources//";
        String nombreArchivo="DatosLogin.xlsx";
        String nombreHoja="Hoja1";

        return DatosExcel.readExcel(directorioEvidencias+nombreArchivo, nombreHoja);
    }

    @DataProvider(name="Datos Login")
    public Object [][] obtenerDatosLogin(){
        Object [][] datosLogin = new Object [3][2];
        //completar lista
        datosLogin[0][0]="standard_user";
        datosLogin[0][1]="secret_sauce";

        datosLogin[1][0]="performace_glitch_user";
        datosLogin[1][1]="secret_sauce";

        datosLogin[2][0]="visual_user";
        datosLogin[2][1]="secret_sauce";

        return datosLogin;
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
