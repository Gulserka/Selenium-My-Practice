package automationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Soru_09 extends TestBase {



    @Test
    public void test01() {
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement productPage = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(productPage.isDisplayed());

        //6. Enter product name in search input and click search button
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("Winter Top");
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();

        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement search_product = driver.findElement(By.xpath("//div[@class='features_items']"));
        Assert.assertTrue(search_product.isDisplayed());

        //8. Verify all the products related to search are visible
        driver.navigate().back();
        List<WebElement> allProducts = driver.findElements(By.xpath("//*[@class='productinfo text-center']//p"));
        for (WebElement w : allProducts) {
            Assert.assertTrue(w.isDisplayed());
        }
        //allProducts.stream().forEach(WebElement::isDisplayed);
    }
}