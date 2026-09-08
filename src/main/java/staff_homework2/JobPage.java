package staff_homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//Enter directly to staff.am/jobs page
//Select random job announcement and click to open it in the same browser tab (explore to see where you should click for that)
//Verify, that job announcement details in jobs page (job title, employer, deadline date, location) matches with the one in job details page

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class JobPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By jobAnnouncements = By.xpath("//a[contains(@href,'/jobs/')]");

    public JobPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openRandomJob() {
        List<WebElement> jobs = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(jobAnnouncements));
        Random random = new Random();

        WebElement randomJob = jobs.get(random.nextInt(jobs.size()));
        String jobUrl = randomJob.getAttribute("href");
        driver.get(jobUrl);
    }


}
