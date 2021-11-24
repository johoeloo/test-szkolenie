package pl.jsystems.qa.qagui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainUserPage extends BasePage{

    public MainUserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="login__form-action")
    public WebElement avatar; //= driver.findElement(By.className("login__form-action"));

    public void clickAvatar(){
        click(this.avatar, 5);
    }
}
