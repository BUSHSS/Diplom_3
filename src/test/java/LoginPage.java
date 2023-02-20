import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private By enterLoginButton =By.xpath(".//form/button");
    private By emailField =By.xpath(".//fieldset[1]/div/div/input");
    private By passwordField =By.xpath(".//fieldset[2]/div/div/input");
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    // метод для авторизации
    public void inputData(String email, String pass){
        inputEmail(email);
        inputPass (pass);
    }

    // метод для заполнения поля "Email"
    public void inputEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    // метод для заполнения поля "Пароль"
    public void inputPass(String pass){
        driver.findElement(passwordField).sendKeys(pass);
    }

    // метод для нажатия на кнопку "Войти"
    public void clickEnterLoginPage(){
        driver.findElement(enterLoginButton).click();
    }

    // метод ожидания появления кнопки Войти
    public String waitEnterButton(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(enterLoginButton));
        return driver.findElement(enterLoginButton).getText();
    }

    public void autorization(LoginPage objLoginPage, String email, String password) {
        objLoginPage.waitEnterButton();
        objLoginPage.inputData(email, password);
        objLoginPage.clickEnterLoginPage();
    }

}

