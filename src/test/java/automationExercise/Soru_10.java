package automationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Soru_10 extends TestBase {



    @Test
    public void test01() throws AWTException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Scroll down to footer
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);

        //5. Verify text 'SUBSCRIPTION'
        String subscription = driver.findElement(By.xpath("//*[.='Subscription']")).getText();
        Assert.assertEquals("SUBSCRIPTION",subscription);

        //6. Enter email address in input and click arrow button
        driver.findElement(By.xpath("//*[@id='susbscribe_email']")).sendKeys("asdf@gmail.com");
        driver.findElement(By.xpath("//*[@id='subscribe']")).click();


        //7. Verify success message 'You have been successfully subscribed!' is visible
        WebElement message = driver.findElement(By.xpath("//*[.='You have been successfully subscribed!']"));
        Assert.assertTrue(message.isDisplayed());



    }




}
