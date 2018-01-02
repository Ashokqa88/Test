package caf.Execution;
/*
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;*/

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArchiveData {

	/*// Launch Android App
	public AndroidDriver<AndroidElement> androidAppLunch(int TSrow) throws InterruptedException, MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, pvts("DeviceName" + TSrow));
		cap.setCapability(AndroidMobileCapabilityType.PLATFORM, pvts("OS" + TSrow));
		cap.setCapability("udid", pvts("Udid" + TSrow));
		cap.setCapability("appPackage", pvc(TSrow, "appPackage"));
		cap.setCapability("appActivity", pvc(TSrow, "appActivity"));
		String p = TSrow + port;
		System.out.println("launchApp : port is :" + p);

		aDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:" + p + "/wd/hub"), cap);
		return aDriver;
	}*/

	
	/*// Launch iOS App
	public IOSDriver<IOSElement> iosAppLunch(int TSrow) throws InterruptedException, MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(AndroidMobileCapabilityType.PLATFORM, pvts("OS" + TSrow));
		cap.setCapability("platformName", pvts("OS" + TSrow));
		cap.setCapability(CapabilityType.PLATFORM, "Mac");
		cap.setCapability("automationName", "XCUITest");
		cap.setCapability("xcodeOrgId", pvc(TSrow, "xcodeOrgId"));
		cap.setCapability("xcodeSigningId", pvc(TSrow, "xcodeSigningId"));
		cap.setCapability("deviceName", pvts("DeviceName" + TSrow));

		cap.setCapability("udid", pvts("Udid" + TSrow));
		cap.setCapability("bundleId", pvc(TSrow, "bundleId"));

		String p = TSrow + port;
		System.out.println("launchApp : port is :" + p);

		iDriver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:" + p + "/wd/hub"), cap);
		return iDriver;
	}*/
	
	/*public void startServer2() throws InterruptedException, ExecuteException, IOException {
	int port1 = (int) Float.parseFloat(port);

	service = AppiumDriverLocalService
			.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
					.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
					.withIPAddress("127.0.0.1").usingPort(port1));
	service.start();
	if (service.isRunning())
		System.out.println("Appium server started successfully");
	System.err.println("Executing");

	Thread.sleep(5000);
}*/
	
/*	public void startServer(int TSrow) {

		// Set Capabilities
		//cap = new DesiredCapabilities();
		// cap.setCapability("noReset", "true");

		// Build the Appium service
		builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		String p = TSrow + port;
		int port1 = (int) Float.parseFloat(p);
		builder.usingPort(port1);
		//builder.withCapabilities(cap);
		//builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

		System.out.println("startServer : port is :" + port);

		// Start the server with the builder
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
		
		
		
		 * System.out.
		 * println("info : String logs if the server has been run. null is returned otherwise. -- :: "
		 * + service.getStdOut());
		 * System.out.println("Appium running service hashcode  : " +
		 * service.hashCode()); System.out.println("Appium server running ? " +
		 * service.isRunning()); System.out.println("Appium running url is : " +
		 * service.getUrl()); System.out.println("Appium service class is : " +
		 * service.getClass());
		 

	}*/
	
/*	public void startServer(int TSrow) {

		String p = TSrow + port;
		int port1 = (int) Float.parseFloat(p);
service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
						.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
						.withIPAddress("127.0.0.1").usingPort(port1));
		service.start();
		if (service.isRunning())
			System.out.println("Appium server started successfully");
		System.err.println("Executing");
		
		 * System.out.
		 * println("info : String logs if the server has been run. null is returned otherwise. -- :: "
		 * + service.getStdOut());
		 * System.out.println("Appium running service hashcode  : " +
		 * service.hashCode()); System.out.println("Appium server running ? " +
		 * service.isRunning()); System.out.println("Appium running url is : " +
		 * service.getUrl()); System.out.println("Appium service class is : " +
		 * service.getClass());
		 

	}
*/
	/*public IOSDriver<IOSElement> iosAppiumSetup(int TSrow) throws InterruptedException, MalformedURLException {

		File ipa = new File(appDir, pvts("Merchant" + TSrow) + ".ipa");
		System.out.println("APP name is : " + pvts("Merchant" + TSrow) + ".ipa");

		DesiredCapabilities cap = new DesiredCapabilities();
		// cap.setCapability(MobileCapabxilityType.NEW_COMMAND_TIMEOUT, "2000");
		cap.setCapability("platformName", pvts("OS" + TSrow));
		// cap.setCapability(CapabilityType.PLATFORM, "Mac");
		cap.setCapability("automationName", "XCUITest");
		cap.setCapability("xcodeOrgId", pvc(TSrow, "xcodeOrgId"));
		cap.setCapability("xcodeSigningId", pvc(TSrow, "xcodeSigningId"));
		cap.setCapability("deviceName", pvts("DeviceName" + TSrow));
		cap.setCapability("platformVersion", pvts("platformVersion" + TSrow));
		// cap.setCapability("wdaLocalPort", port);
		// useNewWDA true
		cap.setCapability(MobileCapabilityType.FULL_RESET, true);

		cap.setCapability("udid", pvts("Udid" + TSrow));
		cap.setCapability("bundleId", pvc(TSrow, "bundleId"));
		cap.setCapability("app", ipa.getAbsolutePath());
		String p = TSrow + port;
		System.out.println("appInstall - port is :" + p);
		iDriver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:" + p + "/wd/hub"), cap);
		return iDriver;

	}
*//*
	public void startServer(int TSrow) {

		// Set Capabilities
		cap = new DesiredCapabilities();
		// cap.setCapability("noReset", "true");
		cap.setCapability("udid", pvts("Udid" + TSrow));
		// cap.setCapability("deviceName", pvts("DeviceName" + TSrow));
		cap.setCapability("clearSystemFiles", true);
		// Build the Appium service
		String p = TSrow + port;
		int port1 = (int) Float.parseFloat(p);
		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
						.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
						.withCapabilities(cap).withIPAddress("127.0.0.1").usingPort(port1));
		service.start();
		if (service.isRunning())
			System.out.println("Appium server started successfully");
		System.err.println("Executing");

		
		 * System.out.
		 * println("info : String logs if the server has been run. null is returned otherwise. -- :: "
		 * + service.getStdOut());
		 * System.out.println("Appium running service hashcode  : " +
		 * service.hashCode()); System.out.println("Appium server running ? " +
		 * service.isRunning()); System.out.println("Appium running url is : " +
		 * service.getUrl()); System.out.println("Appium service class is : " +
		 * service.getClass());
	}*/
	/*public void takeScreenShot(int TSrow, String status_pass_fail, String TestCase_id_name_description)
	throws WebDriverException, IOException {
File scrFile = null;

String folder_name = pvPaths("ScreenshotsPath") + pvts("Merchant" + TSrow) + "_" + pvts("OS" + TSrow) + "_"
		+ pvts("Version" + TSrow) + "_" + status_pass_fail;

// Capture screenshot.
if (getOS(TSrow).equals("Android")) {
	scrFile = ((TakesScreenshot) aDriver).getScreenshotAs(OutputType.FILE);
} else if (getOS(TSrow).equals("iOS")) {
	scrFile = ((TakesScreenshot) iDriver).getScreenshotAs(OutputType.FILE);

}
// Set date format to set It as screenshot file name.
SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
// Create folder under project with name "screenshots" provided to
// destDir.
new File(folder_name).mkdirs();
// Set file name using current date time.
String file_name = TestCase_id_name_description + dateFormat.format(new Date()) + ".jpeg";

try {
	// Copy paste file at destination folder location
	FileUtils.copyFile(scrFile, new File(folder_name + "/" + file_name));
} catch (IOException e) {
	e.printStackTrace();
}
}*/
	
	/*

	// find by id or xpath by passing from property file
	public WebElement waitForElement(String locator) throws IOException {
		WebElement Element = null;
		String locator_key = pvl(locator);
		System.out.println("locakator key is :" + locator + " locator is : " + locator_key);
		if (super.getOS().equals("Android")) {
			WebDriverWait wait = new WebDriverWait(aDriver, waitTime);
			if (locator_key.contains("@")) {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator_key)));
				} catch (Exception e) {
					System.out.println("locator not found and locator is : " + locator_key);
				}
				Element = aDriver.findElementByXPath(locator_key);

			} else {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator_key)));
				} catch (Exception e) {
					System.out.println("locator not found and locator is : " + locator_key);
				}
				Element = aDriver.findElementById(locator_key);

			}
		} else if (super.getOS().equals("iOS")) {
			WebDriverWait wait = new WebDriverWait(iDriver, waitTime);

			if (locator_key.contains("@")) {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator_key)));
				} catch (Exception e) {
					System.out.println("locator not found and locator is : " + locator_key);
				}
				Element = iDriver.findElementByXPath(locator_key);

			} else {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator_key)));
				} catch (Exception e) {
					System.out.println("locator not found and locator is : " + locator_key);
				}
				Element = iDriver.findElementById(locator_key);

			}
		}

		return Element;

	}

	// find by id or xpath by passing direct value
	public WebElement waitForElementDirect(String locator_key) throws IOException {
		WebElement Element = null;
		// String locator_key = pvl( locator);
		System.out.println("Locator is : " + locator_key);
		if (super.getOS().equals("Android")) {
			WebDriverWait wait = new WebDriverWait(aDriver, waitTime);
			if (locator_key.contains("@")) {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator_key)));
				} catch (Exception e) {
					System.out.println("locator not found and locator is : " + locator_key);
				}
				Element = aDriver.findElementByXPath(locator_key);

			} else {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator_key)));
				} catch (Exception e) {
					System.out.println("locator not found and locator is : " + locator_key);
				}
				Element = aDriver.findElementById(locator_key);

			}
		} else if (super.getOS().equals("iOS")) {
			WebDriverWait wait = new WebDriverWait(iDriver, waitTime);

			if (locator_key.contains("@")) {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator_key)));
				} catch (Exception e) {
					System.out.println("locator not found and locator is : " + locator_key);
				}
				Element = iDriver.findElementByXPath(locator_key);

			} else {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator_key)));
				} catch (Exception e) {
					System.out.println("locator not found and locator is : " + locator_key);
				}
				Element = iDriver.findElementById(locator_key);

			}
		}

		return Element;

	}

	// find by id or xpath and waiting time is 3secs
	public WebElement waitForElement_3Secs(String locator) throws IOException {
		WebElement Element = null;
		String locator_key = pvl(locator);
		System.out.println("locakator key is :" + locator + " locator is : " + locator_key);
		if (super.getOS().equals("Android")) {
			WebDriverWait wait = new WebDriverWait(aDriver, 3);
			if (locator_key.contains("@")) {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator_key)));
				} catch (Exception e) {
					System.out.println("locator not found and locator is : " + locator_key);
				}
				Element = aDriver.findElementByXPath(locator_key);

			} else {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator_key)));
				} catch (Exception e) {
					System.out.println("locator not found and locator is : " + locator_key);
				}
				Element = aDriver.findElementById(locator_key);

			}
		} else if (super.getOS().equals("iOS")) {
			WebDriverWait wait = new WebDriverWait(iDriver, 3);

			if (locator_key.contains("@")) {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator_key)));
				} catch (Exception e) {
					System.out.println("locator not found and locator is : " + locator_key);
				}
				Element = iDriver.findElementByXPath(locator_key);

			} else {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator_key)));
				} catch (Exception e) {
					System.out.println("locator not found and locator is : " + locator_key);
				}
				Element = iDriver.findElementById(locator_key);

			}
		}

		return Element;

	}

	// find by id or xpath by passing direct value
	private WebElement waitForElementDirect_3Secs(String locator_key) throws IOException {
		WebElement Element = null;
		System.out.println("Locator is : " + locator_key);
		if (super.getOS().equals("Android")) {
			WebDriverWait wait = new WebDriverWait(aDriver, 3);
			if (locator_key.contains("@")) {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator_key)));
				} catch (Exception e) {
					System.out.println("locator not found and locator is : " + locator_key);
				}
				Element = aDriver.findElementByXPath(locator_key);

			} else {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator_key)));
				} catch (Exception e) {
					System.out.println("locator not found and locator is : " + locator_key);
				}
				Element = aDriver.findElementById(locator_key);

			}
		} else if (super.getOS().equals("iOS")) {
			WebDriverWait wait = new WebDriverWait(iDriver, 3);

			if (locator_key.contains("@")) {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator_key)));
				} catch (Exception e) {
					System.out.println("locator not found and locator is : " + locator_key);
				}
				Element = iDriver.findElementByXPath(locator_key);

			} else {
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator_key)));
				} catch (Exception e) {
					System.out.println("locator not found and locator is : " + locator_key);
				}
				Element = iDriver.findElementById(locator_key);

			}
		}

		return Element;

	}
*/
	
	
	/*public List<String> ShowcaseLocators(String ShowcaseName_Showcase_Wishlist, int productIndexValue) {
		String locatorType="xpath=val=";
		String productFrame = locatorType+this.pvl("frameStart_" + ShowcaseName_Showcase_Wishlist) + productIndexValue + "]";
		String productName = productFrame + this.pvl("productName_" + ShowcaseName_Showcase_Wishlist);
		String productPrice = productFrame + this.pvl("productPrice_" + ShowcaseName_Showcase_Wishlist);
		String wishlistIcon = productFrame + this.pvl("wishlistIcon_" + ShowcaseName_Showcase_Wishlist);
		String variantName = productFrame + this.pvl("variantName_" + ShowcaseName_Showcase_Wishlist);
		String variantDropDownIcon = productFrame + this.pvl("variantDropDownIcon_" + ShowcaseName_Showcase_Wishlist);
		String addToCartBtn = productFrame + this.pvl("addToCartBtn_" + ShowcaseName_Showcase_Wishlist);
		String incrementBtn = productFrame + this.pvl("incrementBtn_" + ShowcaseName_Showcase_Wishlist);
		String decrementBtn = productFrame + this.pvl("decrementBtn_" + ShowcaseName_Showcase_Wishlist);
		String quantity = productFrame + this.pvl("quantity_" + ShowcaseName_Showcase_Wishlist);

		List<String> myString = new ArrayList<String>();
		myString.add(productFrame);
		myString.add(productName);
		myString.add(productPrice);
		myString.add(wishlistIcon);
		myString.add(variantName);
		myString.add(variantDropDownIcon);
		myString.add(addToCartBtn);
		myString.add(incrementBtn);
		myString.add(decrementBtn);
		myString.add(quantity);

		return (myString);
	}*/
	
	/*
	 * 
	 * Property Files
	 * 
	 * 
	 */
	
	/*public String pvts(String propertyFileKey) {
		String propertyFileValue = "Please check property file key";
		InputStream is = null;
		Properties prop = null;
		try {
			prop = new Properties();
			is = new FileInputStream(new File(prop_TestSuite));
			prop.load(is);
			propertyFileValue = prop.getProperty(propertyFileKey);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propertyFileValue;
	}

	// Reading MERCHANT property file value by passing key and path
	public String pvl(String propertyFileKey) {
		String propertyFilePath = propFilesPath + this.pvts("Merchant"+Trow) + "/" + "Locators.properties";
        String propertyFileValue = "Please check property file key";
		InputStream is = null;
		Properties prop = null;
		try {
			prop = new Properties();
			is = new FileInputStream(new File(propertyFilePath));
			prop.load(is);
			propertyFileValue = prop.getProperty(propertyFileKey + "_" + getOS());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
      return propertyFileValue;
	}

	// Reading MERCHANT DATA property file value by passing key and path
	public String pvc(String propertyFileKey) {
        String propertyFilePath = propFilesPath + this.pvts("Merchant"+Trow) + "/" + "CommonData.properties";
     String propertyFileValue = "Please check property file key";
		InputStream is = null;
		Properties prop = null;
		try {
			prop = new Properties();
			is = new FileInputStream(new File(propertyFilePath));
			prop.load(is);
			propertyFileValue = prop.getProperty(propertyFileKey);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return propertyFileValue;
	}
*/
	

/*	// Get cell value by passing sheet name and excel path.
	public String readExcelValue(String excelPath, String sheetName, int x, int y) throws IOException {

		int rowLength = getSheetRowCount(excelPath, sheetName);
		int colLength = getSheetColumnCount(excelPath, sheetName);
		String[][] data = new String[rowLength + 1][colLength];
		int i, j;
		String val = null;

		for (i = 0; i <= rowLength; i++) { // row
			for (j = 0; j < colLength; j++) // column
			{
				val = getSheet(excelPath, sheetName).getRow(i).getCell(j).toString();
				data[i][j] = val;
			}
		}
		String CellValue = data[x][y];

		return CellValue;
	}*/
/*	
	// Get cell value by passing sheet name and excel path.
		public String readExcelValue1(String excelPath, String sheetName, int x, int y) throws IOException {
			File get_file = new File(excelPath);
			FileInputStream fis = new FileInputStream(get_file);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet(sheetName);
			
			int rowLength = getSheetRowCount(excelPath, sheetName);
			int colLength = getSheetColumnCount(excelPath, sheetName);
			String[][] data = new String[rowLength + 1][colLength];
			int i, j;
			String val = null;

			for (i = 0; i <= rowLength; i++) { // row
				for (j = 0; j < colLength; j++) // column
				{
					val = sheet.getRow(i).getCell(j).toString();
					data[i][j] = val;
				}
			}
			String CellValue = data[x][y];
wb.close();
			return CellValue;
		}


	
	// Get OS name by passing row value in TestSuite excel value, tr means Target Row
	public String getOS() {
		String s = this.pvts("OS"+Trow);
		return s;
	}

	
	
	// Copy TestSuite excel data to property file
	public void updateTestSuiteProperties() throws IOException {

		int Trow = getSheetRowCount(excelPath, sheetName);
		for (int i = 1; i <= Trow; i++) {

			try {
				Properties props = new Properties();

				File f = new File(prop_TestSuite);
				InputStream input = new FileInputStream(f);

				if (input != null) {
					System.out.println("Copying row number in Test Suite excel is :" + i);

					props.load(input);
					props.setProperty("ExecutionStatus" + i, this.excelFormulaValTestSuite(i, 0));
					props.setProperty("Merchant" + i, this.excelFormulaValTestSuite(i, 1));
					props.setProperty("OS" + i, this.excelFormulaValTestSuite(i, 2));
					props.setProperty("Version" + i, this.excelFormulaValTestSuite(i, 3));
					props.setProperty("DeviceName" + i, this.excelFormulaValTestSuite(i, 4));
					props.setProperty("Udid" + i, this.excelFormulaValTestSuite(i, 5));
					props.setProperty("platformVersion" + i, this.excelFormulaValTestSuite(i, 6));
					props.setProperty("P0" + i, this.excelFormulaValTestSuite(i, 7));
					props.setProperty("P1" + i, this.excelFormulaValTestSuite(i, 8));
					props.setProperty("P2" + i, this.excelFormulaValTestSuite(i, 9));
					props.setProperty("OTS" + i, this.excelFormulaValTestSuite(i, 10));
					OutputStream out = new FileOutputStream(f);
					props.store(out, "save");
					System.out.println("Rows done in Test Suite excel :" + i);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
*/
	
/*
	
	public String TS_ExecelVal(int i, int j) throws IOException {
	
		File get_file = new File(excelPath);
		FileInputStream fis = new FileInputStream(get_file);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(sheetName);
		String val = sheet.getRow(i).getCell(j).toString();
		wb.close();
		return val;
	}*/
	
	/*
	public void updateTestSuiteProperties1() throws IOException {
		String ep = Dir + "/PropertyFiles.xlsx";
		String sht = "Customers";

		File get_file = new File(ep);
		FileInputStream fis = new FileInputStream(get_file);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(sht);

		int Trow = getSheetRowCount(ep, sht);

		for (int i = 1; i <= Trow; i++) {
			int k = 5;
			String M = sheet.getRow(0).getCell(k + 1).toString();
			try {
				Properties props = new Properties();

				File f = new File("../MobileAppsAutomation/src/caf/Merchants/" + M + "/Locators_" + M + ".properties");

				InputStream input = new FileInputStream(f);
				props.clear();
				if (input != null) {
					System.out.println("Copying row number in Test Suite excel is :" + i);

					props.load(input);
					for (int j = 1; j <= i; j++) {
						props.setProperty(
								sheet.getRow(j).getCell(0).toString() + "_" + sheet.getRow(j).getCell(1).toString()
										+ "_" + sheet.getRow(j).getCell(2).toString(),
								sheet.getRow(j).getCell(k).toString() + locatorSeparator
										+ sheet.getRow(j).getCell(k + 1).toString());
					}
					OutputStream out = new FileOutputStream(f);

					props.store(out, "save1");
					System.out.println("Rows done in Test Suite excel :" + i);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		wb.close();
	}
*/
	
	
	/*if (super.pvc("locationService").equals("yes")) {
		if (OS.equals("Android")) {
			int OSVersion = (int) Float.parseFloat(PlatformVersion.substring(0, 3));
			if (OSVersion >= 6) {
				for (int i = 1; i <= 2; i++) {
					this.click("locationServicesAllow");
				}
			}
		} else if (OS.equals("iOS")) {
			this.acceptAlert(5);
		}
	}*/

}
