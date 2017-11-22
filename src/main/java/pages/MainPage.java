package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {
    private WebDriver driver;
    private By menuOpenMultipleWindows = By.xpath("//a[contains(text(), 'Open Multiple Windows')]");
    private By buttonOpenMultiplePages = By.xpath("//a");
    private By iframe = By.xpath("//iframe[@src='frames-windows/defult4.html']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMultiplePages() {
        driver.findElement(menuOpenMultipleWindows).click();
        driver.switchTo().frame(driver.findElement(iframe));
        driver.findElement(buttonOpenMultiplePages).click();
        switchToWindow("window3");
    }

    public void switchToWindow(String str) {
        for (Object window : driver.getWindowHandles().toArray()
                ) {
            driver.switchTo().window(window.toString());
            if (driver.getCurrentUrl().contains(str)) {
                break;
            }
        }
    }

    public void openNextPage() {
        driver.findElement(buttonOpenMultiplePages).click();
        switchToWindow("window3.html#");
    }

    public String getButtonText() {
        return driver.findElement(buttonOpenMultiplePages).getText();
    }
}
