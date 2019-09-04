package BasePackeage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	
	 static WebDriver driver;
	 static Properties prop;
	 
	 public void TestBase() throws IOException {
		 try {
			 
			 prop=new Properties();
			 FileInputStream FIS= new FileInputStream("C:\\Users\\Spectrum\\Desktop\\JAVA PRACTICE\\Pom\\src\\main\\java\\Com\\crm\\Config\\config.properties");
			 prop.load(FIS);
		 }
		 catch(FileNotFoundException e) {
			 e.printStackTrace();
			  }
		 catch(IOException e) {
			 e.printStackTrace();
		 }
		 
	 }
	 
	 // we must initialize method
	 public  void Initialize() {
		String Browsername=	prop.getProperty("bowser");
		
		if(Browsername.equals("chrome")){
			System.setProperty("WebDriver.chrome.driver", "C:\\Drivers for Selenium\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (Browsername.equals("FF")) {
			System.setProperty("WebDriver.gecko.driver", "C:\\Drivers for Selenium\\geckodriver");
			driver= new FirefoxDriver();
		}
		 		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 driver.get(prop.getProperty("URL"));
	 }
public void main(String[]args) throws Throwable {
	TestBase TB= new TestBase();
	TB.TestBase();
	TB.Initialize();
}
}
