package com.automatizacion.Paginas.SauceDemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SD_PaginaCatalogo {
    @FindBy(id="react-burger-menu-btn")
    WebElement btnMenu;

    @FindBy(linkText = "Logout")
    WebElement lnkLogout;

    WebDriver driver;

    public SD_PaginaCatalogo(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    public void hacerClicEnMenu(){
        btnMenu.click();
    }

    public void hacerClicEnLogout(){
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
        espera.until(ExpectedConditions.elementToBeClickable(lnkLogout));
        lnkLogout.click();
    }
}
