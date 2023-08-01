package site.stellarburgers.nomoreparties;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import site.stellarburgers.nomoreparties.rest.UserApi;
import site.stellarburgers.nomoreparties.rest.UserPojo;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    protected String url = "https://stellarburgers.nomoreparties.site/";
    protected String email = RandomStringUtils.randomAlphabetic(9) + "@example.org";
    protected String name = "JohnDoe";
    protected String validPassword = "123456";
    protected String invalidPassword = "12345";
    protected String successfulRegistrationProfileTabName = "Профиль";
    protected String invalidPasswordErrorMessage = "Некорректный пароль";
    protected String ingredientsTittleText = "Соберите бургер";
    protected String loginPageTitle = "Вход";

    public void setUp() {
        /* Lines below are used to start Yandex.Browser */
//        ChromeOptions options = new ChromeOptions();
//        System.setProperty("webdriver.chrome.driver", "PATH_TO yandexdriver.exe");
//        options.setBinary("PATH_TO browser.exe");
//        WebDriver driver = new ChromeDriver(options);

        /* Lines below are used to start Chrome.Browser */
        System.setProperty("chromeoptions.args", "--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        browser = "chrome";
        driverManagerEnabled = true;
        headless = true;
    }

    @Step("Cleaning test data")
    public void deleteTestUser() {
        UserApi api = new UserApi();
        api.deleteUser(new UserPojo(email, validPassword, name));
    }

    @Before
    public void init() {
        setUp();
    }

    @After
    public void teardown() {
        closeWebDriver();
    }
}