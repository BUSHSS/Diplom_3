import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {
    private final WebDriver driver;
    private final By enterForgotPasswordButton = By.xpath(".//a[text() = 'Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("метод для нажатия на кнопку \"Войти\"")
    public void clickEnter() {
        driver.findElement(enterForgotPasswordButton).click();
    }

    @Step("метод ожидания появления кнопки \"Войти\"")
    public void waitEnterButton() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(enterForgotPasswordButton));
    }

}
