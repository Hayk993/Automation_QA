package staff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobResultsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By clearFiltersButton = By.xpath("//*[normalize-space()='Clear filters']");

    public JobResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isClearFiltersButtonDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(clearFiltersButton)).isDisplayed();
    }

    public void clickClearFilters() {

        wait.until(ExpectedConditions.elementToBeClickable(clearFiltersButton)).click();
    }

    public boolean isClearFiltersButtonPresent() {

        return !driver.findElements(clearFiltersButton).isEmpty();
    }

    public boolean waitUntilClearFiltersButtonDisappears() {

        return wait.until(driver -> driver.findElements(clearFiltersButton).isEmpty());
    }
}