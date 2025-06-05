package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Loginpage;
import TestBase.BaseTest;

public class LoginTest extends BaseTest{
		
		@Test(priority=1)
		public void testloginWithInvalidCredentials() throws InterruptedException {
			Loginpage loginpage = new Loginpage(driver);
			loginpage.login("wrongusername", "admin");
			Assert.assertTrue(loginpage.isLoginFailed(),"login should be fail");
			Thread.sleep(2000);
			Assert.assertFalse(driver.getCurrentUrl().contains("/dashboard"), "Login should fail with invalid credentials.");

	}
		@Test(priority = 2)
		public void testLoginWithInvalidPassword() throws InterruptedException {
			Loginpage loginpage = new Loginpage(driver);
	        loginpage.login(prop.getProperty("username"), "admin");
	        Assert.assertTrue(loginpage.isLoginFailed(), "Login should fail with invalid password");
	    }
		
		@Test(priority = 3)
		public void testLoginWithInvalidUserName() throws InterruptedException {
			Loginpage loginpage = new Loginpage(driver);
			loginpage.login("bandna", "kumari");
			Assert.assertTrue(loginpage.isLoginFailed(),"Login should be fail with invalid username");
			
		}
		@Test(priority = 4)
		public void testloginWithValidCredentials() throws InterruptedException {
			Loginpage loginpage = new Loginpage(driver);
			loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

			Assert.assertTrue(loginpage.isLoginSuccessful(),"login should be successful");
			Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"),"login is successfull");	
			
		}
		
			
		}
		


