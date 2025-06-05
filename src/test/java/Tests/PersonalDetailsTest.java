package Tests;


import java.awt.AWTException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.Loginpage;
import Pages.PersonalDetailspage;
import TestBase.BaseTest;

public class PersonalDetailsTest extends BaseTest{
	private PersonalDetailspage personaldetails;

    @BeforeClass
    
    public void loginToApplication() throws InterruptedException {
        Loginpage loginPage = new Loginpage(driver);
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed: User profile not visible.");
        personaldetails = new PersonalDetailspage(driver);
    }
    @Test(priority = 1)
    public void PersonalDetailFieldsAreEditable() throws InterruptedException {
        personaldetails.ClickMyInfo();

        boolean isFirstNameEditable = personaldetails.isFirstNameEditable();
        Assert.assertTrue(isFirstNameEditable, "First Name field should be editable.");

        boolean isMiddleNameEditable = personaldetails.isMiddleNameEditable();
        Assert.assertTrue(isMiddleNameEditable, "Middle Name field should be editable.");

        boolean isLastNameEditable = personaldetails.isLastNameEditable();
        Assert.assertTrue(isLastNameEditable, "Last Name field should be editable.");
    }
    @Test(priority = 2)
    public void UpdatePersonalDetails() throws InterruptedException {
    	SoftAssert softAssert = new SoftAssert();
    	personaldetails.ClickMyInfo();
    	Thread.sleep(2000);
    	personaldetails.enterPersonalDetails("B", "B", "k");
    	String actualFirstName = personaldetails.getFirstName();
        softAssert.assertEquals(actualFirstName, "B", "First name update failed.");
        personaldetails.nationality();
    	String selectedNationality = personaldetails.getSelectedNationality();
        softAssert.assertEquals(selectedNationality, "Indian", "Nationality selection failed.");
        personaldetails.gender();
        personaldetails.MaritalStatus();      
        personaldetails.SavePersonalDetails();
        Thread.sleep(3000);      
        softAssert.assertAll();
    }
    
    
    @Test(priority = 3)
    public void UploadAttachment() throws InterruptedException, AWTException {
    	personaldetails.ClickMyInfo();               
    	personaldetails.uploadAttachment();
    	Thread.sleep(3000);
        String filePath = "C:\\eclipse\\OrngeHRM\\src\\test\\resources\\files\\Task 2.docx";
        personaldetails.uploadAttachmentWithRobot(filePath);
        Thread.sleep(3000);
        personaldetails.AttachmentComment();
        Thread.sleep(2000);
        Assert.assertTrue(true,"comment added successfully");
        personaldetails.SaveAttachment();
        Thread.sleep(3000);
        Assert.assertTrue(true,"saved successfully");
        
    }
    
    @Test(priority=4)
    public void DownloadAttachment() throws InterruptedException {
    	personaldetails.downloadattachment();
    	Thread.sleep(3000);    	
    	Assert.assertTrue(true,"attachment downloaded successfully");
    }
    
    @Test(priority = 5)
    public void DeleteAttachment() throws InterruptedException {
    	personaldetails.DeleteAttachment();
    	Thread.sleep(2000);
    	Assert.assertTrue(true,"Successfully deleted");
    
    
    }
}


    