package com.Tutorialsninja.HWP;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_1 {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://tutorialsninja.com/demo/");

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tarayiciKapat() {
        driver.quit();
    }


    @Test

    public void testCase1() throws InterruptedException {

        WebElement myAccountButton= driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
        myAccountButton.click();
        Thread.sleep(2000);

        WebElement loginButton=driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
        loginButton.click();

        Thread.sleep(2000);

       WebElement email= driver.findElement(By.id("input-email"));
       email.sendKeys("ziyayi2014@gmail.com");

       Thread.sleep(2000);
       WebElement password= driver.findElement(By.id("input-password"));
       password.sendKeys("Mentoring2023");

       Thread.sleep(2000);

       WebElement button= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
       button.click();

       Thread.sleep(3000);

       WebElement searchBox= driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
       searchBox.sendKeys("iPhone");

       Thread.sleep(3000);

           WebElement searchIcon=driver.findElement(By.className("input-group-btn"));
           searchIcon.click();
           Thread.sleep(2000);

           WebElement product=driver.findElement(By.xpath("//*[@id=\"content\"]/h2"));

           String expectedTitle="Products meeting the search criteria";
           String actualTitle=product.getText();

           Assert.assertEquals(actualTitle,expectedTitle,"couldn`t fnd the title");











    }

    }
