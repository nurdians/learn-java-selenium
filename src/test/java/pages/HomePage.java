package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.WaitUtils;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private WaitUtils waitUtils;

    private By keywordFeld = By.name("q");
    private By keywordAfterSearch = By.xpath("//textarea[@name=\"q\"]");

    public HomePage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.waitUtils = new WaitUtils(driver);
    }

    public void search(String keyword){
        WebElement searchBox = driver.findElement(keywordFeld);
        searchBox.sendKeys(keyword);
        searchBox.submit();

        WebElement resultBox = wait.until(ExpectedConditions.visibilityOfElementLocated(keywordAfterSearch));
        Assert.assertTrue(waitUtils.isElementDisplayed(keywordAfterSearch,10));
        Assert.assertEquals(resultBox.getText(),"Selenium");
    }

    public String getPageTitle(){
        return driver.getTitle();
    }
}
