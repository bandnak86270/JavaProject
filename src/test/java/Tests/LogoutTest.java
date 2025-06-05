package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.Loginpage;
import Pages.LogoutPage;
import TestBase.BaseTest;

public class LogoutTest extends BaseTest {
	private LogoutPage logout;
	
	@BeforeClass
	public void loginToApplication() throws InterruptedException {
        Loginpage loginPage = new Loginpage(driver);
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed: User profile not visible.");
        logout = new LogoutPage(driver);
    }
	
	@Test(priority=1)
	public void verifyLogoutButtonVisibility() {
		logout.userProfile();
		Assert.assertTrue(logout.IsLogoutOptionDisplayed(), "logout button is not visible");
		
	}
	
	@Test(priority=2)
	public void logoutfromApplication() throws InterruptedException {
		logout.logoutfromApplication();
		//Assert.assertTrue(driver.getCurrentUrl().contains("/auth/login"), "successfully logout from the application");
		Loginpage loginpage = new Loginpage(driver);
		Assert.assertTrue(loginpage.IsAtloginPage(), "user should not access login page after logout");
		
	}
	

}
