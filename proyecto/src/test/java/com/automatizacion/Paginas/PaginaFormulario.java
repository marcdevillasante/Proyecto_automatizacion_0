package com.automatizacion.Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaginaFormulario {
    @FindBy(id="combo_facility")
    WebElement listaFac;

    @FindBy(id="chk_hospotal_readmission")
    WebElement chkHopital;

    @FindBy(id="radio_program_medicare")
    WebElement radProgram1;

    @FindBy(id="radio_program_medicaid")
    WebElement radProgram2;

    @FindBy(name="visit_date")
    WebElement txtVisitDate;

    @FindBy(id="txt_comment")
    WebElement txtComment;

    @FindBy(id="btn-book-appointment")
    WebElement btnSend;

    //Constructor
        public PaginaFormulario(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    //acciones
    public void seleccionarFacility(String opcion) {
        Select select = new Select(listaFac);
        select.selectByVisibleText(opcion);
    }

    public void hacerClicEnHospital(){
        chkHopital.click();
    }
    public void hacerClicEnPrograma(String programa){
        radProgram2.click();
    }

    public void rellenarFechaVisita(String fechaVisita){
        txtVisitDate.sendKeys(fechaVisita);
    }

    public void rellenarComentario(String comentario){
        txtComment.sendKeys(comentario);
    }

        public void hacerClicEnBtnBookAppointment() {
        btnSend.click();
    }
}
