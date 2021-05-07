package com.workpackages.base;

import java.util.Vector;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.workpacakges.readexcel.ReadExcel;


public class Login extends BaseUI {
	
	WebElement entername, typedrop, lifedrop, taskmanage, technology, umosize, adqualifier, responsibility, cadets,
	startDate, endDate;

	
	@BeforeSuite
	public void Openmainspring(){
		InvokeBrowser("Firefox","url");
		
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
			System.out.println("Checking priority execution 2 count 1");

			try {
				//-----------------Click on Menu on left-side-----------------
				WebElement leftmenu= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='left_menu_icon_overlay']")));
				leftmenu.click();

				System.out.println("Checking priority execution 2 count 5");

				//-----------------Click on AstraZe in Menu--------------------
				WebElement astra= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='projectIcon']/ul/li[1]/a")));
				astra.click();
				System.out.println("Checking priority execution 2 count 4");
				
//				//-----------------Moving to Execute menu---------------------
//				Thread.sleep(6000);
//				WebElement execute = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='LOCK_Execute']")));
//				execute.click();
//				
//				System.out.println("Checking priority execution 2");
//				//--------------------Select Workpackages in the Dropdown-------
//				Thread.sleep(2000);
//				WebElement workpackage= driver.findElement(By.xpath("//*[@id='LOCK_Workpackages' and @title='Workpackages']"));
//				workpackage.click();
//				
//				System.out.println("Checking priority execution 2 count 2");
//				//-----------------Click on New icon--------------------------
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='KEY_BUTTON_Add-btnIconEl' and @role='presentation']"))).click();
//				
//				//---------------------Switch to Frame--------------------
//				WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='contentframe']")));
//				driver.switchTo().frame(frame);
//				System.out.println("Checking priority execution 2 count 3");

				//------------------Getting Title of the WebPage-----------------
				String title=driver.getTitle();
				System.out.println("The title of the page is : "+title);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		@SuppressWarnings({"rawtypes","unused"})
		@Test(priority=3)
		public void AstraForm() {
			ReadExcel obj = new ReadExcel();
			System.out.println("Test in the");
			try {

				Vector dataHolderSheet = obj.readExcelFile();
				for (int rowIndex = 1; rowIndex < dataHolderSheet.size(); rowIndex++) {
					System.out.println("Test in the for loop");
					int j = 0;
					String userName = "";
					String password = "";
					String Lifecycle = "";
					String tasks="";
					String Tech="";
					String umo="";
					String ad="";
					String respons="";
					String cadet="";
					String sdate="";
					String edate="";

					Vector cellStoreVector = (Vector) dataHolderSheet.elementAt(rowIndex);
					XSSFCell iuserName = (XSSFCell) cellStoreVector.elementAt(j++);
					userName = iuserName.toString().trim();
					
					XSSFCell ipassword = (XSSFCell) cellStoreVector.elementAt(j++);
					password = ipassword.toString().trim();
				
					XSSFCell ilyfecycle = (XSSFCell) cellStoreVector.elementAt(j++);
					Lifecycle = ilyfecycle.toString().trim();
					
					XSSFCell itasks = (XSSFCell) cellStoreVector.elementAt(j++);
					tasks = tasks.toString().trim();
					
					XSSFCell iTech = (XSSFCell) cellStoreVector.elementAt(j++);
					Tech = iTech.toString().trim();
					
					XSSFCell iumo = (XSSFCell) cellStoreVector.elementAt(j++);
					umo = iumo.toString().trim();
					
					XSSFCell iad = (XSSFCell) cellStoreVector.elementAt(j++);
					ad = iad.toString().trim();
					
					XSSFCell irespons = (XSSFCell) cellStoreVector.elementAt(j++);
					respons = irespons.toString().trim();
					
					XSSFCell icadet = (XSSFCell) cellStoreVector.elementAt(j++);
					cadet = irespons.toString().trim();
					
					XSSFCell isdate = (XSSFCell) cellStoreVector.elementAt(j++);
					sdate = isdate.toString().trim();
					
					XSSFCell iedate = (XSSFCell) cellStoreVector.elementAt(j++);
					edate = iedate.toString().trim();
					
					System.out.println(userName);
					
					//-----------------Moving to Execute menu---------------------
					Thread.sleep(6000);
//					WebElement element = driver.findElement(By.xpath("//*[@id='loadDiv' and @class='loadingDiv']"));
//					driver.("arguments[0].style.visibility='hidden'", element)
//					 Select tasks1 = new Select(element);
//					 tasks1.selectByVisibleText(" Microsoft Project Client ");

					 //WebElement execute = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='LOCK_Execute']")));
					//execute.click();
					
					 WebElement execute = driver.findElement(By.xpath("//*[@id='LOCK_Execute']"));
					 wait.until(ExpectedConditions.elementToBeClickable (execute));
					 //execute.click();

					
					System.out.println("Checking priority execution 2");
					//--------------------Select Workpackages in the Dropdown-------
					Thread.sleep(2000);
//					WebElement workpackage= driver.findElement(By.xpath("//*[@id='LOCK_Workpackages' and @title='Workpackages']"));
//					workpackage.click();
					
					WebElement element = driver.findElement(By.xpath("//*[@id='LOCK_Workpackages' and @title='Workpackages']"));
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].click();", element);

					
					System.out.println("Checking priority execution 2 count 2");
					//-----------------Click on New icon--------------------------
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='KEY_BUTTON_Add-btnIconEl' and @role='presentation']"))).click();
					
					//---------------------Switch to Frame--------------------
					WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='contentframe']")));
					driver.switchTo().frame(frame);
					System.out.println("Checking priority execution 2 count 3");

					// ---------------Entering data to Name-----------------------
					entername = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='CM_Name']")));
					entername.sendKeys((String)userName);

					// ----------select on workpackages type TextBox DropDown------
					typedrop = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"field200\"]")));
					Select proman = new Select(typedrop);
					proman.selectByVisibleText((String)password);

					// ------------click on CheckBox is applicable-----------------
					//driver.findElement(By.xpath("//input[@id='field189' and @type='checkbox']")).click();

					// -----------Select on LifeCycle Phase TextBox DropDown--------
					lifedrop = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='field191' and @name='field191']")));
					Select lifecycle = new Select(lifedrop);
					lifecycle.selectByVisibleText(Lifecycle);

					// -----------Select on LifeCycle Phase TextBox DropDown--------
					taskmanage = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.id("isPackageDigiteStart")));
					Select task = new Select(taskmanage);
					task.selectByVisibleText(tasks);

					// ----------------Scroll down--------------------
					//JavascriptExecutor js = (JavascriptExecutor) driver;
					//js.executeScript("window.scrollBy(0,10)");

					// --------Selecting technology TextBox DropDown--------
					technology = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='field172']")));
					Select tech = new Select(technology);
					tech.selectByVisibleText(Tech);

					// --------Selecting UMO Size TextBox DropDown--------
					umosize = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='field190']")));
					Select umos = new Select(umosize);
					umos.selectByVisibleText(umo);

					// --------Selecting AD Qualifier TextBox DropDown--------
					adqualifier = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='field168']")));
					Select ads = new Select(adqualifier);
					ads.selectByVisibleText(ad);

					// --------Selecting AD Qualifier TextBox DropDown--------
					responsibility = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='field193']")));
					Select resp = new Select(responsibility);
					resp.selectByVisibleText(respons);

					// -----------Select CADET Integration Applicability TextBox
					// DropDown----------
					cadets = wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//select[@id='field120' and @name='field120']")));
					Select cad = new Select(cadets);
					cad.selectByVisibleText(cadet);

					// -----------Select Start Date Integration Applicability
					// TextBox DropDown----------
					startDate = wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//input[@id='field2' and @name='field2']")));
					startDate.sendKeys(sdate);

					// -----------Select End Date Integration Applicability TextBox
					// DropDown----------
					endDate = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='CM_DUEDATE']")));
					endDate.sendKeys(edate);
					// -----------Select Save Button------------------
					driver.findElement(By.xpath("//*[@id='SaveBtn' or @name='SaveBtn']")).click();
					Thread.sleep(7000);

				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		
		@AfterSuite
		public void quitBrowser() {
			driver.quit();
		}



}
