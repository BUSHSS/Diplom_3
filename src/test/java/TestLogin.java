import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestLogin {

    private WebDriver driver;
    private static final String email = "6539@yandex.ru";
    private static final String password = "qwerty";
    private static final String homePageLink = "https://stellarburgers.nomoreparties.site/";
    private static final String RegisterPageLink = "https://stellarburgers.nomoreparties.site/register";
    private static final String ForgotPasswordPageLink = "https://stellarburgers.nomoreparties.site/forgot-password";
    private HomePage objHomePage;
    private LoginPage objLoginPage;

    @Before
    public void initialize() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site/register");
        WebDriverManager.chromedriver().setup();

        objHomePage = new HomePage(driver);
        objLoginPage = new LoginPage(driver);
    }


    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void enterHomePage() {
        driver.get(homePageLink);
        objHomePage.waitEnterHomeButton();
        objHomePage.clickEnterHomeButton();
        login();
        checkAutorization();
    }
    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void enterLkHomePage() {
        driver.get(homePageLink);
        objHomePage.waitLkHomeButton();
        objHomePage.clickEnterLkButton();
        login();
        checkAutorization();
    }
        @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void enterForgotPasswordPage() {
        driver.get(ForgotPasswordPageLink);
        ForgotPasswordPage objForgotPassword = new ForgotPasswordPage(driver);
        objForgotPassword.waitEnterButton();
        objForgotPassword.clickEnter();
        login();
        checkAutorization();
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void enterRegisterPage() {
        driver.get(RegisterPageLink);
        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.waitEnterButton();
        objRegisterPage.clickEnter();
        login();
        checkAutorization();
    }


    @Step("Заполнение данных для входа - авторизации")
    public void login() {
        objLoginPage.autorization(objLoginPage,email,password);
    }

    @Step("Проверка успешной авторизации")
    public void checkAutorization() {
        objHomePage.checkAutorization(objHomePage);
    }


    @After
    public void tearDown() {
        // закрыли браузер
        driver.quit();
    }


}
