package lt.techin.seleniumb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SeleniumTestTwo {
    public static void palaukti() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    WebDriver driver;

    @Test
    void seleniumTestTwo() {
        driver = new ChromeDriver();

//        2.Open https://demo.opencart.com/:
        driver.get("http://192.168.1.106/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

//        3.Enter a wrong product name in Search field (F.e: MaxBook):
        WebElement wrongProductName=driver.findElement(By.cssSelector("#search > input"));
        wrongProductName.sendKeys("MaxBook");
        palaukti();

//        4.Click "padidinimo stiklas" button:
        WebElement searchButton=driver.findElement(By.cssSelector("#search > button"));
        searchButton.click();
        palaukti();

        // 5.Check if button: Search is displayed:
        WebElement searchButton2=driver.findElement(By.cssSelector("#search > button"));
        Assertions.assertTrue(searchButton2.isDisplayed());
        System.out.println("Result: Is field to input displayed? "+searchButton2.isEnabled());
        palaukti();

//    6.Clear first Search field and enter the correct product name (F.e.: Macbook):
//        1)
        WebElement searchField=driver.findElement(By.cssSelector("#search > input"));
        searchField.clear();
//        2)
        WebElement searchField2=driver.findElement(By.cssSelector("#search > input"));
        searchField2.sendKeys("Macbook");
        palaukti();

//        7.Click "padidinimo stiklas" button again:
        WebElement searchButton3=driver.findElement(By.cssSelector("#search > button"));
        searchButton3.click();
        palaukti();

//        8.Count the number of searched items:
        List<WebElement> searchResults = driver.findElements(By.xpath("//input[@type='text']"));
        int numberOfSearchResults = searchResults.size();
        System.out.println("Result: Number of searched results is: " + numberOfSearchResults);
        palaukti();

//        9.Select: "Sort By":
//        go to Sort By window:
        WebElement desktops=driver.findElement(By.cssSelector("#narbar-menu > ul > li:nth-child(1) > a"));
        Actions goTo=new Actions(driver);
        goTo.moveToElement(desktops).perform();
        palaukti();
        WebElement showAllDesctops=driver.findElement(By.cssSelector("#narbar-menu > ul > li:nth-child(1) > div > a"));
        showAllDesctops.click();
        palaukti();
//        --------------------------------------
        Select sortByFilterSelect = new Select(driver.findElement(By.id("input-sort")));
        sortByFilterSelect.selectByVisibleText("Price (Low > High)");
//        --------------------------------------
        palaukti();

//        10.Retrieve selected option text and print it:
        WebElement itemsPerPage2 = driver.findElement(By.id("input-sort"));
        Select select2=new Select(itemsPerPage2);
        WebElement selectedOption = select2.getFirstSelectedOption();
        System.out.println("Result: " + selectedOption.getText());
        palaukti();

//        11.Close Browser:
        driver.quit();

    }
}
