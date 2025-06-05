package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PersonalDetailspage extends BasePage{


	public PersonalDetailspage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//span[text()='My Info']")
	  private WebElement MyInfo;
	
	@FindBy(xpath = "//input[@placeholder='First Name']")
	  private WebElement PersonalDetailFirstName;
	
    @FindBy(xpath = "//input[@placeholder='Middle Name']")
      private WebElement PersonalDetailMiddleName;
    
    @FindBy(xpath = "//input[@placeholder='Last Name']")
      private WebElement PersonalDetailLastName;
    
    @FindBy(xpath ="//label[text()='Nationality']/following::div[contains(@class,'oxd-select-text')][1]")
     private WebElement NationalityDropdown;
    
    @FindBy(xpath = "//div[@role='listbox']//span[text()='Indian']")
    private WebElement SelectIndian;
    
    @FindBy(xpath = "//label[text()='Female']")
    private WebElement femaleRadio;
    
    @FindBy(xpath = "//label[text()='Marital Status']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElement maritalStatusDropdown;

    @FindBy(xpath = "//div[@role='listbox']//span[text()='Single']")
    private WebElement maritalStatusSingle;
    
    @FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit'][normalize-space()='Save']")
    private WebElement savepersonaldetails;
    
    @FindBy(xpath="//div[@class='orangehrm-action-header']//following-sibling::button")
    private WebElement attachmentIcon;
    
    @FindBy(xpath ="//i[@class='oxd-icon bi-upload oxd-file-input-icon']")
    private WebElement browseAttachment;
    
    @FindBy(xpath = "//textarea[@placeholder='Type comment here']")
    private WebElement TypeComment;
    
    @FindBy(xpath ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[3]/button[2]")
    private WebElement saveAttachment;
    
    @FindBy(css = ".oxd-icon.bi-download")
    private WebElement downloadAttachment;
    
    @FindBy(xpath = "//button[@class='oxd-icon-button oxd-table-cell-action-space'][2]")
    private WebElement DeleteattachmentIcon;
    
    @FindBy(xpath = "//button[ text() = ' Yes, Delete ']")
    private WebElement DeleteAttachmentRecord;
 
    
    public void ClickMyInfo() {
        waitForVisibility(MyInfo);
        MyInfo.click();
}
    public void EnterFirstName(String first) {
    	waitForVisibility(PersonalDetailFirstName);
    	clickUsingJS(PersonalDetailFirstName);
    	waitForClickability(PersonalDetailFirstName);
    	PersonalDetailFirstName.clear();
    	PersonalDetailFirstName.sendKeys("B");
    	
    }
    public void EnterMiddleName(String middle ) {
    	waitForVisibility(PersonalDetailMiddleName);
    	waitForClickability(PersonalDetailMiddleName);
    	PersonalDetailMiddleName.click();
    	PersonalDetailMiddleName.clear();
    	PersonalDetailMiddleName.sendKeys("B");
    }
    public void EnterLastName(String lastname) {
    	waitForVisibility(PersonalDetailLastName);
    	waitForClickability(PersonalDetailLastName);
    	PersonalDetailLastName.click();
    	PersonalDetailLastName.clear();
    	PersonalDetailLastName.sendKeys("k");
    }
    public void enterPersonalDetails(String first, String middle, String lastname) throws InterruptedException {
    	EnterFirstName(first);
    	Thread.sleep(1000);
    	EnterMiddleName(middle);
    	Thread.sleep(1000);
    	EnterLastName(lastname);
    }
    public String getFirstName() {
        waitForVisibility(PersonalDetailFirstName);
        return PersonalDetailFirstName.getAttribute("value");
    }

    public void nationality() throws InterruptedException {
    	waitForVisibility(NationalityDropdown);
    	Thread.sleep(3000);
    	NationalityDropdown.click();
    	waitForVisibility(SelectIndian);
    	Thread.sleep(3000);
    	SelectIndian.click();
    	
    }
    public void gender() throws InterruptedException {
    	waitForVisibility(femaleRadio);
    	Thread.sleep(3000);
    	femaleRadio.click();
    	Thread.sleep(3000);
    	
    }
    public String getSelectedNationality() {
        waitForVisibility(NationalityDropdown);
        return NationalityDropdown.getText();  
    }
    

    public String getSelectedGender() {
        waitForVisibility(femaleRadio);
        if (femaleRadio.isSelected()) {
            return "Female";
        }
        return "Not selected";
    }
    
    public void MaritalStatus() throws InterruptedException {
        waitForClickability(maritalStatusDropdown);
        maritalStatusDropdown.click();
        Thread.sleep(3000);
        waitForVisibility(maritalStatusSingle);
        maritalStatusSingle.click();
        Thread.sleep(3000);
    }
    
    public void SavePersonalDetails() throws InterruptedException {
    	waitForVisibility(savepersonaldetails);
    	Thread.sleep(3000);
    	waitForClickability(savepersonaldetails);
    	savepersonaldetails.click();
    	Thread.sleep(3000);
    }
    
    public void AddAttachment() throws InterruptedException {
        waitForVisibility(attachmentIcon);
        Thread.sleep(1000);
        attachmentIcon.click();
        Thread.sleep(3000);
    }
    
    public void BrowseAttachment() throws InterruptedException {
        waitForVisibility(browseAttachment);
        browseAttachment.click();
        Thread.sleep(3000);
       
    }
    public void AttachmentComment() {
    	TypeComment.isEnabled();
    	//JavascriptExecutor js = (JavascriptExecutor)driver;
    	//js.executeScript("arguments[0].setAttribute('value','This is task 2 document')", TypeComment);
    	TypeComment.sendKeys("this is task 2 document file");
		
    	
    }
    public void SaveAttachment() throws InterruptedException {
    	waitForClickability(saveAttachment);
    	saveAttachment.click();
    	Thread.sleep(2000);
		
    }
    
    public void uploadAttachment() throws InterruptedException {
        AddAttachment(); 
        waitForVisibility(browseAttachment);
        Thread.sleep(3000);
        BrowseAttachment();
        Thread.sleep(2000); 

    }

    public boolean isFirstNameEditable() throws InterruptedException {
        waitForVisibility(PersonalDetailFirstName);
        Thread.sleep(2000);
        return PersonalDetailFirstName.isEnabled();
    }

    public boolean isMiddleNameEditable() throws InterruptedException {
        waitForVisibility(PersonalDetailMiddleName);
        Thread.sleep(2000);
        return PersonalDetailMiddleName.isEnabled();
    }

    public boolean isLastNameEditable() throws InterruptedException {
        waitForVisibility(PersonalDetailLastName);
        Thread.sleep(2000);
        return PersonalDetailLastName.isEnabled();
    }
    public void uploadAttachmentWithRobot(String filepath) throws InterruptedException, AWTException {
    // Copy the filepath to clipboard
    StringSelection filepathselection = new StringSelection(filepath);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathselection, null);

    Robot robot = new Robot();
    robot.setAutoDelay(1000);
    
    // (Ctrl + V)
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    Thread.sleep(2000); 

    //Enter to confirm the selection
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(2000); 
}
    
    public void downloadattachment() throws InterruptedException  {
    	waitForVisibility(downloadAttachment);
    	downloadAttachment.click();
    	waitForClickability(downloadAttachment);
    	Thread.sleep(3000);
    	
    }
    
    public void deleteAttachmentIcon() throws InterruptedException {
        //waitForVisibility(DeleteattachmentIcon);
       // waitForClickability(DeleteattachmentIcon);
    	clickUsingJS(DeleteattachmentIcon);
        Thread.sleep(2000);
    }

    public void DeleteAttachmentRecord() throws InterruptedException {
        clickUsingJS(DeleteAttachmentRecord);
        Thread.sleep(2000);
    }

    public void DeleteAttachment() throws InterruptedException {
    	deleteAttachmentIcon();
    	Thread.sleep(2000);
    	DeleteAttachmentRecord();
    	Thread.sleep(2000);
    	
    	
    }
    
}
  
    
