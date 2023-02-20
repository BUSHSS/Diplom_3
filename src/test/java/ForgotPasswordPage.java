import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {
    private WebDriver driver;
    private By enterForgotPasswordButton =By.xpath(".//div/p/a");
    public ForgotPasswordPage(WebDriver driver){
        this.driver=driver;
    }
    // метод для нажатия на кнопку "Войти"
    public void clickEnter(){
        driver.findElement(enterForgotPasswordButton).click();
    }

    public void waitEnterButton(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(enterForgotPasswordButton));
    }

}
