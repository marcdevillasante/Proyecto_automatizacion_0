package com.automatizacion.Resources.Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
    // 1) Elementos web que se van a usar en la prueba
    @FindBy(id="btn-make-appointment")
    WebElement btnPedirTurno;


    // 2) Constructor
    public PaginaInicio(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    // 3) Acciones que se pueden hacer con los objetos
public void hacerEnClicEnBtnPedirTurno(){
    btnPedirTurno.click();
}

}
