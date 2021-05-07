package com.workpackages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.workpackages.Astraze_menu.Formfill;

public class Login extends BaseUI {
	
	@BeforeSuite
	public void Openmainspring(){
		InvokeBrowser("Chrome","url");
		
	}
	
	@Test(priority=1)
	public void mainspring(){
		
		
		try {
			
			
			//---------------Enter UserName for Login-------------------
			WebElement username= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='loginfmt']")));
			username.sendKeys("906830@cognizant.com");
			
			WebElement next=driver.findElement(By.id("idSIButton9"));
			next.click();
			
			//--------------Enter password for Login--------------------
			WebElement password= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='passwd' and @class='form-control input ext-input text-box ext-text-box']")));
			password.sendKeys("Rajamani@9955");
			password.click();
			
			WebElement submit=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9")));
			submit.click();
			
			//-----------------This Wait for OTP Verification-------------
			Thread.sleep(70000);
			
			
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
		
		@Test(priority=2)
		public void menu(){
			
			try {
				//-----------------Click on Menu on left-side-----------------
				WebElement leftmenu= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='left_menu_icon_overlay']")));
				leftmenu.click();
				
				//-----------------Click on AstraZe in Menu--------------------
				WebElement astra= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='projectIcon']/ul/li[1]/a")));
				astra.click();
				
				//-----------------Moving to Execute menu---------------------
				Thread.sleep(6000);
				WebElement execute = driver.findElement(By.xpath("//*[@id='LOCK_Execute']"));
				execute.click();
				
				//--------------------Select Workpackages in the Dropdown-------
				Thread.sleep(2000);
				WebElement workpackage= driver.findElement(By.xpath("//*[@id='LOCK_Workpackages' and @title='Workpackages']"));
				workpackage.click();
				
				//-----------------Click on New icon--------------------------
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='KEY_BUTTON_Add-btnIconEl' and @role='presentation']"))).click();
				
				//---------------------Switch to Frame--------------------
				WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='contentframe']")));
				driver.switchTo().frame(frame);
				
				
				//------------------Getting Title of the WebPage-----------------
				String title=driver.getTitle();
				System.out.println("The title of the page is : "+title);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		@Test(priority=3)
		public void callform(){
			Formfill fill = new Formfill();
			fill.AstraForm();
			
		}
		
		@AfterSuite
		public void quitBrowser() {
			driver.quit();
		}



}
