package com.automatizacion.Resources.Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
    //Elementos Web 
    @FindBy(id ="txt-username")
    WebElement txtUsername;

    @FindBy(id = "txt-password")
    WebElement txtPassword;

    @FindBy(id = "btn-login")
    WebElement btnLogin;

    // Constructor
    public PaginaLogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Acciones
    public void escribirUsuario(String usuario) {
        txtUsername.sendKeys(usuario);
    }

    public void escribirPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void hacerClicEnBtnLogin() {
        btnLogin.click();
    }
}

