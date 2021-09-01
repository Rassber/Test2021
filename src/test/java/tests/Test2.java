package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test2 {

    private static WebDriver driver;

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test2() {
        driver.get("http://www.google.com");
        driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys("Калькулятор", Keys.ENTER);
        driver.findElement(By.cssSelector("div.jlkklc")).sendKeys("6 / 0", Keys.ENTER);
        assertEquals("Infinity", driver.findElement(By.cssSelector("div.jlkklc")).getText());
    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }
}