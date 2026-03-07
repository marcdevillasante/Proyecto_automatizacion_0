package com.automatizacion.Resources.utilities;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils {
    public static void capturarEvidencia(WebDriver driver, String directorioEvidencias, String nombreArchivo) throws Exception{
        File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen, new File(directorioEvidencias + nombreArchivo + ".jpg"));
    }

    /*Funcion para devolver la fecha actual ddMMyyyyHHmmssSSS */
    public static String obtenerFechaActual() {
        String fechaActual;
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato =  DateTimeFormatter.ofPattern("ddMMyyyyHHmmssSSS");
        fechaActual = ahora.format(formato);

        return fechaActual;
    }
}
