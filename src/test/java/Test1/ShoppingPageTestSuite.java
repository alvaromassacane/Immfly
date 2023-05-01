package Test1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShoppingPageTestSuite {
    WebDriver driver;
    private final Duration TIMEOUT = Duration.ofSeconds(5);

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }


    @Test
    void testSorting() {
        //driver = new ChromeDriver();
        driver.get("https://highlifeshop.com/speedbird-cafe/");
        String cookiesButton ="//button[contains(text(),'ALLOW ALL')]";


        new WebDriverWait(driver,TIMEOUT).until(ExpectedConditions.elementToBeClickable(By.xpath(cookiesButton)));
        driver.findElement(By.xpath(cookiesButton)).click();

        driver.get("https://highlifeshop.com/speedbird-cafe/");
        String categoryButton ="//*[@id='layered-filter-block']/div[2]/div/div[2]/div";


        new WebDriverWait(driver,TIMEOUT).until(ExpectedConditions.elementToBeClickable(By.xpath(categoryButton)));
        driver.findElement(By.xpath(categoryButton)).click();

        String SoftDrinkButton ="//li/a[text()='Soft Drinks']";


        driver.findElement(By.xpath(SoftDrinkButton)).click();


        WebElement sorterElement = driver.findElement(By.id("sorter"));
        Select sorterSelector = new Select(sorterElement);
        sorterSelector.selectByVisibleText("Price");

        String sortArrow ="sort-asc";
        new WebDriverWait(driver,TIMEOUT).until(ExpectedConditions.elementToBeClickable(By.className(sortArrow)));
        driver.findElement(By.className(sortArrow)).click();

    }


}

