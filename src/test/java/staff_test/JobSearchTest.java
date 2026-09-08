package staff_test;

import org.junit.jupiter.api.Test;
import staff.HomePage;
import staff.JobResultsPage;
import staff.SearchPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JobSearchTest extends BaseTest {

    @Test
    public void verifyClearFiltersButton() {

        HomePage homePage = new HomePage(driver);

        SearchPage searchPage = homePage.switchToStandardSearch();

        searchPage.selectRandomCategory();

        JobResultsPage jobResultsPage = searchPage.clickSearch();

        assertTrue(jobResultsPage.isClearFiltersButtonDisplayed(), "Clear filters button should be displayed");
        jobResultsPage.clickClearFilters();

        assertTrue(jobResultsPage.waitUntilClearFiltersButtonDisappears(), "Clear filters button should disappear");

        assertFalse(jobResultsPage.isClearFiltersButtonPresent(), "Clear filters button should not be present in the DOM");
    }
}