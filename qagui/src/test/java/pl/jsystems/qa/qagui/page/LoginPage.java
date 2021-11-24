package pl.jsystems.qa.qagui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="usernameOrEmail")
    public WebElement userLogInput;

    @FindBy(className="ogin__form-action")
    public WebElement userContinueButton;

    @FindBy(id="password")
    public WebElement passLogInput;

    @FindBy(className="login__form-action")
    public WebElement passConfirmButton;

    public void enterUser(String userName) {
        visibilityOfAllElementsLocatedBy(By.id("password"),3);
        this.userLogInput.click();
        this.userLogInput.clear();
        this.userLogInput.sendKeys(userName);
    }

    public void enterPass(String pass) {
        visibilityOfAllElementsLocatedBy(By.id("password"),3);
        this.passLogInput.click();
        this.userContinueButton.clear();
        this.passConfirmButton.sendKeys(pass);
    }

}