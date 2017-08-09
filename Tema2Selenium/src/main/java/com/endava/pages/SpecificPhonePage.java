package com.endava.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SpecificPhonePage {

    private WebDriver webDriver;
    public SpecificPhonePage(WebDriver driver){
        this.webDriver = driver;
    }

    @FindBy(css = "div[itemprop='seller']>p>a[class*='inline-block']")
    List<WebElement> sellerElementList;

    @FindBy(css = "meta[itemprop='price']")
    List<WebElement> priceElementList;

    @FindBy(css = "div[id='product_offers_button']")
    WebElement expandButton;

    @FindBy(id = "do_close_cookie_policy")
    WebElement closePopUpButton;

    public void expandPage(){
        closePopUpButton.click();
        expandButton.click();
    }

    public void printShops(){
        int count = 0;
        for (WebElement element : sellerElementList) {
            count++;
            System.out.println(count+". "+element.getAttribute("title"));

        }
        System.out.println("Nr of shops: "+count);
    }

    public void printCheapestPrice(){
        List<Double> priceStringList = new ArrayList<Double>();
        for (WebElement price : priceElementList) {
            String realPrice = price.getAttribute("content");
            realPrice = realPrice.replace(".","").replace(",", ".");
            priceStringList.add(Double.parseDouble(realPrice));
        }
        Double minim = 90071992599990090.0;
        int i = 0, minpos = 0;
        for (Double price : priceStringList){
            if(price < minim) {
                minim = price;
                minpos = i;
            }
            i++;
        }

        System.out.println("Pret minim: "+ priceStringList.get(minpos));
        System.out.println("Magazin: "+ sellerElementList.get(minpos).getAttribute("title"));
    }

    public Double printHighestPrice(){
        List<Double> priceStringList = new ArrayList<Double>();
        for (WebElement price : priceElementList) {
            String realPrice = price.getAttribute("content");
            realPrice = realPrice.replace(".","").replace(",", ".");
            priceStringList.add(Double.parseDouble(realPrice));
        }
        Double maxim = 0.0;
        int i = 0, maxpos = 0;
        for (Double price : priceStringList){
            if(price > maxim) {
                maxim = price;
                maxpos = i;
            }
            i++;
        }
        System.out.println("Pret maxim: "+ priceStringList.get(maxpos));
        System.out.println("Magazin: "+ sellerElementList.get(maxpos).getAttribute("title"));
        return priceStringList.get(maxpos);

    }
}
