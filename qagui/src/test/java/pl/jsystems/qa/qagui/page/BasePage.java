package pl.jsystems.qa.qagui.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void visibilityOfAllElementsLocatedBy(By by, int maxTime) {
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(maxTime));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void elementToBeClickable(WebElement webElement, int maxTime) {
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(maxTime));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void click(WebElement webElement, int maxTime) {
        elementToBeClickable(webElement, maxTime);
        webElement.click();
    }
}