package saucedemo_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//վտոմատացնել saucedemo-ի լոգինը բոլոր հնարավոր username-երով։
// Այսինքն համոզվել որ բոլոր տրված username-երով հաջողությամբ կարող եք մուտք գործել։ Խորհուրդ եմ տալիս օգտագործել data provider.
public class DataProviderDemo{
    @DataProvider(name = "users")
    public Object[][] users(){
        return new Object[][]{
                {"standard_user"},
                {"locked_out_user"},
                {"problem_user"},
                {"performance_glitch_user"},
                {"error_user"},
                {"visual_user"}
        };
    }
    @Test(dataProvider =  "users")
    public void openGoogle(String usernames){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@name = 'user-name' ]")).sendKeys(usernames);
        driver.findElement(By.xpath("//input[@name = 'password' ]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@name = 'login-button' ]")).click();
        Assert.assertTrue(
                driver.findElement(By.xpath("//span[text()='Products']")).isDisplayed(),
                usernames + " could not login");

    }

}
