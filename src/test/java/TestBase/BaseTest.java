package TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;
	protected WebDriverWait Wait;
	protected Properties prop;
	
	@BeforeClass
	public void intialization() throws IOException {
		prop = new Properties();
		String filepath = System.getProperty("user.dir")+"/src/main/java/Configurations/config.properties";
		FileInputStream path = new FileInputStream(filepath);
		prop.load(path);
		System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\OrngeHRM\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	@AfterClass
	public void terminate() {
		driver.quit();
	}

}
