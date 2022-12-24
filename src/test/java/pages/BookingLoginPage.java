package pages;

import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingLoginPage {

    private static final Logger LOGGER =
            Logger.getLogger(BookingLoginPage.class.getName());

    WebDriver driver = Driver.getWebDriver();

    public void registerInBooking(String email) {
        LOGGER.info("Opening booking.com");
        driver.get("https://booking.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();
        LOGGER.info("Go to create account page");
        driver.findElement(By.xpath("//*[@class='bui-button bui-button--secondary js-header-login-link'][1] | //*[@class='bui-button bui-button--secondary js-header-login-link'][1] | //*[@aria-label='Создать аккаунт']")).click();
        WebElement loginInputField = driver.findElement(By.xpath("//*[@data-ga-label='username']"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(loginInputField));
        loginInputField.sendKeys(email);
        LOGGER.info("Submit new email");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='new_password']")));
        driver.findElement(By.xpath("//*[@name='new_password']")).sendKeys("Password12345");
        driver.findElement(By.xpath("//*[@name='confirmed_password']")).sendKeys("Password12345");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Actions actions = new Actions(driver);
        try {
            WebElement clickAndHold = driver.findElement(By.xpath("//*[text()='Нажмите и удерживайте эту кнопку, чтобы пройти проверку безопасности.']/preceding-sibling::p"));
            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(clickAndHold));
            actions.moveToElement(clickAndHold).clickAndHold();
        } catch (org.openqa.selenium.NoSuchElementException e){
            LOGGER.error("Click and hold button on booking registration form is not found", e);
        }

    }


}
