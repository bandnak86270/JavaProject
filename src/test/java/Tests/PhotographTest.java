package Tests;

import java.awt.AWTException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.Loginpage;
import Pages.LogoutPage;
import Pages.PhotographPage;
import TestBase.BaseTest;

public class PhotographTest extends BaseTest {
    private PhotographPage photograph;

    @BeforeClass
    public void loginToApplication() throws InterruptedException {
        Loginpage loginPage = new Loginpage(driver);
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed: User profile not visible.");
        photograph = new PhotographPage(driver);
    }

    @Test(priority = 1)
    public void testProfilePictureUploadWithUnsupportedFormat() throws AWTException, InterruptedException {
    	photograph.clickMyInfo();
    	photograph.changeProfilePicture();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	String unsupportedfilepath = "C:\\eclipse\\OrngeHRM\\src\\test\\resources\\images\\arpnaa.pdf";
    	photograph.uploadFileWithRobot(unsupportedfilepath);
    	Thread.sleep(2000);
    	Assert.assertTrue(photograph.UnsupportedFileFormat(),"Error message displayed : File Type Not Allowed");
    	
	
    }
    @Test(priority=2)
    public void testProfilePictureUploadWithExceededSize() throws AWTException, InterruptedException {
    	photograph.clickMyInfo();
    	photograph.changeProfilePicture();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	String ExccededAttachmnetfilePath = "C:\\eclipse\\OrngeHRM\\src\\test\\resources\\images\\IMG_20220911_142943.jpg";
    	photograph.uploadFileWithRobot(ExccededAttachmnetfilePath);
    	Thread.sleep(3000);
    	Assert.assertTrue(photograph.AttachmentSizeExceeded(),"Error message displayed:  Attachment size Exceeded" );
    }
    @Test(priority = 3 )
    public void testProfilePictureUpload() throws InterruptedException, AWTException {
        photograph.clickMyInfo();
        photograph.changeProfilePicture();
        Thread.sleep(4000);  
        String filePath = "C:\\eclipse\\OrngeHRM\\src\\test\\resources\\images\\IMG-20241027-WA0016.jpg";
        
        // Use Robot to paste file path and press Enter
        photograph.uploadFileWithRobot(filePath);
        Thread.sleep(3000);
        
        photograph.clickSaveProfilePicture();
        Thread.sleep(3000);
        Assert.assertTrue(photograph.profilePicture.isDisplayed(),"profilepicture uploaded successfully");
        
    }
    
    @Test(priority=4)
    	public void testProfilePicturePersistsAfterRelogin() throws InterruptedException {
    	 photograph.clickMyInfo();
    	 String BeforeSrc = photograph.getProfilePictureSrc();
    	 System.out.println("BeforeSrc: " + BeforeSrc);
    	 
    	 LogoutPage logout = new LogoutPage(driver);
    	 logout.userProfile();
    	 Thread.sleep(3000);
    	 logout.Logout();
    	 Thread.sleep(2000);
    	 
    	 //Login again
    	 Loginpage loginPage = new Loginpage(driver);
         loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
         Thread.sleep(2000);
         Assert.assertTrue(loginPage.isLoginSuccessful(), "Re-login failed.");
         
         photograph.clickMyInfo();
         String afterSrc = photograph.getProfilePictureSrc();
         System.out.println("afterloginSrc: " + afterSrc);
         Assert.assertEquals(afterSrc, BeforeSrc, "Profile picture did not persist after relogin.");
    }
    			 
    		
    	}
    

