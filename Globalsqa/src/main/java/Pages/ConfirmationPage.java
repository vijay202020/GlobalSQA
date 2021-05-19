package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {

    private final WebDriver driver;
    private final By FormDetails = By.xpath("//blockquote[@class='contact-form-submission']");


    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String confirmformDetails() {
        return driver.findElement(FormDetails).getText();
    }
}
