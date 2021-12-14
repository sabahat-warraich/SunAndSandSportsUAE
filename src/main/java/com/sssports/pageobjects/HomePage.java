package com.sssports.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

import com.sssports.setup.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;

public class HomePage extends TestBase{
     WebDriverWait wait=new WebDriverWait(driver,30);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions action=new Actions(driver);
    @FindBy(xpath = "//*[@id='country-selector']/div/div/div/div/div/div/div[2]/ul/li[2]/button")
    WebElement countrySelector;
    // iframe Id
    @FindBy(id = "preview-notification-frame")
    WebElement iframeResult;
    //Popup locator
    @FindBy(id="NC_CLOSE_ICON")
    WebElement cancel;
    //change webpage lanuage locator
    @FindBy(linkText = "English")
    WebElement language;
    // super sale iframe locator
    @FindBy(css="#__st_fancy_popup > iframe")
    WebElement saleIframe;
    //super sale alert locator
    @FindBy(css="#__st_bpn_no")
    public WebElement saleLocator ;
    // for men button (click) locator
    @FindBy(xpath = "//*[@id='sg-navbar-collapse']/div/div/nav/div[2]/div[3]/div/ul/li[1]")
    WebElement forMen;
    //click on all men product button locator
    @FindBy(xpath = "//*[@id='sg-navbar-collapse']/div/div/nav/div[2]/div[3]/div/ul/li[1]/ul/li[7]/ul/li/a")
    WebElement allMenProduct;

    // Click on the product to add in the cart locator
    @FindBy(css = "#product-search-results > div.row.listing > div.col-sm-12.col-md-9.listing__products-column.js-products-column > div > div:nth-child(1) > div > div")
    WebElement selectItem;

    //Select size locator
    @FindBy(css = "#vendorSize-size[data-attr-display-value='S']")
    WebElement selectSize;
    //add to cart button locator
    @FindBy(css = "button.add-to-cart.btn.btn-secondary.js-add-to-cart-btn.sticky-product-banner__add-to-cart")
    WebElement addToCart;
    //item price locator
    @FindBy(xpath="//*[@id='maincontent']/div[5]/div/div[2]/div/div[4]/div/span/span/span[1]")
    WebElement itemPrice;
    //item name locator
    @FindBy(css = ".product-detail__product-name.js-gtm-product-name")
    WebElement itemName;
    @FindBy(css = ".js-selected-color-value")
    WebElement itemColor;



    public HomePage()
    {super();
        PageFactory.initElements(driver, this);
    }


    //Country Selector method
    @Step(" User will hit the url : {0}, when user will land on the web page then he will select his country : {1}  ")
    public void selectCountry(){
    wait.until(ExpectedConditions.visibilityOf(countrySelector));
        countrySelector.click();
    }
    //method to switch on iframe and cancel the popup
    @Step(" An alert with some information will show : {0}, user will chancel the alert to move forward : {1}  ")
    public void switchToIframe()
    {
        wait.until(ExpectedConditions.visibilityOf(iframeResult));
        driver.switchTo().frame(iframeResult);
        wait.until(ExpectedConditions.visibilityOf(cancel));
        cancel.click();
        driver.switchTo().defaultContent();


    }
    //methode to switch Eng webpage
    @Step(" User will click on the english language button  : {0}, Web page will land to English version : {1}  ")
    public void convertLanguage() throws InterruptedException
    {
        wait.until(ExpectedConditions.visibilityOf(language));
        language.click();
        Thread.sleep(2000);
    }

    // Method to hover All men button
    @Step(" User will move the cursor to the men button  : {0}, System will dispaly dropdown menu under the hover button : {1}  ")
    public void hoverMen(){
        wait.until(ExpectedConditions.visibilityOf(saleIframe));
        driver.switchTo().frame(saleIframe);
        wait.until(ExpectedConditions.elementToBeClickable(saleLocator));
        saleLocator.click();
        driver.switchTo().defaultContent();

    }
    // Method to click on the All product button
    @Step(" User will click on the all men prodcut button  : {0}, System will display all en products to the user : {1}  ")
    public void clickAllMen()
    {

        js.executeScript("window.scrollBy(0,500)");
        action.moveToElement(forMen).perform();
        wait.until(ExpectedConditions.visibilityOf(allMenProduct));
        allMenProduct.click();

    }

    public void clickItem()
    {
        wait.until(ExpectedConditions.elementToBeClickable(selectItem));
        selectItem.click();
    }

    public void selectItemSize() throws InterruptedException
    {
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,300)");
        System.out.println("Item Name is : "+itemName.getText());
        System.out.println("Item Price is : "+itemPrice.getText());
        System.out.println("Item Color is : "+itemColor.getText());
        action.moveToElement(selectSize).perform();
        wait.until(ExpectedConditions.elementToBeClickable(selectSize));
        selectSize.click();
        wait.until(ExpectedConditions.visibilityOf(addToCart));
        addToCart.click();
    }


}
