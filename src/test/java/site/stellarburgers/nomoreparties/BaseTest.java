package site.stellarburgers.nomoreparties;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import site.stellarburgers.nomoreparties.rest.UserApi;
import site.stellarburgers.nomoreparties.rest.UserPojo;

import java.io.IOException;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    String url = "https://stellarburgers.nomoreparties.site/";
    String email = RandomStringUtils.randomAlphabetic(9) + "@example.org";
    String name = "JohnDoe";
    String validPassword = "123456";
    String invalidPassword = "12345";

    public void setUp() {
        /* Lines below are used to start Yandex.Browser */
//        ChromeOptions options = new ChromeOptions();
//        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
//        options.setBinary("C:\\Users\\Banka\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
//        WebDriver driver = new ChromeDriver(options);

        /* Lines below are used to start Yandex.Browser */
        WebDriverManager.chromedriver().setup();
        browser = "chrome";
        driverManagerEnabled = true;
        headless = false;
    }

    @Step("Cleaning test data")
    public void deleteTestUser(){
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


//    Test data is present below.
    String successfulRegistrationProfileTabName = "Профиль";
    String invalidPasswordErrorMessage = "Некорректный пароль";
    String ingredientsTittleText = "Соберите бургер";
}