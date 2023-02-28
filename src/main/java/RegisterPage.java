import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    private final WebDriver driver;

    // локатор для кнопки "Зарегестрироваться"
    private final By registerButton = By.xpath(".//button[text() = 'Зарегистрироваться']");
    private final By enterRegisterButton = By.xpath(".//a[text() = 'Войти']");
    // локатор для поля "Имя"
    private final By nameField = By.xpath(".//fieldset[1]/div/div/input");
    // локатор для поля "Email"
    private final By emailField = By.xpath(".//fieldset[2]/div/div/input");

    // локатор для поля "Пароль"
    private final By passwordField = By.xpath(".//input[@name='Пароль']");

    // локатор для ошибки пароля
    private final By errorMessage = By.xpath(".//p[text() = 'Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("метод для заполнения поля \"Имя\"")
    public void inputName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("метод для заполнения поля \"Email\"")
    public void inputEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("метод для заполнения поля \"Пароль\"")
    public void inputPass(String pass) {
        driver.findElement(passwordField).sendKeys(pass);
    }

    @Step("метод для нажатия на кнопку \"Зарегестрироваться\"")
    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    @Step("метод для поиска сообщения об ошибке в пароле")
    public String findErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    @Step("метод ожидания появления поля \"Имя\"")
    public void waitCloseWindow() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(nameField));
    }

    @Step("метод для нажатия на кнопку \"Войти\"")
    public void clickEnter() {
        driver.findElement(enterRegisterButton).click();
    }

    @Step("метод ожидания появления кнопки \"Войти\"")
    public void waitEnterButton() {
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(enterRegisterButton));
    }


}
