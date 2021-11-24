package pl.jsystems.qa.qagui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends BasePage {

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className="profile-gravatar__user-display-name")
    public WebElement profileName;
    @FindBy(css="button[title=\"Log out of WordPress.com\"")
    public WebElement logoutButton;

    public String getProfileName() {
        visibilityOfAllElementsLocatedBy(By.className("profile-gravatar__user-display-name"), 3);
        return profileName.getText();
    }

    public String clickLogOutButton() {
        visibilityOfAllElementsLocatedBy(By.className("profile-gravatar__user-display-name"), 3);
        return profileName.getText();
    }

}
