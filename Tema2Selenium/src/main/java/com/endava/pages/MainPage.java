package com.endava.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {

    private WebDriver webDriver;
    public MainPage(WebDriver driver){
        this.webDriver = driver;
    }

    @FindBy(id="autocomplete_prod")
    private WebElement searchBox;


    public SearchPage searchPhone(String phone){

        searchBox.click();
        searchBox.sendKeys(phone);
        searchBox.sendKeys(Keys.ENTER);

        SearchPage searchPage = PageFactory.initElements(webDriver, SearchPage.class);

        return searchPage;
    }


}
