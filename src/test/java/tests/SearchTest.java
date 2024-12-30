package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;


public class SearchTest extends BaseTest {

    @Test
    public void successfullySearch(){
        HomePage homePage = new HomePage(driver);
        homePage.search("Selenium");
        System.out.println(homePage.getPageTitle());
    }
}
