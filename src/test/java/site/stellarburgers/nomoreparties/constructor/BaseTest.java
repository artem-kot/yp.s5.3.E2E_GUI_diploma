package site.stellarburgers.nomoreparties.constructor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    public void setUp() {
        /**
         * Строки 17-20 используются для запуска яндекс.браузера
         * Строка 22 используется для запуска хрома
         */
//        ChromeOptions options = new ChromeOptions();
//        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
//        options.setBinary("C:\\Users\\Banka\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
//        WebDriver driver = new ChromeDriver(options);

        WebDriverManager.chromedriver().setup();
        browser = "chrome";
        driverManagerEnabled = true;
        headless = false;
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