package com.automatizacion.Pruebas.SauceDemo;

import java.sql.Connection;
import java.sql.ResultSet;

import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automatizacion.Paginas.SauceDemo.SD_PaginaLogin;
import com.automatizacion.utilities.AccesoBD;
import com.automatizacion.utilities.VideoRecorder;

public class BaseDeDatosAndVideoRecorderTest {
    String url = "https://www.saucedemo.com/";
    WebDriver driver;
    Connection conexionBD;
    ScreenRecorder grabador;

    @SuppressWarnings("null")
    @BeforeSuite
    public void setUp() throws Exception {
        driver = new EdgeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        conexionBD = AccesoBD.abrirConexionBD("127.0.0.1",
                                              "3306",
                                              "inventarioDB",
                                              "root",
                                              "rose");
    }

    @Test
    public void openSauceDemoAndCheckDB() throws Exception {
        grabador = VideoRecorder.startRecording("OpenSauceDemoAndCheckBD"); // Comenzar la grabacion

        SD_PaginaLogin login = new SD_PaginaLogin(driver);
        login.escribirUsuario("standard_user");
        login.escribirPassword("secret_sauce");
        login.hacerClicEnBtnLogin();

        // Supuesto: Hay que validar en BD que se registre el acceso
        String query = "SELECT codigo, nombre, precio FROM producto WHERE codigo_fabricante = 5";
        ResultSet resultados = AccesoBD.ejecutarQuery(conexionBD, query);

        while (resultados.next()) {
            //System.out.println("Numero de Registros en PRODUCTO: " + resultados.getInt(1));

            System.out.println("Codigo: " + resultados.getInt(1)); 
            System.out.println("Nombre: " + resultados.getString(2));
            System.out.println("Precio: " + resultados.getDouble(3));
        }
    }

    @AfterSuite
    public void tearDown() throws Exception {
        VideoRecorder.stopRecording(grabador); // Detener la grabación

        AccesoBD.cerrarConexionBD(conexionBD);

        driver.quit();
    }
}
