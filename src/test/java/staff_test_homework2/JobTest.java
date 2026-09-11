package staff_test_homework2;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import staff_homework2.JobDetailsPage;
import staff_homework2.JobPage;

import java.time.Duration;

public class JobTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyJobInformationCorrectness() {

        driver.get("https://staff.am/jobs");

        JobPage jobPage = new JobPage(driver);

        jobPage.openRandomJob();

        JobDetailsPage jobDetailsPage =
                new JobDetailsPage(driver);

        String actualTitle = jobDetailsPage.getJobTitle();
        String actualEmployer = jobDetailsPage.getEmployer();
        String actualDeadline = jobDetailsPage.getDeadline();
        String actualLocation = jobDetailsPage.getLocation();

        Assert.assertNotNull(actualTitle);
        Assert.assertNotNull(actualEmployer);
        Assert.assertNotNull(actualDeadline);
        Assert.assertNotNull(actualLocation);
    }
}



