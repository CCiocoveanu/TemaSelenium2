package com.endava;

import com.endava.pages.MainPage;
import com.endava.pages.SearchPage;
import com.endava.pages.SearchPhonePage;
import com.endava.pages.SpecificPhonePage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class MainTest {

    protected static MainPage mainPage;
    private static WebDriver webDriver;

    @BeforeClass
    public static void before(){
        System.setProperty("webdriver.chrome.driver","C:/Users/cciocoveanu/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://www.shopmania.ro/");

        mainPage = PageFactory.initElements(webDriver, MainPage.class);
    }

    @AfterClass
    public static  void after(){
        webDriver.close();
    }

    @Test
    public void phoneTest(){
        SearchPage searchPage = mainPage.searchPhone("iphone");

        SearchPhonePage searchPhonePage = searchPage.searchPhonePage();

        Assert.assertEquals("1.375 RON",searchPhonePage.getPrice());
        System.out.println("phone price starting from: "+searchPhonePage.getPrice());

        SpecificPhonePage specificPhonePage = searchPhonePage.specificPhonePage();
     //   specificPhonePage.expandPage();    //  Element <div id="product_offers_button">...</div> is not clickable at point (508, 690).
                                             //  Other element would receive the click: <div id="cookie_policy_container">...</div>
        specificPhonePage.printShops();
        specificPhonePage.printCheapestPrice();

        Double expectedHigestPrice = new Double(2399.9);
        Assert.assertEquals(expectedHigestPrice,specificPhonePage.printHighestPrice());

    }
}
