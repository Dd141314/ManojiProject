package com.workpackages.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUI {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Properties prop;
	
	
	public void InvokeBrowser(String browserName, String urlKey){
		try {
			if(browserName.equalsIgnoreCase("Chrome")){
				System.setProperty("webdriver.chrome.driver","C:\\Users\\MANOJI\\workspace\\Java_Selenium\\Driver\\chromedriver.exe");
				driver =new ChromeDriver();
				if(prop==null){
					prop = new Properties();
				
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\workpackages\\properties\\projectConfig.properties");
				prop.load(file);
				}
			
			}else if(browserName.equalsIgnoreCase("Firefox")){
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\com\\workpackages\\driver\\geckodriver.exe");
				driver =new FirefoxDriver();
				if(prop==null){
					prop = new Properties();
				
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\workpackages\\properties\\projectConfig.properties");
				prop.load(file);
				}
			}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
				wait = new WebDriverWait(driver, 90); 
				driver.get(prop.getProperty(urlKey));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	

	
}
