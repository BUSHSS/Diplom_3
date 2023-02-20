import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    private WebDriver driver;

    // локатор для кнопки "Зарегестрироваться"
    private By registerButton =By.xpath(".//div/main/div/form/button");
    private By enterRegisterButton =By.xpath(".//div/p/a");
    private By window=By.className("Modal_modal_overlay__x2ZCr");
    // локатор для поля "Имя"
    private By nameField = By.xpath(".//fieldset[1]/div/div/input");
    // локатор для поля "Email"
    private By emailField = By.xpath(".//fieldset[2]/div/div/input");

    // локатор для поля "Пароль"
    private By passwordField = By.xpath(".//fieldset[3]/div/div/input");

    // локатор для ошибки пароля
    private By errorMessage = By.xpath(".//fieldset[3]/div/p");

    public RegisterPage(WebDriver driver){
        this.driver=driver;
    }

    // метод для заполнения поля "Имя"
    public void inputName(String name){
        driver.findElement(nameField).sendKeys(name);
    }
    // метод для заполнения поля "Email"
    public void inputEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    // метод для заполнения поля "Пароль"
    public void inputPass(String pass){
        driver.findElement(passwordField).sendKeys(pass);
    }
    // метод для нажатия на кнопку "Зарегестрироваться"
    public void clickRegister(){
        driver.findElement(registerButton).click();
    }

    // метод для поиска сообщения об ошибке в пароле
    public String findErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

    // метод ожидания появления кнопки Войти
    public void waitCloseWindow(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(nameField));
    }

    // метод для нажатия на кнопку "Войти"
    public void clickEnter(){
        driver.findElement(enterRegisterButton).click();
    }
    public void waitEnterButton(){
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(enterRegisterButton));
    }




}
