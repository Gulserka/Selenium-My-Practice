package canhocacozum;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Day09_Challange_Iframe_CanHocaCozumu {

    public class iFrame {
        WebDriver driver;
        @Before
        public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        }
        @After
        public void tearDown(){
            driver.close();
        }
        @Test
        public void iframeTest() throws InterruptedException {
            // ikinci emojiye tıklayın
            int size = driver.findElements(By.tagName("iframe")).size();
            System.out.println("Total iFrames : " + size);
            WebElement iframe=driver.findElement(By.xpath("(//iframe[@id='emoojis'])"));
            driver.switchTo().frame(iframe);
            driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
            List<WebElement> emojis=driver.findElements(By.xpath("//*[@id=\"nature\"]/div/img"));
            emojis.stream().forEach(t->t.click());
            driver.switchTo().defaultContent();
            List<WebElement> forum=driver.findElements(By.xpath("(//input[@class='mdl-textfield__input'])"));
            List <String> inputTexts = new ArrayList<>(Arrays.asList("Hello World!", "Merhaba Javacanlar", "Turkey" ,"Kebab", "Java ile Hayat Cok Guzel", "İstanbul", "Adam" ,"58" , "34", "63", "63"));
            for (int i = 0; i <inputTexts.size() ; i++) {
                forum.get(i).sendKeys(inputTexts.get(i));
            }
            driver.findElement(By.id("send")).click();
        }
    }
}
