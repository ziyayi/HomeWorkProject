package com.Tutorialsninja.Pages;

import com.Tutorialsninja.Utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    public PageObject(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
