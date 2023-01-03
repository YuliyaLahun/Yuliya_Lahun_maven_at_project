package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TrashMailPage {

    WebDriver driver = Driver.getWebDriver();

    public TrashMailPage() {
        PageFactory.initElements(driver, this);
    }

    public String createDisposaleEmail() {
        driver.get("https://trashmail.com/");
        driver.findElement(By.id("fe-mob-forward")).sendKeys("yuliyalahun1990@gmail.com");
        driver.findElement(By.id("fe-mob-fwd-nb")).click();
        driver.findElement(By.xpath("//*[@value='10']")).click();
        driver.findElement(By.id("fe-mob-submit")).click();
        return driver.findElement(By.xpath("//h4[@class='text-center']")).getText();
    }

}
