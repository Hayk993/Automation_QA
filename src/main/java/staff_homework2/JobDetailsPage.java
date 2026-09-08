package staff_homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobDetailsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By jobTitle = By.xpath("//h1[@role='heading']");
    private final By employer = By.xpath("//a[contains(@href,'/company/')]");
    private final By deadline = By.xpath("//div[normalize-space()='Deadline:']/following-sibling::div");
    private final By location = By.xpath("//img[@alt='location']/parent::div");

    public JobDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getJobTitle() {return wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitle)).getText();}
    public String getEmployer() {return wait.until(ExpectedConditions.visibilityOfElementLocated(employer)).getText();}
    public String getDeadline() {return wait.until(ExpectedConditions.visibilityOfElementLocated(deadline)).getText();}
    public String getLocation() {return wait.until(ExpectedConditions.visibilityOfElementLocated(location)).getText();}

}
