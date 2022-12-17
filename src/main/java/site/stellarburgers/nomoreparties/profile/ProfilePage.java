package site.stellarburgers.nomoreparties.profile;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage {

    @FindBy(how = How.XPATH, using = "//a[text()='Профиль']")
    protected SelenideElement profilePageProfileLink;

    @FindBy(how = How.XPATH, using = "//a[text()='История заказов']")
    protected SelenideElement profilePageUserOrdersLink;

    @FindBy(how = How.XPATH, using = "//button[text()='Выход']")
    protected SelenideElement profilePageLogoutButton;
}
