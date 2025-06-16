package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC_01_SearchBox {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver .get("https://www.google.com/");
        sleepInSecond(5);
    }
    @Test
    public void TC_01() {
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        sleepInSecond(7);

        searchBox.sendKeys("Automation");
        sleepInSecond(5);

        searchBox.sendKeys(Keys.ENTER);
        sleepInSecond(3);

        List<WebElement> results = driver.findElements(By.cssSelector("div#search a"));
        if (results.size() >= 3) {
            results.get(2).click();
        } else {
            System.out.println("Not enough search results found");
            return;
        }
        sleepInSecond(3);

        String pageTitle = driver.getTitle();
        Assert.assertNotNull(pageTitle);
        Assert.assertTrue(pageTitle.toLowerCase().contains("automation"), "Page title does not contain 'automation'");
    }



    @AfterClass
    public void afterClass() {
        this.driver.quit();
    }

    public void sleepInSecond(long timeoutInSecond){
        try {
            Thread.sleep(timeoutInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
