package franconnect;
import org.testng.annotations.Test;

import com.google.common.base.CharMatcher;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.seleniumemulation.*;

public class FcSky_17166_Sales {
  
	WebDriver driver;
	public String baseUrl;
	 
	  @Test
	  /*Verify the navigation from Home Widgets to Lead Summary page.
	   * Steps- 1. Go to Sales > Home > Click on Lead Counts of 'Sales Funnel'/'Dashboard' widget.
		Expected Result- It should redirect to the Lead Summary page with proper data.
	   */
	  public void myNewLeadCount() throws InterruptedException {
	   String redirectURL ="https://clusterdc.franconnect.net/fc/control/leadSummary";
	   driver.get(baseUrl);
	   System.out.println(driver.getTitle());
	   System.out.println("==============================");
	   driver.findElement(By.id("user_id")).sendKeys("adm");
	   driver.findElement(By.id("password")).sendKeys("t0n1ght");
	   driver.findElement(By.id("ulogin")).click();
	   driver.findElement(By.xpath(".//a[@original-title='Streamline Franchisee Recruitment and Manage Leads']")).click();
	  // driver.findElement(By.className("label5")).click();
	   driver.findElement(By.xpath(".//a[@original-title='Get Quick Insights into Recruitment Metrics']")).click();
	   WebElement newLeadCountElem = driver.findElement(By.xpath(".//div[@id='salesFunnelContent']//table/tbody/tr/td/table/tbody/tr[2]/td[1]/table/tbody/tr[2]/td[2]/a[2]"));
	   String newLeadCount = newLeadCountElem.getText();
	   System.out.println("LEAD COUNT  :"+ newLeadCount);
	   System.out.println("==============================");
	   newLeadCountElem.click();
	   
	   String getRedirectURL = driver.getCurrentUrl();
	   Assert.assertEquals(getRedirectURL, redirectURL);
	   
	   WebElement leadSummaryCountElem = driver.findElement(By.xpath(".//td[@id='pageid']"));
	   // WebElement leadSummaryCountElem = driver.findElement(By.xpath(".//span[@class='text_b']"));
	   String leadSummaryCount = leadSummaryCountElem.getText();
	   System.out.println("Lead Summary Count :"+ leadSummaryCount);
	   System.out.println("==============================");
	   
	  // int digit1 = leadSummaryCount.indexOf(" ",leadSummaryCount.indexOf("of"));
	  // int digit2 = leadSummaryCount.indexOf(" ",leadSummaryCount.indexOf("of")+1);
	   int digit1 = leadSummaryCount.indexOf("of");
	   int digit2 = leadSummaryCount.indexOf("|");
	   String data = leadSummaryCount.substring(digit1, digit2);
	  
	   
	  // String digits = CharMatcher.JAVA_DIGIT.retainFrom(leadSummaryCount);
	  String finalCount = CharMatcher.inRange('0', '9').retainFrom(data);
	   
	/*   final Pattern pattern = Pattern.compile("\\d+"); // the regex
	   final Matcher matcher = pattern.matcher(leadSummaryCount); // your string
	   final ArrayList<Integer> ints = new ArrayList<Integer>(); // results
	   while (matcher.find()) 
	   { // for each match
	       ints.add(Integer.parseInt(matcher.group())); // convert to int
	   }
	    
	*/ 
	
	   System.out.println(data);
	   System.out.println(finalCount);
	   //int rowCount = selenium.getXpathCount(".//table[@class='summaryTblex']").intValue();
	   
	   Assert.assertEquals(finalCount, newLeadCount);
	   
	   Thread.sleep(3000);
	   
	  
	  }
	  
	  
	  @BeforeTest
	  public void beforeTest() {
	   System.setProperty("webdriver.chrome.driver", "D:\\Franconnect_2018\\chromedriver_win32\\chromedriver.exe");
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
