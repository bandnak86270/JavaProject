package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class Loginpage extends BasePage {
    
	public Loginpage(WebDriver driver) {
		super(driver);
	}
	@FindBy(name = "username")
    private WebElement usernamefield;
    
    @FindBy(name = "password")
    private WebElement passwordfield;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    
    @FindBy(xpath = "//*[@class='oxd-userdropdown-name']")
    private WebElement Userprofile;
    
    @FindBy(xpath = "//p[text()='Invalid credentials']")
    private WebElement errorMsg;
    
    public void enterUsername(String user) {
        waitForVisibility(usernamefield);
        usernamefield.clear();
        usernamefield.sendKeys(user);
    }
    public void enterpassword(String pass) {
    	waitForVisibility(passwordfield);
    	passwordfield.clear();
    	passwordfield.sendKeys(pass);
    	
    }
    public void clickloginButton() throws InterruptedException {
    	waitForVisibility(loginButton);
    	Thread.sleep(3000);    	
    	loginButton.click();
    }
    public void login(String user, String pass) throws InterruptedException {
    	enterUsername(user);
    	enterpassword(pass);
    	clickloginButton();
    }
    
    public boolean isLoginSuccessful() {
        try {
            waitForVisibility(Userprofile);
            return Userprofile.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isLoginFailed() {
        try {
            waitForVisibility(errorMsg);
            return errorMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
}
    public boolean IsAtloginPage() {
    	waitForVisibility(usernamefield);
    	return usernamefield.isDisplayed();
    }
}

