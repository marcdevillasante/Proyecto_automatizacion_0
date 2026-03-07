package com.automatizacion.Paginas.GlobalSQA;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GS_PaginaFormulario {
    
    @FindBy(name="file-553")
    WebElement fileSubirArchivo;

    @FindBy(css="#g2599-name")
    WebElement txtNombre;

    @FindBy(id="g2599-email")
    WebElement txtmail;

    @FindBy(name="g2599-website")
    WebElement txtSitioWeb;

    @FindBy(xpath = "//select[@id='g2599-experienceinyears']")
    WebElement lstExperiencia;

    @FindBy(id="g2599-expertise-FunctionalTesting")
    WebElement chkExpFT;

    @FindBy(id="g2599-expertise-AutomationTesting")
    WebElement chkExpAT;

    @FindBy(css="#g2599-expertise-ManualTesting")
    WebElement chkExpMT;

    @FindBy(xpath = "//input[id='g2599-education-PostGraduate']")
    WebElement radEducation;

    @FindBy(css="button[onclick='myFunction']")
    WebElement btnAlerta;

    @FindBy(id="contact-form-comment-g2599-comment")
    WebElement txtComentario;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement btnEnviar;

    WebDriver driver;

    public GS_PaginaFormulario(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void cargarArchivo(String rutaArchivo){
        fileSubirArchivo.sendKeys(rutaArchivo);
    }

    public void escribirNombre(String nombre){
        txtNombre.sendKeys(nombre);
    }

    public void escribirCorreo(String email){
        txtmail.sendKeys(email);
    }

    public void escribirSitioWeb(String sitio){
        txtSitioWeb.sendKeys(sitio);
    }

    public void elegirExperiencia(String valor){
        Select lista = new Select(lstExperiencia);
        lista.selectByContainsVisibleText(valor);
    }

    public void marcaExpFuncional(){
        chkExpFT.click();
    }

    public void marcaExpAutomatizacion(){
        chkExpAT.click();
    }

    public void marcaExpManual(){
        chkExpMT.click();
    }

    public void marcarEducacion(){
        radEducation.click();
    }

    public void hacerClicEnBtnAlerta(){
        btnAlerta.click();
    }

    public Alert obteneralerta(){
        return  driver.switchTo().alert();
    }

    public void aceptarEnAlerta(){
        obteneralerta().accept();
    }

    public void cancelarEnAlerta(){
        obteneralerta().dismiss();
    }

    public void escribirEnComentario(String comentario){
        txtComentario.sendKeys(comentario);
    }

    public void hacerClicEnBtnEnviar(){
        btnEnviar.click();
    }
}
