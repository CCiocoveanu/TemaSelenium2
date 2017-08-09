package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPhonePage {

    private WebDriver webDriver;
    public SearchPhonePage(WebDriver driver){
        this.webDriver = driver;
    }

    @FindBy(xpath = "//div[@id='main_products_container']/ul/li[1]/div[2]/div/p/span")
    private WebElement firstPhonePrice;

    @FindBy(xpath = "//div[@id='main_products_container']/ul/li[1]/div[3]/p/a")
    private WebElement firstPhone;


    public String getPrice(){
        return firstPhonePrice.getText();
    }

    public SpecificPhonePage specificPhonePage(){
        firstPhone.click();

//        WebDriverWait wait = new WebDriverWait(webDriver, 10);
//        WebElement firstPhoneWait = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='main_products_container']/ul/li[1]/div[2]/a")));
//        firstPhoneWait.click();

        SpecificPhonePage specificPhonePage = PageFactory.initElements(webDriver,SpecificPhonePage.class);

        return specificPhonePage;
    }


}

//  ul[class*='prod-gallery-full']>li:nth-of-type(1) >div:nth-of-type(4)>span[class='text-gray']>span[class='price']

//  ul[class*='prod-gallery-full']>li:nth-of-type(1)>div[class*='prod-name']>a

//  //div[@id='main_products_container']/ul/li[1]/div[2]/a