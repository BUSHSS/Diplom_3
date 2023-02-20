import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private WebDriver driver;
    private By profile =By.xpath(".//li[1]/a[text() = 'Профиль']");
    private By construction =By.xpath(".//li[1]/a/p");
    private By logo =By.className("AppHeader_header__logo__2D0X2");
    private By exitButton =By.xpath(".//li[3]/button[text() = 'Выход']");
    public ProfilePage(WebDriver driver){
        this.driver=driver;
    }
    // метод ожидания появления раздела Профиль
    public String waitOrderHomeButton(){
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(profile));
        return driver.findElement(profile).getText();
    }
    // метод для нажатия на кнопку "Конструктор"
    public void clickConstruction(){
        driver.findElement(construction).click();
    }

    // метод для нажатия на Логотип
    public void clickLogo(){
        driver.findElement(logo).click();
    }
    // метод для нажатия на раздел Выход
    public void clickExit(){
        driver.findElement(exitButton).click();
    }


}
