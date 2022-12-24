package site.stellarburgers.nomoreparties.pom;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ProfilePage {

    @FindBy(how = How.XPATH, using = "//a[text()='Профиль']")
    protected SelenideElement profilePageProfileLink;

    @FindBy(how = How.XPATH, using = "//a[text()='История заказов']")
    protected SelenideElement profilePageUserOrdersLink;

    @FindBy(how = How.XPATH, using = "//button[text()='Выход']")
    protected SelenideElement profilePageLogoutButton;

    @FindBy(how = How.XPATH, using = "//a[@class='Account_link__2ETsJ text text_type_main-medium text_color_inactive Account_link_active__2opc9']")
    protected SelenideElement profilePageActiveChapter;

    public HeaderPage header() {
        return page(HeaderPage.class);
    }

    @Step("Logging out")
    public LoginPage logout() {
        profilePageLogoutButton.click();
        return page(LoginPage.class);
    }

    public ProfilePage goToUserOrdersChapter() {
        profilePageUserOrdersLink.click();
        return page(ProfilePage.class);
    }

    public ProfilePage goToUserProfileChapter() {
        profilePageProfileLink.click();
        return page(ProfilePage.class);
    }

    public String getActiveChapterTitle() {
        return profilePageActiveChapter.getText();
    }
}
