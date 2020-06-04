import org.javatuples.Pair;
import org.javatuples.Tuple;
import org.omg.CORBA.ObjectHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static java.lang.Thread.sleep;

public class MainTestClass {

    //1. Open the browser +
    //2. Go to "windows" page +
    //3. Click on "Click Here" link - window 1 +
    //4. Open first window +
    //5. Click on "Elemental Selenium" link - window 2
    //6. Verify the amount of windows is 3
    //7. Verify new window 1 title +
    //8. Verify new window 1 text +
    //9. Verify new window 2 title +
    //10. Verify new window 2 text +
    //11. Switch back to original window
    //12. Verify original window title

    private static final String WINDOWS_MAIN_PAGE = "https://the-internet.herokuapp.com/windows";
    private ArrayList<String > windowsHandlesArr;

    public Map<Integer, Pair<String, String>> NAME_MAP = new HashMap<Integer, Pair<String, String>>();

    WebDriver driver;


    private WebDriverWait waitN(int sec){
        WebDriverWait webDriverWait = new WebDriverWait(driver, sec);
        return webDriverWait;
    }

    @Test
    public void test001() {
        openWindow();
        clickOnLink01("Click Here");
        clickOnLink01("Elemental Selenium");
        putMap();

        for (int i=0; i<3; i++){
//            System.out.println("For page " + i + ": ");
            windowsHandles(i);
            switchToPage(i);
            verifyWinTitle(NAME_MAP.get(i).getValue0());
            verifyWinTxt(NAME_MAP.get(i).getValue1());
        }
    }

    private void putMap() {
        NAME_MAP.put(0, new Pair<String, String>("The Internet","Opening a new window" ));
        NAME_MAP.put(1, new Pair<String, String>("New Window","New Window"));
        NAME_MAP.put(2, new Pair<String, String>("Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro","Elemental Selenium"));
    }

    private void switchToPage(int i) {
        driver.switchTo().window(windowsHandlesArr.get(i));
    }


    private void verifyWinTxt(String expectedTxt) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(driver.getPageSource().contains(expectedTxt));
    }

    private void windowsHandles(int i) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        waitN(25).until((Function<? super WebDriver, Object>) driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS));
    //(ExpectedConditions.visibilityOfElementLocated(By.linkText(String.valueOf(NAME_MAP.get(i).getValue0()))));
//  /html/body/section[2]/div[2]/div[2]/div/form/input[3]
///html/body/section[2]/div[2]/div[2]/div/form/input[3]
        windowsHandlesArr = new ArrayList<String>(driver.getWindowHandles());

//        Assert.assertEquals(amountOfHandles, 3); //3 = expectedres

        Object[] arrayOfObjects = windowsHandlesArr.toArray();
    }

    private void verifyWinTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    private void clickOnLink01(String str) {
        waitN(10).until(ExpectedConditions.visibilityOfElementLocated(By.linkText(str))).click(); //fuck ur brain
    }

    @BeforeSuite
    public void testSuiteSetup(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\sy039\\Documents\\1_PROJECTS\\Java\\Idea\\002\\src\\main\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    private void openWindow() {
        driver.get(WINDOWS_MAIN_PAGE);
    }

}
