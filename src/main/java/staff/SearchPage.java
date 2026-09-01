package staff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SearchPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By categoryDropdown = By.xpath("(//div[contains(@class,'ant-select') and contains(@class,'home-select')])[2]");

    private final By categoryOptions = By.cssSelector(".ant-select-item-option");

    private final By searchButton = By.xpath("//div[@tabindex='0'][.//img[@alt='search-icon']]");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectRandomCategory() {

        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(categoryDropdown)
        );

        dropdown.click();
        List<WebElement> options = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(categoryOptions));
        if (options.isEmpty()) {
            throw new IllegalStateException("No job categories were found.");
        }

        int randomIndex = new Random().nextInt(options.size());

        options.get(randomIndex).click();
    }

    public JobResultsPage clickSearch() {

        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

        return new JobResultsPage(driver);
    }
}