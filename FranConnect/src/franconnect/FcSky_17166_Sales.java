import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FcSky_17166_Sales {
  
	WebDriver driver;
	public String baseUrl;
	 
	  @Test
	  public void f() throws InterruptedException {
	   
	   driver.get(baseUrl);

	  
	  }
	  
	  
	  @BeforeTest
	  public void beforeTest() {
	   System.setProperty("webdriver.chrome.driver", "D:\\Automation\\2018_Automation\\chromedriver_win32\\chromedriver.exe");
	   driver = new ChromeDriver();
	   baseUrl = "https://clusterdc.franconnect.net/fc/";
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	  }
	  
	  
	  @AfterTest
	  public void afterTest() {
	  driver.close();
	  }
	
		
}
