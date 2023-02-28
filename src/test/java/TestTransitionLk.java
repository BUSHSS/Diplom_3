import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class TestTransitionLk {
    private static final String homePageLink = "https://stellarburgers.nomoreparties.site/";
    private static final String email = "6539@yandex.ru";
    private static final String password = "qwerty";
    private WebDriver driver;
    private final int checkNumberButton;
    private final String expectedText;
    private HomePage objHomePage;
    private LoginPage objLoginPage;
    private ProfilePage profilePage;

    public TestTransitionLk(int checkNumberButton, String expectedText) {
        this.checkNumberButton = checkNumberButton;
        this.expectedText = expectedText;
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {1, "Оформить заказ"},
                {2, "Оформить заказ"},
                {3, "Войти"},
        };
    }

    @Before
    public void initialize() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        objHomePage = new HomePage(driver);
        objLoginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

    }

    @Test
    @DisplayName("Переход из личного кабинета на главную и выход из ЛК")
    public void transitionLkTest() {
        driver.get(homePageLink);
        objHomePage.waitEnterHomeButton();
        objHomePage.clickEnterHomeButton();
        login();
        checkAutorization();
        objHomePage.waitLkHomeButton();
        objHomePage.clickEnterLkButton();
        checkEnterLK();
        if (checkNumberButton == 1) {
            transitionConstructor(objHomePage, profilePage);
        } else if (checkNumberButton == 2) {
            transitionLogo(objHomePage, profilePage);
        } else if (checkNumberButton == 3) {
            exit(profilePage);
        }

    }

    @Step("Проверка успешной авторизации")
    public void checkAutorization() {
        objHomePage.checkAutorization(objHomePage);
    }

    @Step("Проверка перехода с главной страницы в ЛК")
    public void checkEnterLK() {
        Assert.assertEquals("Профиль", profilePage.waitOrderHomeButton());
    }

    @Step("Переход с ЛК на Главную по кнопке Кнонструктор")
    public void transitionConstructor(HomePage objHomePage, ProfilePage profilePage) {
        profilePage.clickConstruction();
        Assert.assertEquals(expectedText, objHomePage.waitOrderHomeButton());
    }

    @Step("Переход с ЛК на Главную по логотипу")
    public void transitionLogo(HomePage objHomePage, ProfilePage profilePage) {
        profilePage.clickLogo();
        Assert.assertEquals(expectedText, objHomePage.waitOrderHomeButton());
    }

    @Step("Выход из ЛК")
    public void exit(ProfilePage profilePage) {
        LoginPage objloginPage = new LoginPage(driver);
        profilePage.clickExit();
        Assert.assertEquals(expectedText, objloginPage.waitEnterButton());
    }

    @Step("Заполнение данных для входа - авторизации")
    public void login() {
        objLoginPage.autorization(objLoginPage, email, password);
    }


    @After
    public void tearDown() {
        // закрыли браузер
        driver.quit();
    }


}
