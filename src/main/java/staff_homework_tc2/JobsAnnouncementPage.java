package staff_homework_tc2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobsAnnouncementPage {
    private  WebDriver driver;
    private WebDriverWait wait;

    private final By searchInputLoc = By.xpath("//input[@placeholder='Enter keywords...']");
    private final By searchButtonLoc = By.xpath("//div[text()='Search']");
    private final By clearFiltersLoc = By.xpath("//div[text()='Clear filters']");
    private final By jobTitleLoc = By.xpath("//h1[text()='Current Job Openings']");
    private final By noJobsMessageLoc =  By.xpath("//*[contains(text(), 'No jobs') or contains(text()," +
            " 'Your search returned no results. Please try using different keywords.')]");
    private final By  cookieAcceptButton = (By.xpath("//div[contains(text(), 'We use cookies')]"));

    public JobsAnnouncementPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public String getFirstJobTitle() {
        WebElement jobTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitleLoc)
        );

        return jobTitle.getText();
    }
    public void searchForJob(String key) {

        WebElement searchInput = wait.until(
                ExpectedConditions.elementToBeClickable(searchInputLoc)
        );

        searchInput.sendKeys(Keys.CONTROL + "a");
        searchInput.sendKeys(Keys.BACK_SPACE);
        searchInput.sendKeys(key);
    }


    public void clickToSearchButton() {

        WebElement searchButton = wait.until(
                ExpectedConditions.elementToBeClickable(searchButtonLoc)
        );

        searchButton.click();
    }


    public void pressEnter() {

        WebElement searchInput = wait.until(
                ExpectedConditions.elementToBeClickable(searchInputLoc)
        );

        searchInput.sendKeys(Keys.ENTER);
    }


    public boolean isClearFiltersVisible() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(clearFiltersLoc)
        ).isDisplayed();
    }


    public boolean isClearFiltersInvisible() {

        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(clearFiltersLoc)
        );
    }


    public boolean isNoJobsMessageVisible() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(noJobsMessageLoc)
        ).isDisplayed();
    }


    public boolean isNewJobDataLoaded(String oldJobTitle) {

        return wait.until(
                ExpectedConditions.not(
                        ExpectedConditions.textToBe(jobTitleLoc, oldJobTitle)
                )
        );
    }
}
