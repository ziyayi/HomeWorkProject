package com.Tutorialsninja.Pages;

import com.Tutorialsninja.Utilities.BaseTest;
import com.Tutorialsninja.Utilities.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {


    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a")
    public WebElement myAccountButton;

    @FindBy(id="input-email")
    public WebElement email;

    @FindBy(id="input-password")
    public WebElement password;

    @FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
    public WebElement loginButton;



    public void login(){

        email.sendKeys(ConfigReader.getProperties("username"));
        password.sendKeys(ConfigReader.getProperties("password"));


        myAccountButton.click();
        loginButton.click();
    }


    public void negativeLogin(String user, String pass){
        email.sendKeys(user);

        password.sendKeys(pass);

        loginButton.click();
    }


}