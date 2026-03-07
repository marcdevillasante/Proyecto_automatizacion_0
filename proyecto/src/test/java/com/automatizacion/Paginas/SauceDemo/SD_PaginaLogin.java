package com.automatizacion.Paginas.SauceDemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SD_PaginaLogin {
    @FindBy(id="user-name")
    WebElement txtUsername;
    
    @FindBy(name = "password")
    WebElement txtPassword;
    
    @FindBy(css ="#login-button")
    WebElement btnLogin;

    @FindBy(css=".error-button")
    WebElement btnError;

    WebDriver driver;

    public SD_PaginaLogin(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    public void escribirUsuario(String usuario){
        txtUsername.clear();
        txtUsername.sendKeys(usuario);
    }

    public void escribirPassword(String password){
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void hacerClicEnBtnLogin(){
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
        espera.until(ExpectedConditions.elementToBeClickable(btnLogin));
        btnLogin.click();
    }

    public void ingresarCredenciales (String usuario, String password){
        escribirUsuario(usuario);
        escribirPassword(password);
        hacerClicEnBtnLogin();
    }
    public void limpiarCampos(){
        txtUsername.clear();
        txtPassword.clear();
        btnError.click();
    }
}
