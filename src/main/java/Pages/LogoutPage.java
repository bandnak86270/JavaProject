package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{

	public LogoutPage(WebDriver driver) {
		super(driver);
		
	}
	 @FindBy(xpath = "//*[@class='oxd-userdropdown-name']")
	    private WebElement Userprofile;
	 @FindBy(xpath ="//a[text()='Logout']")
	   private WebElement logoutButton;
	 
	 
	 public void userProfile() {
		 waitForVisibility(Userprofile);
         Userprofile.isDisplayed();
         Userprofile.click();
	 }
	 public void Logout() {
		 logoutButton.click();
	 }
	 
	 public boolean IsLogoutOptionDisplayed() {
		 waitForVisibility(logoutButton);
		 return logoutButton.isDisplayed();
	 }
	 
	 public void logoutfromApplication() throws InterruptedException {
		 userProfile();
		 Thread.sleep(3000);
		 Logout();
		 Thread.sleep(3000);
	 }
	 
	
	

}
