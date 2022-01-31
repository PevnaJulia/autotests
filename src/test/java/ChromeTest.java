import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ChromeTest {
    @Test
    public void Test() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Julia\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("javatpoint tutorials");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        driver.findElement(By.name("btnK")).click();
    }

    @Test
    public void TestUkrnet() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Julia\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.ukr.net/");
        driver.switchTo().frame("mail widget");
        WebElement username = driver.findElement(By.id("id-input-login"));
        username.sendKeys("test@test.com");
        WebElement pass = driver.findElement(By.id("id-input-password"));
        pass.sendKeys("12345678");
    }

    @Test
    public void RozAllItems() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Julia\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        List<WebElement> items = driver.findElements(By.className("menu-categories__item"));
        System.out.println(items.size());
    }

    @Test
    public void RozAllImgs() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Julia\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        Thread.sleep(5000);
        List<WebElement> imgs = driver.findElements(By.tagName("img"));
        System.out.println(imgs.size());
    }

    @Test
    public void TestUkrnetByName() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Julia\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.ukr.net/");
        driver.switchTo().frame("mail widget");
        WebElement username = driver.findElement(By.name("login"));
        username.sendKeys("test@test.com");
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("12345678");
    }

    @Test
    public void GoogleByLinkText() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Julia\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://google.com/");
        WebElement username = driver.findElement(By.linkText("українська"));
    }

    @Test
    public void GoogleByPartialLinkText() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Julia\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://google.com/");
        WebElement username = driver.findElement(By.partialLinkText("укра"));
    }

    @Test
    public void RozByCssAbs() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Julia\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        Boolean bool = driver.findElement(By.cssSelector("html body app-root div div rz-header rz-main-header header.header")).isDisplayed();
        System.out.println(bool);
        Assert.assertTrue("Element was found", bool);
        driver.quit();
    }

    @Test
    public void RozByCss() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Julia\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        List<WebElement> elements = driver.findElements(By.cssSelector("div>input"));
        Boolean bool = elements.isEmpty();
        System.out.println(bool);
        Assert.assertFalse("Element was found", bool);
        driver.quit();
    }
    @Test
    public void RozByText() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Julia\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        List<WebElement> elements = driver.findElements(By.xpath("//*[text()=' RU ']"));
        Boolean bool = elements.isEmpty();
        System.out.println(bool);
        Assert.assertFalse("Element was found", bool);
        driver.quit();
    }
    @Test
    public void RozSearch() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Julia\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        WebElement element = driver.findElement(By.xpath("//input[@name='search']"));
        element.sendKeys("игрушки");
        WebElement button = driver.findElement(By.xpath("//*[contains(@class,'button button_color_green button_size_medium search-form')]"));
        button.click();
    }
}
