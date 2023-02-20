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
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;

@RunWith(Parameterized.class)
public class TestRegister {

    private WebDriver driver;
    private String expectedText;
    private String name;
    private String email;
    private String pass;
    private int checkNumber;
    private RegisterPage objRegisterPage;
    @Before
    public void initialize() {
        System.setProperty("webdriver.gecko.driver", "C:/Program Files/Git/geckodriver/geckodriver.exe");
        // драйвер для браузера Firefox
        driver = new FirefoxDriver();

        // переход на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site/register");
        objRegisterPage = new RegisterPage(driver);
    }


    public TestRegister(int checkNumber,String name, String email, String pass, String expectedText) {
        this.checkNumber = checkNumber;
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.expectedText = expectedText;
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {1,"Ваня", "123@mail.ru", "123",  "Некорректный пароль"},
                {2, "Петя", "123"+ new Random().nextInt(1000)+"@ya.ru", "123456",  "Войти"},
        };
    }


    @Test
    @DisplayName("Тестирование регистрации")
    public void registerTest() {
        objRegisterPage.waitCloseWindow();
        objRegisterPage.inputName(name);
        objRegisterPage.inputEmail(email);
        objRegisterPage.inputPass(pass);
        objRegisterPage.clickRegister();
        if (checkNumber==1) {
            errorRegisterCheck();
        } else if (checkNumber==2) {
            registerCheck();
        }
    }

    @Step("Проверка регистрации")
    public void registerCheck() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(expectedText,loginPage.waitEnterButton());
    }

    @Step("Проверка сообщения об ошибке для пароля")
    public void errorRegisterCheck() {
        Assert.assertEquals(expectedText, objRegisterPage.findErrorMessage());
    }

    @After
    public void teardown() {
        //Закрой браузер
        driver.quit();
    }


}

