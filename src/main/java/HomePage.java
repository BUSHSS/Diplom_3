import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;
    private final By enterHomeButton = By.xpath(".//button[text() = 'Войти в аккаунт']");
    private final By lkButton = By.xpath(".//p[text() = 'Личный Кабинет']");
    private final By orderHomeButton = By.xpath(".//button[text() = 'Оформить заказ']");
    private final By breadCategory = By.xpath(".//h2[text() = 'Булки']");
    private final By souseCategory = By.xpath(".//h2[text() = 'Соусы']");
    private final By ingredientCategory = By.xpath(".//h2[text() = 'Начинки']");
    private final By bread = By.xpath(".//div[1]/span[text() = 'Булки']");
    private final By souse = By.xpath(".//div[2]/span[text() = 'Соусы']");
    private final By ingredient = By.xpath(".//div[3]/span[text() = 'Начинки']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("метод ожидания появления кнопки \"Оформить заказ\"")
    public String waitOrderHomeButton() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(orderHomeButton));
        return driver.findElement(orderHomeButton).getText();
    }

    @Step("метод для нажатия на кнопку \"Войти в аккаунт\"")
    public void clickEnterHomeButton() {
        driver.findElement(enterHomeButton).click();
    }

    @Step("нажатие на кнопку \"Личный кабинет\"")
    public void clickEnterLkButton() {
        driver.findElement(lkButton).click();
    }

    @Step("нажатие на вкладку \"Булки\"")
    public void clickBreadConstruction() {
        driver.findElement(bread).click();
    }

    @Step("нажатие на вкладку \"Соусы\"")
    public void clickSouseConstruction() {
        driver.findElement(souse).click();
    }

    @Step("нажатие на вкладку \"Начинки\"")
    public void clickIngredientConstruction() {
        driver.findElement(ingredient).click();
    }

    @Step("ожидания появления кнопки \"Личный Кабинет\"")
    public void waitLkHomeButton() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(lkButton));
    }

    @Step("ожидания появления кнопки \"Войти в аккаунт\"")
    public void waitEnterHomeButton() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(enterHomeButton));
    }

    @Step("ожидания появления категории \"Булки\"")
    public String waitBread() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(breadCategory));
        return driver.findElement(breadCategory).getText();
    }

    @Step("ожидания появления категории \"Соусы\"")
    public String waitSouse() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(souseCategory));
        return driver.findElement(souseCategory).getText();
    }

    @Step("ожидания появления категории \"Начинки\"")
    public String waitIngredient() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(ingredientCategory));
        return driver.findElement(ingredientCategory).getText();
    }

    @Step("ожидания появления кнопки \"Оформить заказ\"")
    public void checkAutorization(HomePage objHomePage) {
        Assert.assertEquals("Оформить заказ", objHomePage.waitOrderHomeButton());
    }


}
