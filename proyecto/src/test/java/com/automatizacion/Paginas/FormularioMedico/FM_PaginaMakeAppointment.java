package com.automatizacion.Paginas.FormularioMedico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FM_PaginaMakeAppointment {
    @FindBy(id="combo_facility")
    WebElement listaFac;

    @FindBy(id="chk_hospotal_readmission")
    WebElement chkHopital;

    @FindBy(id="radio_program_medicare")
    WebElement radProgram1;

    @FindBy(id="radio_program_medicaid")
    WebElement radProgram2;

    @FindBy(id="radio_program_none")
    WebElement radProgram3;

    @FindBy(name="visit_date")
    WebElement txtVisitDate;

    @FindBy(id="txt_comment")
    WebElement txtComment;

    @FindBy(id="btn-book-appointment")
    WebElement btnSend;

    WebDriver driver;

        public FM_PaginaMakeAppointment(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    
    public void seleccionarFacility(String opcion) {
        Select select = new Select(listaFac);
        select.selectByVisibleText(opcion);
    }

    public void hacerClicEnHospital(String aplicacion){
        chkHopital.click();
    }
    
    public void hacerClicEnPrograma1(String programa){
        
        radProgram1.click();
    }

    public void hacerClicEnPrograma2(String programa){
        
        radProgram2.click();
    }

    public void hacerClicEnPrograma3(String programa){
        
        radProgram3.click();
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
