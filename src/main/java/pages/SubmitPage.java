package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SubmitPage {
    private By buttonSignin = By.linkText("Signin");
    private By inputSigninUsername = By.xpath("//form[@class='ajaxlogin']//input[@name='username']");
    private By inputSigninPassword = By.xpath("//form[@class='ajaxlogin']//input[@name='password']");
    private By buttonSigninSubmit = By.xpath("//form[@class='ajaxlogin']//input[@type='submit']");
    private WebDriver driver;

    public SubmitPage(WebDriver driver) {
        this.driver = driver;
    }


    public void signin(String username, String password) {
        driver.findElement(buttonSignin).click();
        driver.findElement(inputSigninUsername).sendKeys(username);
        driver.findElement(inputSigninPassword).sendKeys(password);
        driver.findElement(buttonSigninSubmit).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(buttonSigninSubmit));
    }
}