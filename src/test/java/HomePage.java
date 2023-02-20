import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private By enterHomeButton =By.xpath(".//section[2]/div/button");
    private By lkButton =By.xpath(".//header/nav/a/p");
    private By orderHomeButton =By.xpath(".//section[2]/div/button[text() = 'Оформить заказ']");
    private By breadCategory =By.xpath(".//div[2]/h2[1][text() = 'Булки']");
    private By souseCategory =By.xpath(".//div[2]/h2[2][text() = 'Соусы']");
    private By ingredientCategory =By.xpath(".//div[2]/h2[3][text() = 'Начинки']");
    private By bread =By.xpath(".//div[1]/span");
    private By souse =By.xpath(".//div[2]/span");
    private By ingredient =By.xpath(".//div[3]/span");

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    // метод ожидания появления кнопки Оформить заказ
    public String waitOrderHomeButton(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(orderHomeButton));
        return driver.findElement(orderHomeButton).getText();
    }
    // метод для нажатия на кнопку "Войти"
    public void clickEnterHomeButton(){
        driver.findElement(enterHomeButton).click();
    }
    // метод для нажатия на кнопку "Личный кабинет"
    public void clickEnterLkButton(){
        driver.findElement(lkButton).click();
    }
    public void clickBreadConstruction(){
        driver.findElement(bread).click();
    }
    public void clickSouseConstruction(){
        driver.findElement(souse).click();
    }
    public void clickIngredientConstruction(){
        driver.findElement(ingredient).click();
    }
    // метод ожидания появления кнопки Личный кабинет
    public void waitLkHomeButton(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(lkButton));
    }
    // метод ожидания появления кнопки Войти
    public void waitEnterHomeButton(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(enterHomeButton));
    }

    public String waitBread(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(breadCategory));
        return driver.findElement(breadCategory).getText();
    }
    public String waitSouse(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(souseCategory));
        return driver.findElement(souseCategory).getText();
    }
    public String waitIngredient(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(ingredientCategory));
        return driver.findElement(ingredientCategory).getText();
    }

    public void checkAutorization(HomePage objHomePage) {
        Assert.assertEquals("Оформить заказ", objHomePage.waitOrderHomeButton());
    }


}
