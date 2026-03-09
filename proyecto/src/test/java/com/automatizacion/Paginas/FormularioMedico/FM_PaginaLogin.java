package com.automatizacion.Paginas.FormularioMedico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FM_PaginaLogin {
    @FindBy(id="txt-username")
    WebElement txtUsername;

    @FindBy(id="txt-password")
    WebElement txtPassword;

    @FindBy(xpath = "//button[@id='btn-login']")
    WebElement btnLogin;

    WebDriver driver;

    public FM_PaginaLogin(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void escribirUsername(String username){
        txtUsername.sendKeys(username);
    }

    public void escribirPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void hacerClicEnBtnLogin(){
        btnLogin.click();
    }
}
