package base;

import Pages.FormPage;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class baseTest {

    private static WebDriver driver;

    public static final String Names[]       = {"Johnnes", "Alicia", "smith", "Amanda", "Jeff", "Conan", "Michael","George","Vincent","Bob","Wendy"};
    public static final String Experiences[] = {"0", "1", "3", "5", "7", "10"};
    public static final String Expertises[]  = {"Functional Testing", "Automation Testing", "Manual Testing"};
    public static final String Educations[]  = {"Graduate", "Post Graduate", "Other"};
    public static final String NameFix       = Names[ThreadLocalRandom.current().nextInt(Names.length)];
    public static final String EmailFix      = "test@automation.com";
    public static final String CommentFix    = "Hello There!";
    public static final String Website       = "https://www.technicaltest.com";
    public static final String Experience    = Experiences[ThreadLocalRandom.current().nextInt(Experiences.length)];
    public static final String Expertise     = Expertises[ThreadLocalRandom.current().nextInt(Expertises.length)];
    public static final String Education     = Educations[ThreadLocalRandom.current().nextInt(Educations.length)];
    protected static    String Directory     = System.getProperty("user.dir");


    @BeforeTest
    public void OpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
    }
    public static FormPage setDriver(){
        driver.get("https://www.globalsqa.com/samplepagetest");
        return new FormPage(driver);
    }

//    @AfterMethod
//public void recordFailure(ITestResult result){
//
//        if(ITestResult.FAILURE == result.getStatus())
//    {
//        var camera = (TakesScreenshot)driver;
//        File screenshot = camera.getScreenshotAs(OutputType.FILE);
//        Files.move(screenshot, new File("resources/screenshots/test.png"));
//
//        try{
//            Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
//
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//    }
//}

    @AfterTest
    public void CloseBrowser() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}

