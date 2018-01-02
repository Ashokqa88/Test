package caf.FrameworkLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import io.appium.java_client.AppiumDriver;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataConfig {
	protected String Dir = System.getProperty("user.dir");
	protected String nodeExecutablePath = "/usr/local/bin/node";
	protected String appiumJS_Path = "/usr/local/lib/node_modules/appium/build/lib/main.js";

	protected String excelPath = Dir + "/TestSuite.xlsx";
	protected String sheetName = "MainSheet";
	protected String prop_TestSuite = Dir + "/src/caf/FrameworkLibrary/TestSuite.properties";
	protected String AppsPath = Dir + "/Apps/";
	protected String propFilesPath = Dir + "/src/caf/Merchants/";
	protected String screenshotsPath = Dir + "/test-output/html/Screenshots_Output/";
	protected DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
	// protected Date date = new Date();
	protected File appDir = new File(AppsPath);
	protected int waitTime = 60;
	protected int shortWaitTime = 3;
	protected String dateWithTime = dateFormat.format(new Date());
	protected int Trow;
	protected String gmailUserId = "Capillarymqa@gmail.com";
	protected String gmailPassword = "Capillary123";
	protected String gmailUsersInCC = "Capillarymqa@gmail.com,ashok.gurijala@capillarytech.com";

	protected String locatorSeparator = "<LocatorValueIs>";
	protected String xpath = "xpath" + locatorSeparator;
	protected String id = "id" + locatorSeparator;
	protected String name = "name" + locatorSeparator;

	protected String endXpath = "]";
	protected String customReportFilename = Dir + "/test-output/custom-report.html";

	public void updateTrow(int Trow1) throws IOException {
		Trow = Trow1;
	}

	// Get the sheet by passing sheet name and excel path.
	public Sheet getSheet(String excelPath, String sheetName) throws IOException {
		File get_file = new File(excelPath);
		FileInputStream fis = new FileInputStream(get_file);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sh = workbook.getSheet(sheetName);
		workbook.close();
		return sh;
	}

	// Get the row count by passing sheet name and excel path.
	public int getSheetRowCount(String excelPath, String sheetName) throws IOException {
		int rowCount = 0;
		rowCount = getSheet(excelPath, sheetName).getLastRowNum();
		return rowCount;
	}

	// Get column count by passing sheet name and excel path.
	public int getSheetColumnCount(String excelPath, String sheetName) throws IOException {
		int columnCount = 0;

		Iterator<Row> iterator = getSheet(excelPath, sheetName).iterator();
		Row nextRow = iterator.next();
		columnCount = nextRow.getLastCellNum();
		return columnCount;
	}

	
	
	
	public void waitForElement_Clickable(@SuppressWarnings("rawtypes") AppiumDriver driver, String locator, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		System.out.println("locator_key is :" + locator);
		String locatorType = locator.split(locatorSeparator)[0];
		System.out.println("locatorType : " + locatorType);
		String locatorValue = locator.split(locatorSeparator)[1];
		System.out.println("locatorValue : " + locatorValue);
		switch (locatorType) {
		case "id":
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			

			break;
		case "xpath":
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			break;
		case "name":
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.name(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			break;
		}
	}
	
	public void waitForElement_Clickable(@SuppressWarnings("rawtypes") AppiumDriver driver, String locator_Android, String locator_iOS, int waitTime) {
		String locator=this.locatorByOS(locator_Android, locator_iOS);
		this.waitForElement_Clickable(driver, locator, waitTime);
	}
		
	
	public WebElement waitForElement(@SuppressWarnings("rawtypes") AppiumDriver driver, String locator_Android, String locator_iOS, int waitTime) {
		WebElement Element = null;
		String locator=this.locatorByOS(locator_Android, locator_iOS);
		Element=this.waitForElement(driver, locator, waitTime);
		return Element;
	}

	public WebElement waitForElement(@SuppressWarnings("rawtypes") AppiumDriver driver,String locator, int waitTime) {
		WebElement Element = null;
		System.out.println("locator_key is :" + locator);
		String locatorType = locator.split(locatorSeparator)[0];
		System.out.println("locatorType : " + locatorType);
		String locatorValue = locator.split(locatorSeparator)[1];
		System.out.println("locatorValue : " + locatorValue);

		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		switch (locatorType) {
		case "id":
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			Element = driver.findElementById(locatorValue);

			break;
		case "xpath":
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			Element = driver.findElementByXPath(locatorValue);
			break;
		case "name":
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			Element = driver.findElementByName(locatorValue);
			break;
		}
		return Element;
	}

	// Get Formula cell value by passing cell values from TestSuite excel value
	public String excelFormulaValTestSuite(int x, int y) {
		String val = "";
		File get_file = new File(excelPath);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(get_file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook wb = null;
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet(sheetName);
		FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

		int rowLength = 0;
		try {
			rowLength = getSheetRowCount(excelPath, sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int colLength = 0;
		try {
			colLength = getSheetColumnCount(excelPath, sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[][] data = new String[rowLength + 1][colLength];
		int i, j;
		for (i = 0; i <= rowLength; i++) { // row
			for (j = 0; j < colLength; j++) // column
			{
				val = evaluator.evaluate(sheet.getRow(i).getCell(j)).formatAsString();
				int len = val.length();

				if (val.contains("\"")) {
					data[i][j] = val.substring(1, len - 1);
				} else if (j == 5) {
					data[i][j] = val.substring(0, len - 2);
				} else {
					data[i][j] = val;
				}
			}
		}
		String CellValue = data[x][y];
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CellValue;
	}

	public void suitesExecution() throws IOException {

		int TestSuiteExcelRowCount = this.getSheetRowCount(excelPath, sheetName);
		System.out.println("TestSuiteExcelRowCount" + TestSuiteExcelRowCount);
		TestNG tng = new TestNG();
		XmlSuite suite = new XmlSuite();
		suite.setName("Mobile Automation_Suite" + dateFormat.format(new Date()));
		System.out.println("suite name is : " + "Mobile Automation_Suite_" + dateFormat.format(new Date()));
		suite.setParallel(XmlSuite.ParallelMode.TESTS);
		// suite.setThreadCount(10);
		suite.addListener("org.uncommons.reportng.HTMLReporter");
		suite.addListener("org.uncommons.reportng.JUnitXMLReporter");
		suite.addListener("caf.FrameworkLibrary.Reporting.TestNGCustomReportListener");

		for (int Trow = 1; Trow <= TestSuiteExcelRowCount; Trow++) {

			if (this.excelFormulaValTestSuite(Trow, 0).equals("Run")) {

				XmlTest test = new XmlTest(suite);

				test.addParameter("Trow", String.valueOf(Trow));
				int merchantColumnNumber = 1;
				test.setName(this.pvts("Merchant" + Trow) + "_" + this.pvts("OS" + Trow) + "_"
						+ this.pvts("DeviceName" + Trow) + "_" + this.pvts("Version" + Trow));
				test.setPreserveOrder(true);

				List<XmlClass> list = new ArrayList<XmlClass>();

				if (this.pvts("P0" + Trow).equals("Yes")) {
					list.add(new XmlClass("caf.Suites." + this.excelFormulaValTestSuite(Trow, merchantColumnNumber)
							+ "." + "P0_Testcases"));
				}

				if (this.pvts("P1" + Trow).equals("Yes")) {
					list.add(new XmlClass("caf.Suites." + this.excelFormulaValTestSuite(Trow, merchantColumnNumber)
							+ "." + "P1_Testcases"));

				}

				if (this.pvts("P2" + Trow).equals("Yes")) {
					list.add(new XmlClass("caf.Suites." + this.excelFormulaValTestSuite(Trow, merchantColumnNumber)
							+ "." + "P2_Testcases"));

				}
				if (this.pvts("OTS" + Trow).equals("Yes")) {
					list.add(new XmlClass("caf.Suites." + this.excelFormulaValTestSuite(Trow, merchantColumnNumber)
							+ "." + "OTS_Testcases"));

				}
				test.setXmlClasses(list);

			}

		}

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		tng.setXmlSuites(suites);
		tng.run();
	}

	public void Sample_File() {

		XmlSuite suite = new XmlSuite();
		suite.setName("Mobile Automation Development");
		// suite.setParallel("false");
		suite.setVerbose(1);

		XmlTest test1 = new XmlTest(suite);
		test1.setName("test1");

		XmlTest test2 = new XmlTest(suite);
		test2.setName("test2");

		XmlClass className1 = new XmlClass("com.caf.test.Testing");
		XmlClass className2 = new XmlClass("com.caf.test.Testclass1");

		List<XmlClass> list1 = new ArrayList<XmlClass>();

		list1.add(className1);
		list1.add(className2);

		List<XmlClass> list2 = new ArrayList<XmlClass>();

		list2.add(className1);
		list2.add(className2);

		test1.setXmlClasses(list1);
		test2.setXmlClasses(list2);

		TestNG tng = new TestNG();
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		tng.setXmlSuites(suites);
		tng.run();
	}

	public String randomString(int len) {
		String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();

		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	public String randomNumString(int len) {
		String AB = "123456789987654321";
		SecureRandom rnd = new SecureRandom();

		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	public int randomNumInteger(int len) {

		String number = this.randomNumString(len);
		int result = Integer.parseInt(number);
		return result;
	}

	public String pvData(String propertyFileKey) {
		
		String propertyFilePath = propFilesPath + this.pvts("Merchant" + Trow) + "/" + this.pvts("Merchant" + Trow) + "_Data.properties";
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

	public int getRunCount() throws IOException { // USing for Mail reporting
		int i, j = 0;
		int Trow = getSheetRowCount(excelPath, sheetName);
		for (i = 0; i <= Trow; i++) {
			String s = this.excelFormulaValTestSuite(i, 0);
			// System.out.println("s is :"+s);
			if (s.equals("Run")) {
				j = j + 1;
			}
		}

		return j;
	}

	public void updatePropVal_Data() throws IOException {
		String Merchant = this.excelFormulaValTestSuite(Trow, 1);
		String propertyFilePath = propFilesPath + Merchant + "/" + Merchant + "_Data.properties";
		FileInputStream in = new FileInputStream(propertyFilePath);
		Properties props = new Properties();
		props.load(in);
		in.close();
		
		FileOutputStream out = new FileOutputStream(propertyFilePath);
		props.setProperty("MerchantName", this.excelFormulaValTestSuite(Trow, 1));
		props.setProperty("OS", this.excelFormulaValTestSuite(Trow, 2));
		props.setProperty("AppVersion", this.excelFormulaValTestSuite(Trow, 3));
		props.setProperty("DeviceName", this.excelFormulaValTestSuite(Trow, 4));
		props.setProperty("Udid", this.excelFormulaValTestSuite(Trow, 5));
		props.setProperty("PlatformVersion", this.excelFormulaValTestSuite(Trow, 6));
		
		props.store(out, null);
		out.close();
	}

	
	public String locatorByOS(String locator_Android, String locator_iOS) {
		String locator = null;
		System.out.println("OS is : " + this.getOS());
		if (this.getOS().equals("Android")) {
			locator = locator_Android;
		} else if (this.getOS().equals("iOS")) {
			locator = locator_iOS;
		}

		return locator;

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

		public String pvts(String propertyFileKey) {
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

		// Get OS name by passing row value in TestSuite excel value
		public String getOS() {
			String s=pvts("OS" + Trow);
			return s;
		}
}
