package pl.jsystems.qa.qagui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WordpressMainPage extends BasePage {

    public WordpressMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText="Log In")
    public WebElement login = driver.findElement(By.linkText("Log In"));

    public void clickLogin() {
        click(login, 5);
    }
}