package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver webDriver;

    public static WebDriver getWebDriver(){
        if (webDriver == null){
            webDriver = new ChromeDriver();
        }
        return webDriver;
    }

}
