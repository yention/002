import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import java.util.ArrayList;
import static java.lang.Thread.sleep;

public class TestTestClass {

    private WebDriver driver;
    private WebElement element;
    private Alert alert;
    private ArrayList<String> list;
    private String[] buttonName = {"//*[@id=\"dblClkBtn\"]", "/html/body/div[1]/div[11]/div/p/button","/html/body/div[1]/div[12]/div/p[1]/button"};
    private WebDriverWait wait;
    private Actions action;
    private String site = "https://www.testandquiz.com/selenium/testing.html";

    @AfterSuite
    public void tearDown() throws InterruptedException {
        sleep(300);
        driver.quit();
    }

    //open site +
    //verify txt "This is sample text." +
    //test link "This is a link" +
    //switch to original page +
    //again open link "This is a link" +
    //write smth to textbox a-z A-Z 0-9 ~!@#$%^&*()_+`,./<>?;':"[]\{}|
    //test button Submit +
    //RADIO BUTTON (choose 1, then 2, again 1) +
    //checkbox  +
    // drop-down (1-2-3-4-1) +
    //double-click +
    //alert box +
    //confirm box  +
    // ??? drag and drop img on the textbox

    @Test
    public void test001() throws InterruptedException { //check all atributes
        openWindow();
        openSite(site);
//        verifyTxt("This is sample text.");
//        clickLink("This is a link");
//        amountOfTab();
//        testForTxtBox();
//        radioButtionCheck();
//        checkBoxCheck();
//        dropDown();
        duttonsClick(buttonName);

        buttonSubmit();
        buttonSubmit();
//        dragAndDrop();
    }

    private void dragAndDrop() {
        WebElement from = driver.findElement(By.xpath("//*[@id=\"sourceImage\"]"));
        WebElement to = driver.findElement(By.xpath("//*[@id=\"targetDiv\"]"));
//        action = new Actions(driver);
        action.dragAndDrop(from, to).build().perform();
    }


    private void duttonsClick(String[] buttonName) throws InterruptedException {
//        action =  new Actions(driver);
        wait = new WebDriverWait(driver, 20);
        for (String o: buttonName){
            element = driver.findElement(By.xpath(o));
            switch (o) {
                case "//*[@id=\"dblClkBtn\"]":
                    action.doubleClick(driver.findElement(By.xpath(o))).perform();

                    wait.until(ExpectedConditions.alertIsPresent());
//                    driver.switchTo().alert().accept();

                    break;
                case "/html/body/div[1]/div[11]/div/p/button":

                    element.click();

                    wait.until(ExpectedConditions.alertIsPresent());
                    driver.switchTo().alert().accept();

                    break;
                case "/html/body/div[1]/div[12]/div/p[1]/button":

                    element.click();

                    wait.until(ExpectedConditions.alertIsPresent());
                    driver.switchTo().alert().accept();

                    element.click();

                    wait.until(ExpectedConditions.alertIsPresent());
                    driver.switchTo().alert().dismiss();

                    break;
            }
        }
    }

    private void dropDown() {
        String[] str = {"Automation Testing", "Performance Testing", "Manual Testing", "Database Testing"};
//        JComboBox <String> comboBox = new JComboBox<String>(str);
        Select dropDown = new Select(driver.findElement(By.id("testingDropdown")));

        for (int i=0; i<str.length; i++){
            dropDown.selectByVisibleText(str[i]);
        }
        dropDown.selectByVisibleText(str[0]);
    }

    private void checkBoxCheck() {
       String[] elementsArray = {".Automation", ".Performance"};
       for (int i =0; i<elementsArray.length; i++) {
           element = driver.findElement(By.cssSelector(elementsArray[i]));
           element.isSelected();
           element.click();
       }
       element = driver.findElement(By.cssSelector(elementsArray[elementsArray.length-1]));
       element.click();
    }

    private void radioButtionCheck() throws InterruptedException {
//        int a = driver.findElements(By.xpath("/html/body/div/div[8]/div/form")).size();
        WebElement radio1 = driver.findElement(By.xpath("//*[@id=\"male\"]"));
        WebElement radio2 = driver.findElement(By.xpath("//*[@id=\"female\"]"));
        radio1.click();
        radio2.click();
        radio1.click();
    }

    private void buttonSubmit() {
        element = driver.findElement(By.id("idOfButton"));
        element.click();
    }

    private void testForTxtBox() {
        element = driver.findElement(By.xpath("//*[@id=\"fname\"]"));
        System.out.println("VALUE SIZE: " + element.getAttribute("maxLength"));
        //        txtBox.sendKeys();
    }

    private void amountOfTab() {
        list = new ArrayList<>(driver.getWindowHandles());
        System.out.println("amount of tabs: " + list.size());
    }

    private void clickLink(String this_is_a_link) {
        element = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/p/a"));
        String openLinkNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
        element.sendKeys(openLinkNewTab);
    }

    private void verifyTxt(String s) {
        String textElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/b")).getText();
        Assert.assertEquals(textElement, s);

    }

    private void openSite(String s) {
        driver.get(s);
    }

    private void openWindow() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\sy039\\Documents\\1_PROJECTS\\Java\\Idea\\002\\src\\main\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        action = new Actions(driver);
        sleep(100);
    }
}
