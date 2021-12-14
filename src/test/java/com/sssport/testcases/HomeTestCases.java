package com.sssport.testcases;

import com.sssports.setup.TestBase;
import com.sssports.pageobjects.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class HomeTestCases extends TestBase {

    HomePage homepage;

    public HomeTestCases(){
        super();
    }

    @BeforeTest
    public void setUp() {
        initialization();
        homepage = new HomePage();

    }

  @Test(priority = 1)
  @Description("Select your place to get your order")
  @Feature("Select country")
  @Story("As a user I need to select my country to get my oder at my door step")
  public void clickCountry(){
      homepage.selectCountry();

  }
  @Test(priority =2)
  @Description("To proceed further user need to cancel the pop up")
  @Feature("Cancel Alert information")
  @Story("As a user I need to cancel the Alert so I can move further")
  public void cancelPopup()
  {
     homepage.switchToIframe();

  }

    @Test(priority =3)
    @Description("User can change webapplication language by clicking on the language button")
    @Feature("Change webApplication language")
    @Story("As a user I need to change the webapplication language")
    public void changeLanguage()throws InterruptedException {
        homepage.convertLanguage();

    }
    @Test(priority =4)
    @Description("After changing language user need to cancel the pop up")
    @Feature("Cancel Alert information")
    @Story("As a user I need to cancel the Alert so I can move further")
    public void cancelPopUP(){
        homepage.switchToIframe();
    }

  @Test(priority = 5)
  @Description("User will hover on Men button and will be able to select a value from drop down")
  @Feature("Hover feature ")
  @Story("As a user I need to hover on a button to select an option from drop down")

    public void clickAllMen(){
        homepage.hoverMen();

    }
   @Test(priority = 6)
   @Description("User will hover on Men button and will be able to select a value from drop down")
   @Feature("Hover feature ")
   @Story("As a user I need to click on all product button")
    public void clickProduct(){
        homepage.clickAllMen();
    }

    @Test(priority = 7)
            public void clickOnItem(){
        homepage.clickItem();
    }
    @Test(priority = 8)
    public void selectitemsize() throws InterruptedException
    {
        homepage.selectItemSize();
    }

}
