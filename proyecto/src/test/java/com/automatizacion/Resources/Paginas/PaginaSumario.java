package com.automatizacion.Resources.Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaSumario {

    @FindBy(xpath = "//a[@class='btn btn-default']")
    WebElement goToHomepage;

    //Constructor
     public PaginaSumario(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void hacerClicEnGoToHomepage() {
        goToHomepage.click();
    }
}
