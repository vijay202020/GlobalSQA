package submitForm;

import Pages.ConfirmationPage;
import Pages.FormPage;
import base.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class newFormTest extends baseTest {


    @Test
    public void completenewformtest() {
         FormPage formPage = baseTest.setDriver();

//use sample data(both valid & non valid data)
        formPage.uploadProfile(Directory+"\\resources\\sample.png");
        formPage.setName("");
        formPage.setEmail("email");
        formPage.setWebsite(Website);
        formPage.setExperience(Experience);         //this data should not be hard coded for script flexibility and maintenance
        formPage.setEducation(Education);           //this data should not be hard coded for script flexibility and maintenance
        formPage.setExpertise(Expertise);           //this data should not be hard coded for script flexibility and maintenance
        formPage.clickAlertButton();
        formPage.setComments("");

//fix form with acceptable data for each mandatory field validations
        formPage.setName(NameFix);
        formPage.clickSubmitButton();
        formPage.setEmail(EmailFix);
        formPage.clickSubmitButton();
        formPage.setComments(CommentFix);
        ConfirmationPage confirmationPage = formPage.clickSubmitButton();

//using assert functions verify the form details return test results
        assertTrue(confirmationPage.confirmformDetails()
                .contains(Experience));
        assertTrue(confirmationPage.confirmformDetails()
                .contains(Education));
        assertTrue(confirmationPage.confirmformDetails()
                .contains(Expertise));
        assertTrue(confirmationPage.confirmformDetails()
                .contains(NameFix));
    }

    @Test
    public void completenewformtestsecond() {
        FormPage formPage1 = baseTest.setDriver();

//use sample data(both valid & non valid data)
        formPage1.uploadProfile(Directory+"\\resources\\sample.png");
        formPage1.setName("");
        formPage1.setEmail("email");
        formPage1.setWebsite(Website);
        formPage1.setExperience(Experience);    //this data should not be hard coded for script flexibility and maintenance
        formPage1.setEducation(Education);      //this data should not be hard coded for script flexibility and maintenance
        formPage1.setExpertise(Expertise);      //this data should not be hard coded for script flexibility and maintenance
        formPage1.clickAlertButton();
        formPage1.setComments("");

//fix form with acceptable data for each mandatory field validations
        formPage1.setName(NameFix);
        formPage1.clickSubmitButton();
        formPage1.setEmail(EmailFix);
        formPage1.setComments(CommentFix);
        ConfirmationPage confirmationPage = formPage1.clickSubmitButton();

//using assert functions verify the form details return test results
        assertTrue(confirmationPage.confirmformDetails()
                .contains(Experience));
        assertTrue(confirmationPage.confirmformDetails()
                .contains(Education));
        assertTrue(confirmationPage.confirmformDetails()
                .contains(Expertise));
        assertTrue(confirmationPage.confirmformDetails()
                .contains(NameFix));
    }
 }
