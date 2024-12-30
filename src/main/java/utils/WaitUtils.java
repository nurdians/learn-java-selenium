package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForVisibility(By locator, int timeOutInSecond){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(timeOutInSecond));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isElementDisplayed(By locator, int timeOutInSecond){
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(timeOutInSecond));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
