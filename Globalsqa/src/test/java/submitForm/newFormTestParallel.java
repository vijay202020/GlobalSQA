package submitForm;

import Pages.FormPage;
import base.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import Pages.ConfirmationPage;

import java.util.Random;

import static org.testng.AssertJUnit.assertTrue;


public class newFormTestParallel extends baseTest {
    private static WebDriver driver;
    private final By FormDetails = By.xpath("//blockquote[@class='contact-form-submission']");

    public String confirmformDetails() {
        return driver.findElement(FormDetails).getText();
    }


    @Test
    public void completenewformtestParallel1() {
        //Suite Setup
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/samplepagetest");

        //Test data entry on form
        FormPage formPage = new FormPage();
        driver.findElement(By.id("g2599-name")).sendKeys(Names[(int) (Math.random()*8)]);
        driver.findElement(By.id("g2599-email")).sendKeys("test@automation.com");
        driver.findElement(By.xpath("//input[@class='wpcf7-form-control wpcf7-file']")).sendKeys(Directory+"\\resources\\sample.png");
        driver.findElement(By.id("g2599-website")).sendKeys(Website);
        driver.findElement(By.xpath("//select[@id='g2599-experienceinyears']")).sendKeys(Experiences[(int) (Math.random()*5)]);
        driver.findElement(By.xpath("//div[@class='grunion-field-wrap grunion-field-checkbox-multiple-wrap']//*[contains(text(), '" + Expertises[(int) (Math.random()*3)] + "')]")).click();
        driver.findElement(By.xpath("//div[@class='grunion-field-wrap grunion-field-radio-wrap']//*[contains(text(), '" + Educations[(int) (Math.random()*3)] + "')]")).click();
        driver.findElement(By.id("contact-form-comment-g2599-comment")).sendKeys("Hello parallel!");
        driver.findElement(By.xpath("//button[contains(text(),'Alert Box : Click Here')]")).click();
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();
        ConfirmationPage confirmationPage = formPage.clickSubmitButton();


        //assert to validate test execution results
//        assertTrue(confirmationPage.confirmformDetails()
//                .contains(Educations[(int) (Math.random()*3)]));

        //Suite Teardown
        driver.quit();
    }

    @Test
    public void completenewformtestParallel2() {
        //Suite Setup
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/samplepagetest");
        FormPage formPage = new FormPage();
        //Test data entry on form
        driver.findElement(By.id("g2599-name")).sendKeys(Names[(int) (Math.random()*8)]);
        driver.findElement(By.id("g2599-email")).sendKeys("test@automation.com");
        driver.findElement(By.xpath("//input[@class='wpcf7-form-control wpcf7-file']")).sendKeys(Directory+"\\resources\\sample.png");
        driver.findElement(By.id("g2599-website")).sendKeys(Website);
        driver.findElement(By.xpath("//select[@id='g2599-experienceinyears']")).sendKeys(Experiences[(int) (Math.random()*5)]);
        driver.findElement(By.xpath("//div[@class='grunion-field-wrap grunion-field-checkbox-multiple-wrap']//*[contains(text(), '" + Expertises[(int) (Math.random()*3)] + "')]")).click();
        driver.findElement(By.xpath("//div[@class='grunion-field-wrap grunion-field-radio-wrap']//*[contains(text(), '" + Educations[(int) (Math.random()*3)] + "')]")).click();
        driver.findElement(By.id("contact-form-comment-g2599-comment")).sendKeys("Hello parallel!");
        driver.findElement(By.xpath("//button[contains(text(),'Alert Box : Click Here')]")).click();
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();
        ConfirmationPage confirmationPage = formPage.clickSubmitButton();

        //assert to validate test execution results
//        assertTrue(confirmationPage.confirmformDetails()
//                .contains(Educations[(int) (Math.random()*3)]));

        //Suite Teardown
        driver.quit();

    }

}
