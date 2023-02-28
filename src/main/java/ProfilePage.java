import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private final WebDriver driver;
    private final By profile = By.xpath(".//a[text() = 'Профиль']");
    private final By construction = By.xpath(".//p[text() = 'Конструктор']");
    private final By logo = By.className("AppHeader_header__logo__2D0X2");
    private final By exitButton = By.xpath(".//button[text() = 'Выход']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("ожидание появления кнопки \"Профиль\"")
    public String waitOrderHomeButton() {
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(profile));
        return driver.findElement(profile).getText();
    }

    @Step("нажатие на кнопку \"Конструктор\"")
    public void clickConstruction() {
        driver.findElement(construction).click();
    }

    @Step("нажатие на \"Логотип\"")
    public void clickLogo() {
        driver.findElement(logo).click();
    }

    @Step("нажатие на кнопку \"Выход\"")
    public void clickExit() {
        driver.findElement(exitButton).click();
    }


}
