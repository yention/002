package M;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class SearchTest {



    @Test
    public void setProp(){
        System.setProperty("webdriver.gecko.driver" , "C:\\Users\\sy039\\Documents\\1_PROJECTS\\Java\\Idea\\001\\src\\test\\resources\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        String queryStr = "Portnov School";
        driver.get("https://www.google.com/");

        WebElement txtInput = driver.findElement(By.cssSelector(".gLFyf"));

        txtInput.sendKeys(queryStr);
        txtInput.submit();

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement resDriver = driver.findElement(By.cssSelector("#result-stats"));
        String result = resDriver.getText();
        String[] strArray = result.split(" ");
        String str = strArray[1];
        String strFixed = str.replace("," , "");
        int countResults = Integer.parseInt(strFixed);
        Assert.assertTrue(countResults > 100);

    }
}
