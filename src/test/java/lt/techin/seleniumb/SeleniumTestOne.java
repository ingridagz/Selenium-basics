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

public class SeleniumTestOne {

    public static void palaukti() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
    }

    WebDriver driver;

    @Test
    void seleniumTestOne() {
        driver = new ChromeDriver();

//        2.Open https://demo.opencart.com/:
        driver.get("http://192.168.1.106/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        isdidinam langa:
        driver.manage().window().maximize();


//        3.Click on a wishlist:
        WebElement wishlist = driver.findElement(By.cssSelector("#wishlist-total > span"));
        wishlist.click();
        palaukti();

//        4.Count and print a number of search boxes:
//        _________________________________
        List<WebElement> searchBox = driver.findElements(By.xpath("//input[@type='text']"));
        int numberOfSearchBoxes = searchBox.size();
        System.out.println("Number of search boxes: " + numberOfSearchBoxes);
//        ---------------------------------
        palaukti();

//        5.Find element of email input field and enter email "email@email.com":
        WebElement eMail = driver.findElement(By.id("input-email"));
        eMail.sendKeys("email@email.com");
        palaukti();

//        6.Clear previous field:
        WebElement eMail2 = driver.findElement(By.id("input-email"));
        eMail2.clear();
        palaukti();

//        7. Submit form:
        WebElement loginForm= driver.findElement(By.cssSelector("[action] .btn-primary"));
        loginForm.submit();
        palaukti();
        WebElement errorElement=driver.findElement(By.cssSelector(".alert-dismissible"));
        Assertions.assertTrue(errorElement.isDisplayed());
        System.out.println(errorElement.getText());
//         arba:
//        String error = driver.findElement(By.cssSelector(".alert-dismissible")).getText();
//        System.out.println(error);
//        Assertions.assertEquals("Warning: No match for E-Mail Address and/or Password.", error);
        palaukti();

//        8. Click on register a new customer:
        WebElement myAccount= driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(2) > div > a > span"));
        myAccount.click();
        palaukti();
        WebElement register= driver.findElement(By.cssSelector("#top > div > div.nav.float-end > ul > li:nth-child(2) > div > ul > li:nth-child(1) > a"));
        register.click();
        palaukti();

//        9. Check if the field to input password is enabled and print the result:
        WebElement passwordField= driver.findElement(By.cssSelector("#input-password"));
//        passwordField.isEnabled();
        Assertions.assertTrue(passwordField.isEnabled());
        System.out.println("Result: Is field to input displayed? "+passwordField.isEnabled());
        palaukti();

//       10.Check if cart elements is displayed and print the result:
        WebElement cart= driver.findElement(By.cssSelector("#input-password"));
        cart.isDisplayed();
        System.out.println("Result: Is cart displayed? "+cart.isDisplayed());
        palaukti();

//        11. Check if agree checkbox is selected and print the result:
        WebElement checkbox=driver.findElement(By.cssSelector("#form-register > div > div > input"));
        checkbox.isSelected();
        System.out.println("Result: Is selected? "+checkbox.isSelected());
        palaukti();

//        12. Go to top menu-> Desktops:
        WebElement desktops=driver.findElement(By.cssSelector("#narbar-menu > ul > li:nth-child(1) > a"));
        Actions goTo=new Actions(driver);
        goTo.moveToElement(desktops).perform();
        palaukti();

//        13. Select to show 25 items per page:
//        go to needed window:
        WebElement showAllDesctops=driver.findElement(By.cssSelector("#narbar-menu > ul > li:nth-child(1) > div > a"));
        showAllDesctops.click();
        WebElement itemsPerPage = driver.findElement(By.id("input-limit"));
        Select select=new Select(itemsPerPage);
        select.selectByVisibleText("25");
        palaukti();

//        14.Print selected option from dropbox:
        WebElement itemsPerPage2 = driver.findElement(By.id("input-limit"));
        Select select2=new Select(itemsPerPage2);
        WebElement selectedOption = select2.getFirstSelectedOption();
        System.out.println("Result: " + selectedOption.getText());
        palaukti();

//        15. Select 4th option in show items per page dropbox:
        select2.selectByIndex(3);
        WebElement itemsPerPage3 = driver.findElement(By.id("input-limit"));
        Select select3=new Select(itemsPerPage3);
        WebElement selectFourth = select3.getFirstSelectedOption();
        palaukti();

//        16. Print selected option:
        System.out.println("Result: " + selectFourth.getText());
        palaukti();

//        17.Close Browser:
        driver.quit();
    }
}
