import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;
    private final By enterLoginButton = By.xpath(".//button[text() = 'Войти']");
    private final By emailField = By.xpath(".//input[@name='name']");
    private final By passwordField = By.xpath(".//input[@name='Пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввод данных при авторизации")
    public void inputData(String email, String pass) {
        inputEmail(email);
        inputPass(pass);
    }

    @Step("заполнение поля \"Email\"")
    public void inputEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("заполнение поля \"Пароль\"")
    public void inputPass(String pass) {
        driver.findElement(passwordField).sendKeys(pass);
    }

    @Step("нажатие на кнопку \"Войти\"")
    public void clickEnterLoginPage() {
        driver.findElement(enterLoginButton).click();
    }

    @Step("ожидание появления кнопки \"Войти\"")
    public String waitEnterButton() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(enterLoginButton));
        return driver.findElement(enterLoginButton).getText();
    }

    @Step("Авторизация")
    public void autorization(LoginPage objLoginPage, String email, String password) {
        objLoginPage.waitEnterButton();
        objLoginPage.inputData(email, password);
        objLoginPage.clickEnterLoginPage();
    }

}

