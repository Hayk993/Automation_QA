package staff_test_tc2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import staff_homework_tc2.JobsAnnouncementPage;

public class FindJobsElements {

    private WebDriver driver;
    private JobsAnnouncementPage jobsAnnouncementPage;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.get("https://staff.am/jobs");

        jobsAnnouncementPage = new JobsAnnouncementPage(driver);
    }

    @Test
    public void jobsPageSearchTest() {

        String oldJobTitle = jobsAnnouncementPage.getFirstJobTitle();

        jobsAnnouncementPage.searchForJob("IT");
        jobsAnnouncementPage.clickToSearchButton();

        Assert.assertTrue(jobsAnnouncementPage.isNewJobDataLoaded(oldJobTitle), "New jobs data should be loaded after IT search");
        Assert.assertTrue(jobsAnnouncementPage.isClearFiltersVisible(), "Clear filters button should be visible after IT search");
        oldJobTitle = jobsAnnouncementPage.getFirstJobTitle();

        jobsAnnouncementPage.searchForJob("HR");
        jobsAnnouncementPage.pressEnter();

        Assert.assertTrue(jobsAnnouncementPage.isNewJobDataLoaded(oldJobTitle), "New jobs data should be loaded after HR search");

        Assert.assertTrue(jobsAnnouncementPage.isClearFiltersVisible(), "Clear filters button should be visible after HR search");

        jobsAnnouncementPage.searchForJob("asdfhefv");
        jobsAnnouncementPage.clickToSearchButton();

        Assert.assertTrue(jobsAnnouncementPage.isNoJobsMessageVisible(), "No jobs message should be displayed");

        oldJobTitle = jobsAnnouncementPage.getFirstJobTitle();

        jobsAnnouncementPage.searchForJob("");
        jobsAnnouncementPage.pressEnter();

        Assert.assertTrue(jobsAnnouncementPage.isNewJobDataLoaded(oldJobTitle), "Jobs data should be updated after clearing the search");
        Assert.assertTrue(jobsAnnouncementPage.isClearFiltersInvisible(), "Clear filters button should be invisible when search is cleared");
    }

    @AfterMethod
    public void close() {

        if (driver != null) {
            driver.quit();
        }
    }
}

