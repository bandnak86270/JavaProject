package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhotographPage extends BasePage {

    public PhotographPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfo;

    @FindBy(xpath = "//*[@class='orangehrm-edit-employee-image']//img")
    public WebElement profilePicture;

    @FindBy(xpath = "//*[@type='button']//following::i[4]")
    private WebElement uploadProfilePictureButton;

    @FindBy(css = "button[type='submit']")
    private WebElement saveProfilePictureButton;
    
    @FindBy(xpath = "//span[text()='File type not allowed']")
    private WebElement UnsupportedfileFormat;
    
    @FindBy(xpath = "//span[text()='Attachment Size Exceeded']")
    private WebElement AttachmentsizeExceeded;

    public void clickMyInfo() {
        waitForVisibility(myInfo);
        myInfo.click();
    }

    public void clickProfilePicture() {
        waitForClickability(profilePicture);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", profilePicture);
    }

    public void clickUploadProfilePicture() {
        waitForClickability(uploadProfilePictureButton);
        uploadProfilePictureButton.click();
    }

    public void clickSaveProfilePicture() {
        ScrollingToElement(saveProfilePictureButton);
        waitForClickability(saveProfilePictureButton);
        saveProfilePictureButton.click();
    }

    public void changeProfilePicture() {
        clickProfilePicture();
        clickUploadProfilePicture();
    }
    
    public boolean UnsupportedFileFormat() {
  	  waitForVisibility(UnsupportedfileFormat);
		  return UnsupportedfileFormat.isDisplayed();
  	  
    }
    public boolean AttachmentSizeExceeded() {
    	  waitForVisibility(AttachmentsizeExceeded);
  		  return AttachmentsizeExceeded.isDisplayed();
    	  
      }
    
    public void uploadFileWithRobot(String filePath) throws AWTException, InterruptedException {
        // Copy file path to clipboard
        StringSelection filePathSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);

        Robot robot = new Robot();
        robot.setAutoDelay(1000);

        // Paste clipboard content (Ctrl + V)
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(2000); 

        // Press Enter to confirm file selection
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(2000); 
    }
    
    public String getProfilePictureSrc() {
    	waitForVisibility(profilePicture);
    	return profilePicture.getAttribute("src");
    }
}
