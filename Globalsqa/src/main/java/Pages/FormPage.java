package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class FormPage {
    private WebDriver driver;

    private By FileUploadElement  = By.xpath("//input[@class='wpcf7-form-control wpcf7-file']");
    private By NameElement        = By.id("g2599-name");
    private By EmailElement       = By.id("g2599-email");
    private By WebsiteElement     = By.id("g2599-website");
    private By CommentsElement    = By.id("contact-form-comment-g2599-comment");
    private By ExperienceElement  = By.xpath("//select[@id='g2599-experienceinyears']");
    private By EducationElement   = By.xpath("//input[@name='g2599-education']");
    private By ExpertiseElement   = By.xpath("//div[@class='grunion-field-wrap grunion-field-checkbox-multiple-wrap']");
    private By SubmitButton       = By.xpath("//button[contains(text(),'Submit')]");
    private By AlertButtonElement = By.xpath("//button[contains(text(),'Alert Box : Click Here')]");


    public FormPage(WebDriver driver) {
        this.driver = driver;
    }


    public FormPage(){};

    public void setName(String firstname) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(NameElement));
        driver.findElement(NameElement).sendKeys(firstname);
    }

    public void uploadProfile(String profile) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(FileUploadElement));
        driver.findElement(FileUploadElement).sendKeys(profile);
    }

    public void setEmail(String email){
        driver.findElement(EmailElement).sendKeys(email);
    }

    public void setWebsite(String website) {
        driver.findElement(WebsiteElement).sendKeys(website);
    }

    public void setExperience(String experience) {
        driver.findElement(ExperienceElement).sendKeys(experience);
    }

    public void setEducation(String education) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(EducationElement));
        driver.findElement(By.xpath("//div[@class='grunion-field-wrap grunion-field-radio-wrap']//*[contains(text(), '"+education+"')]")).click();
    }

    public void setExpertise(String expertise) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ExpertiseElement));
        driver.findElement(By.xpath("//div[@class='grunion-field-wrap grunion-field-checkbox-multiple-wrap']//*[contains(text(), '"+expertise+"')]")).click();
    }

    public void setComments(String comments) {
        driver.findElement(CommentsElement).sendKeys(comments);
    }

    public void clickAlertButton() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(AlertButtonElement));
        driver.findElement(AlertButtonElement).click();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().accept();
    }

    public ConfirmationPage clickSubmitButton() {
        driver.findElement(SubmitButton).click();
        return new ConfirmationPage(driver);
    }

}
