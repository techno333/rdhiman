package Stepdefinition;

import Objectrepo.carvaluation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Baseclass {
  public static WebDriver driver;

    static carvaluation carobj;


    public static void Webdriverobj() throws InterruptedException {
        String Browser = "Chrome";
        switch (Browser) {
            case "Chrome":
                driver = new ChromeDriver();
                break;

            case "Edge":
                driver = new EdgeDriver();
                break;

        }

        carobj = new carvaluation(driver);

        driver.manage().window().maximize();
        driver.get("https://www.confused.com/car-valuation");
        carobj.cookie_close();
        carobj.getvalue_button();
        /*carobj.Sign_in();
        carobj.Enter_emailid();
        carobj.signin_button();*/



        //driver.findElement(By.className("CookieWarning__dismiss-UVgy")).click();




    }
}
