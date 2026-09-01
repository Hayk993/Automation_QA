package saucedemo_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

//Մուտք գործել հավելված, t-shirt-երից մեկը ավելացնել զամբյուղի մեջ։
// Ստուգել որ զամբյուղի վրայի թիվը, որը ցույց է տալիս ապրանքների քանակը թարմացվել է։
// Գնալ զամբյուղի մեջ, համոզվել որ ճիշտ ապրանք եք ավելացրել։ Checkout արեք և համոզվեք, որ վերջնական գինը ճիշտ է։
//Ամեն տեղ օգտագործեք միայն xpath locator.
public class XPathDemo {
    @Test
    public void openGoogle() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@name = 'user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@name = 'login-button']")).click();
        driver.findElement(By.xpath("//button[@name = 'add-to-cart-test.allthethings()-t-shirt-(red)']")).click();

        String countOfBasket = driver.findElement(By.xpath("//span[@data-test='shopping-cart-badge']")).getText();
        Assert.assertEquals(countOfBasket, "1");

        driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).click();

        String rightProduct = driver.findElement(By.xpath("//div[@class = 'inventory_item_name']")).getText();
        Assert.assertEquals(rightProduct, "Test.allTheThings() T-Shirt (Red)");


        driver.findElement(By.xpath("//button[@name = 'checkout']")).click();

        driver.findElement(By.xpath("//input[@data-test= 'firstName']")).sendKeys("Hayk");

        driver.findElement(By.xpath("//input[@data-test= 'lastName']")).sendKeys("Mkrtchyan");

        driver.findElement(By.xpath("//input[@data-test= 'postalCode']")).sendKeys("3217");
        driver.findElement(By.xpath("//input[@data-test= 'continue']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String total = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='total-label']"))).getText();
        Assert.assertEquals(total, "Total: $17.27");


    }
}
