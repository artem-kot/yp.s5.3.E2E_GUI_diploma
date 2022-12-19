package site.stellarburgers.nomoreparties.pom;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ResetPasswordPage {

    @FindBy(how = How.XPATH, using = "//h2[text()='Восстановление пароля']")
    protected SelenideElement resetPasswordPageInputFieldsTitle;

    @FindBy(how = How.XPATH, using = "//label[text()='Email']/following-sibling::input")
    protected SelenideElement resetPasswordPageInputFieldEmail;

    @FindBy(how = How.XPATH, using = "//button[text()='Восстановить']")
    protected SelenideElement resetPasswordPageResetButton;

    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    protected SelenideElement resetPasswordPageLoginLink;

//    additional fields after reset attempt

    @FindBy(how = How.XPATH, using = "//label[text()='Пароль']/following-sibling::input")
    protected SelenideElement resetPasswordPageInputFieldPassword;

    @FindBy(how = How.XPATH, using = "//label[text()='Введите код из письма']/following-sibling::input")
    protected SelenideElement resetPasswordPageInputFieldCode;

    @FindBy(how = How.XPATH, using = "//button[text()='Сохранить']")
    protected SelenideElement resetPasswordPageSaveNewPasswordButton;

    public HeaderPage header() {
        return page(HeaderPage.class);
    }

    public ResetPasswordPage fillEmail(String email) {
        resetPasswordPageInputFieldEmail.clear();
        resetPasswordPageInputFieldEmail.sendKeys(email);
        return page(ResetPasswordPage.class);
    }

    @Step("Navigate to login page")
    public LoginPage goToLogin() {
        resetPasswordPageLoginLink.click();
        return page(LoginPage.class);
    }
}
