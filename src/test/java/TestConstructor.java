import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestConstructor {
    private static final String homePageLink = "https://stellarburgers.nomoreparties.site/";
    private WebDriver driver;
    private HomePage objHomePage;

    @Before
    public void initialize() {
        System.setProperty("webdriver.gecko.driver", "C:/Program Files/Git/geckodriver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(homePageLink);
        objHomePage = new HomePage(driver);
        objHomePage.waitEnterHomeButton();
    }


    @Test
    @DisplayName("переход к вкладкам блока Конструктор")
    public void transitionLkTest() {
        souseTest(objHomePage);
        ingredientTest(objHomePage);
        breadTest(objHomePage);
    }

    @Step("переход к разделу Булки")
    public void breadTest(HomePage objHomePage) {
        objHomePage.clickBreadConstruction();
        Assert.assertEquals("Булки", objHomePage.waitBread());
    }

    @Step("переход к разделу Соусы")
    public void souseTest(HomePage objHomePage) {
        objHomePage.clickSouseConstruction();
        Assert.assertEquals("Соусы", objHomePage.waitSouse());
    }

    @Step("переход к разделу Начинки")
    public void ingredientTest(HomePage objHomePage) {
        objHomePage.clickIngredientConstruction();
        Assert.assertEquals("Начинки", objHomePage.waitIngredient());
    }

    @After
    public void tearDown() {
        // закрыли браузер
        driver.quit();
    }


}
