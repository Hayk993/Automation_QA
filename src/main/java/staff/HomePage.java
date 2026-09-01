package staff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By standardSearchButton = By.xpath("//button[contains(normalize-space(), 'Switch to standard search')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public SearchPage switchToStandardSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(standardSearchButton)).click();
        return new SearchPage(driver);
    }
}