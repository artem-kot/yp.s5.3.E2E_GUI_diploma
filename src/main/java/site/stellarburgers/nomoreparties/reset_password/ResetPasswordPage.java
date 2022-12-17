package site.stellarburgers.nomoreparties.reset_password;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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


}

