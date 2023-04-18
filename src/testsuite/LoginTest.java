package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        WebElement UsernameField = driver.findElement(By.id("user-name"));
        UsernameField.sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();
        String expectedText ="Products";
        String actualText = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        Assert.assertEquals("User was not able to login successfully", expectedText, actualText);

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        WebElement UsernameField = driver.findElement(By.id("user-name"));
        UsernameField.sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();
        int expectedNumberOfProducts = 6;
        int actualNumberOfProducts = driver.findElements(By.className("inventory_item")).size();
Assert.assertEquals("Different number of products are displayed",expectedNumberOfProducts,actualNumberOfProducts);
    }

    @After
    public void tearDown(){
closeBrowser();



    }
}