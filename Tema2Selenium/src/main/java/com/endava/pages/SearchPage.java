package com.endava.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    private WebDriver webDriver;
    public SearchPage(WebDriver driver){
        this.webDriver = driver;
    }

    @FindBy(css = "li[class*='icon']>a[title*='Telefoane mobile']")
    WebElement telefoaneButton;

    public SearchPhonePage searchPhonePage(){
        telefoaneButton.click();

        SearchPhonePage searchPhonePage = PageFactory.initElements(webDriver,SearchPhonePage.class);

        return searchPhonePage;
    }

}


//  @FindBy(css="li[class*='icon']>a[title*='Telefoane mobile']")

// li[class*='over']>div:nth-of-type(4)>span[class*='text-gray']>span[class*='price']