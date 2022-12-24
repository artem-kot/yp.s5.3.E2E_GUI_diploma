package site.stellarburgers.nomoreparties.pom;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class HeaderPage {

    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    protected SelenideElement headerConstructorButton;

    @FindBy(how = How.XPATH, using = "//p[text()='Лента Заказов']")
    protected SelenideElement headerFeedButton;

    @FindBy(how = How.XPATH, using = "//p[text()='Личный Кабинет']")
    protected SelenideElement headerLoginButton;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    protected SelenideElement headerLogoImage;

    @Step("Navigate to main page")
    public ConstructorPage goToConstructor() {
        try {
            Thread.sleep(500); //sleep is added to deal with NFR issue at the test stand.
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        headerConstructorButton.click();
        return page(ConstructorPage.class);
    }

    @Step("Navigate to feed page")
    public FeedPage goToFeed() {
        headerFeedButton.click();
        return page(FeedPage.class);
    }

    @Step("Navigate to login page")
    public LoginPage goToLogin() {
        headerLoginButton.click();
        return page(LoginPage.class);
    }

    @Step("Navigate to profile page")
    public ProfilePage goToProfile() {
        headerLoginButton.click();
        return page(ProfilePage.class);
    }

    public ConstructorPage goToLogo() {
        try {
            Thread.sleep(500); //sleep is added to deal with NFR issue at the test stand.
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        headerLogoImage.click();
        return page(ConstructorPage.class);
    }
}
