package caf.FrameworkLibrary;

import java.io.IOException;

import java.io.File;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PressesKeyCode;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
//import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class CapDriver extends DataConfig {
	// AndroidDriver<AndroidElement> aDriver;
	// IOSDriver<IOSElement> iDriver;
	private AppiumDriverLocalService service;
	AppiumDriver<?> driver;
	private DesiredCapabilities cap;

	// Android App Installation with appium server
	public void androidAppInstall() {
		cap = new DesiredCapabilities();
		cap.setCapability("clearSystemFiles", true);
		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(nodeExecutablePath))
						.withAppiumJS(new File(appiumJS_Path))
						.withCapabilities(cap).withIPAddress("127.0.0.1").usingAnyFreePort());

		File apk = new File(appDir, this.pvts("Merchant" + Trow) + ".apk");
		System.out.println("APP name is : " + this.pvts("Merchant" + Trow) + ".apk");

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, this.pvts("DeviceName" + Trow));
		cap.setCapability(AndroidMobileCapabilityType.PLATFORM, this.pvts("OS" + Trow));
		cap.setCapability("automationName", "uiautomator2");
		cap.setCapability("udid", this.pvts("Udid" + Trow));
		cap.setCapability("appPackage", super.pvData("appPackage"));
		cap.setCapability("appActivity", super.pvData("appActivity"));
		// cap.setCapability("clearSystemFiles", true);("systemPort",XXXX)
		cap.setCapability(MobileCapabilityType.FULL_RESET, true);
		cap.setCapability("PlatformVersion", this.pvts("PlatformVersion" + Trow));
		String systemPort = randomNumString(3);
		String systemPort1 = Trow + systemPort;
		cap.setCapability("systemPort", systemPort1);
		cap.setCapability("app", apk.getAbsolutePath());
		driver = new AndroidDriver<AndroidElement>(service, cap);
		service.stop();
	}

	// Android App Installation with appium server
	public AppiumDriver<?> androidAppLaunch() {
		cap = new DesiredCapabilities();
		cap.setCapability("clearSystemFiles", true);

		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(nodeExecutablePath))
						.withAppiumJS(new File(appiumJS_Path))
						.withCapabilities(cap).withIPAddress("127.0.0.1").usingAnyFreePort());
		File apk = new File(appDir, this.pvts("Merchant" + Trow) + ".apk");
		System.out.println("APP name is : " + this.pvts("Merchant" + Trow) + ".apk");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, this.pvts("DeviceName" + Trow));
		cap.setCapability(AndroidMobileCapabilityType.PLATFORM, this.pvts("OS" + Trow));
		cap.setCapability("automationName", "uiautomator2");
		cap.setCapability("udid", this.pvts("Udid" + Trow));
		cap.setCapability("appPackage", super.pvData("appPackage"));
		cap.setCapability("appActivity", super.pvData("appActivity"));
		// cap.setCapability("clearSystemFiles", true);
		cap.setCapability(MobileCapabilityType.FULL_RESET, false);
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		cap.setCapability("PlatformVersion", this.pvts("PlatformVersion" + Trow));
		String systemPort = randomNumString(3);
		String systemPort1 = Trow + systemPort;
		cap.setCapability("systemPort", systemPort1);
		cap.setCapability("app", apk.getAbsolutePath());
		driver = new AndroidDriver<AndroidElement>(service, cap);
		return driver;
	}

	// iOS App Installation with appium server
	public AppiumDriver<?> iOSAppiumSetup() {
		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(nodeExecutablePath))
						.withAppiumJS(new File(appiumJS_Path))
						.withIPAddress("127.0.0.1").usingAnyFreePort());

		File ipa = new File(appDir, this.pvts("Merchant" + Trow) + ".ipa");
		System.out.println("APP name is : " + this.pvts("Merchant" + Trow) + ".ipa");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", this.pvts("OS" + Trow));
		// cap.setCapability(CapabilityType.PLATFORM, "Mac");
		cap.setCapability("automationName", "XCUITest");
		cap.setCapability("xcodeOrgId", super.pvData("xcodeOrgId"));
		cap.setCapability("xcodeSigningId", super.pvData("xcodeSigningId"));
		cap.setCapability("deviceName", this.pvts("DeviceName" + Trow));
		cap.setCapability("PlatformVersion", this.pvts("PlatformVersion" + Trow));
		cap.setCapability("useNewWDA", true);
		String wdaLocalPort = randomNumString(3);
		String wdaLocalPort1 = Trow + wdaLocalPort;
		cap.setCapability("wdaLocalPort", wdaLocalPort1);
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		cap.setCapability("udid", this.pvts("Udid" + Trow));
		cap.setCapability("bundleId", super.pvData("bundleId"));
		cap.setCapability("app", ipa.getAbsolutePath());

		driver = new IOSDriver<IOSElement>(service, cap);
		return driver;
	}

	public void launchApp() throws MalformedURLException, IOException, InterruptedException {
		driver.launchApp();
		/*
		 * if (super.getOS().equals("Android")) { aDriver.launchApp(); } else if
		 * (super.getOS().equals("iOS")) { iDriver.launchApp(); }
		 */
	}

	// Quitting driver
	public void stopServer() throws IOException {
		// service.stop();
		driver.quit();
		/*
		 * if (super.getOS().equals("Android")) { aDriver.quit(); } else if
		 * (super.getOS().equals("iOS")) { iDriver.quit(); }
		 */
	}

	// Resetting the app before executing the testcase
	public void resetApp() throws IOException, InterruptedException {
		String ipa = Dir + "/Apps/" + this.pvts("Merchant" + Trow) + ".ipa";
		if (super.getOS().equals("Android")) {
			driver.resetApp();
		} else if (super.getOS().equals("iOS")) {
			Thread.sleep(2000);
			driver.removeApp(super.pvData("bundleId"));
			driver.installApp(ipa);
			Thread.sleep(3000);
			driver.launchApp();
		}

	}

	public void acceptAlert(int waitingTimeInSec) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, waitingTimeInSec);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept(); // Till now this method not used any where in Android
		} catch (Exception e) {
			System.err.println("   no alert visible after " + waitingTimeInSec + " sec.");
		}
	}

	public void screenshotPass() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String folder_name_pass = this.pvts("Merchant" + Trow) + "_" + this.pvts("OS" + Trow) + "_"
				+ this.pvts("DeviceName" + Trow) + "_" + this.pvts("Version" + Trow) + "_Pass_" + dateWithTime + "/";

		String ImageFileName = driver.getExecuteMethod() + "-" + dateFormat.format(new Date()) + ".jpg";
		try {
			FileUtils.copyFile(scrFile, new File(screenshotsPath + "/" + folder_name_pass + ImageFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void testResult(ITestResult testResult) throws IOException {
		System.out.println(
				"testResult Method : Trow result is : " + Trow + "Device Name is : " + this.pvts("DeviceName" + Trow));
		File scrFile = null;
		new File(screenshotsPath).mkdirs();
		Reporter.setCurrentTestResult(testResult);

		if (testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println(testResult.getStatus());
			scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String folder_name_fail = this.pvts("Merchant" + Trow) + "_" + this.pvts("OS" + Trow) + "_"
					+ this.pvts("DeviceName" + Trow) + "_" + this.pvts("Version" + Trow) + "_fail_" + dateWithTime
					+ "/";

			String failureImageFileName = testResult.getName() + "-" + dateFormat.format(new Date()) + ".jpg";
			try {
				FileUtils.copyFile(scrFile, new File(screenshotsPath + "/" + folder_name_fail + failureImageFileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			Reporter.log("<a  href=Screenshots_Output/" + folder_name_fail + failureImageFileName + ">"
					+ "<p style=\"background-color:Tomato;\">Failed Screenshot :: " + folder_name_fail
					+ failureImageFileName + "</p>" + "</a>");
			Reporter.log("<html><body><img src=file://" + Dir + "/test-output/html/Screenshots_Output/"
					+ folder_name_fail + failureImageFileName + " alt=" + "Filed Screenshot"
					+ " width=\"250\" height=\"250\"></body></html>");
			Reporter.setCurrentTestResult(null);
		} else if (super.pvData("requireSuccessScreenshot").equals("yes")) {

			scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			String folder_name_pass = this.pvts("Merchant" + Trow) + "_" + this.pvts("OS" + Trow) + "_"
					+ this.pvts("DeviceName" + Trow) + "_" + this.pvts("Version" + Trow) + "_pass_" + dateWithTime
					+ "/";

			String successImageFileName = testResult.getName() + "-" + Arrays.toString(testResult.getParameters()) + "-"
					+ dateFormat.format(new Date()) + ".jpg";
			try {
				FileUtils.copyFile(scrFile, new File(screenshotsPath + "/" + folder_name_pass + successImageFileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			if (super.pvData("requireSuccessScreenshotInLogs").equals("yes")) {
				Reporter.log("<a  href=Screenshots_Output/" + folder_name_pass + successImageFileName + ">"
						+ "<p style=\"background-color:green;\">Failed Screenshot :: " + folder_name_pass
						+ successImageFileName + "</p>" + "</a>");
				Reporter.log("<html><body><img src=file://" + Dir + "/test-output/html/Screenshots_Output/"
						+ folder_name_pass + successImageFileName + " alt=" + "Filed Screenshot"
						+ " width=\"250\" height=\"250\"></body></html>");
				Reporter.setCurrentTestResult(null);
			}
		}

	}

	/*
	 * 
	 * 
	 * 
	 * Common Actions (iOS/Android)
	 * 
	 * 
	 */

	public void waitForElementClickable(String locator, int waitTime) {
		super.waitForElement_Clickable(driver, locator, waitTime);
	}
	
	public void waitForElementClickable(String locator_Android, String locator_iOS, int waitTime) {
		super.waitForElement_Clickable(driver, locator_Android,locator_iOS, waitTime);
	}
	
	public WebElement waitForElementPresence(String locator, int waitTime) {
		WebElement element = waitForElement(driver, locator, waitTime);
		return element;
	}
	public WebElement waitForElementPresence(String locator_Android, String locator_iOS, int waitTime) {
		WebElement element = waitForElement(driver, locator_Android,locator_iOS, waitTime);
		return element;
	}
	
	public void click(String locator_Android, String locator_iOS) throws IOException {
		waitForElementPresence(locator_Android,locator_iOS, waitTime).click();
	}
	public void click(String locator) throws IOException {
		waitForElementPresence( locator, waitTime).click();
	}
	public void click_3Secs(String locator_Android, String locator_iOS) throws IOException {
		waitForElementPresence( locator_Android,locator_iOS, shortWaitTime).click();
	}
	public void click_3Secs(String locator) throws IOException {
		waitForElementPresence( locator, shortWaitTime).click();
	}
	public void clickOptional_3Secs(String locator_Android, String locator_iOS) {
		String locator=super.locatorByOS(locator_Android, locator_iOS);
		try {
			waitForElementPresence( locator_Android,locator_iOS, shortWaitTime).click();
		} catch (Exception e) {
			System.out.println("Locator not available. Locator is :" + locator + " and exception is :" + e);
		}
	}
	public void clickOptional_3Secs(String locator) {
		
		try {
			waitForElementPresence( locator, shortWaitTime).click();
		} catch (Exception e) {
			System.out.println("Locator not available. Locator is :" + locator + " and exception is :" + e);
		}
	}
	public void setText(String locator_Android, String locator_iOS,String locator_value) throws IOException {
		waitForElementPresence( locator_Android,locator_iOS, waitTime).clear();
		waitForElementPresence( locator_Android,locator_iOS, waitTime).sendKeys(locator_value);
	}

	public void setTextForNonClearedFields(String locator_Android, String locator_iOS,String locator_value) throws IOException {

		waitForElementPresence( locator_Android,locator_iOS, waitTime).clear();
		waitForElementPresence( locator_Android,locator_iOS, waitTime).click();
		for (int i = 0; i <= 20; i++) {
			((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.DEL);
		}
		waitForElementPresence( locator_Android,locator_iOS, waitTime).sendKeys(locator_value);

	}

	public boolean isEnabled(String locator_Android, String locator_iOS) throws IOException {
		boolean status = false;
		status = this.waitForElementPresence( locator_Android,locator_iOS, waitTime).isEnabled();
		return status;

	}

	public boolean isEnabledOptional(String locator_Android, String locator_iOS) throws IOException {
		boolean status = false;
		try {
			status = this.waitForElementPresence( locator_Android,locator_iOS, waitTime).isEnabled();
		} catch (Exception e) {
			System.out.println();
		}
		return status;

	}

	public boolean isEnabledOptional_3Secs(String locator_Android, String locator_iOS) throws IOException {
		boolean status = false;
		try {
			status = this.waitForElementPresence( locator_Android,locator_iOS, shortWaitTime).isEnabled();
		} catch (Exception e) {
			System.out.println();
		}
		return status;

	}
	public boolean isEnabledOptional_3Secs(String locator) throws IOException {
		boolean status = false;
		try {
			status = this.waitForElementPresence( locator, shortWaitTime).isEnabled();
		} catch (Exception e) {
			System.out.println();
		}
		return status;

	}
	public boolean isSelected(String locator_Android, String locator_iOS) throws IOException {
		boolean status = false;
		status = this.waitForElementPresence( locator_Android,locator_iOS, waitTime).isSelected();
		return status;

	}

	public boolean isCheckedRadioButton(String locator_Android, String locator_iOS) throws IOException {
		boolean status = false;
		if (super.getOS().equals("Android")) {
			String checkedStatusAndroid = this.waitForElementPresence( locator_Android, null,waitTime).getAttribute("checked");
			if (checkedStatusAndroid.equals("true")) {
				status = true;
			}
		} else if (super.getOS().equals("iOS")) {
			String checkedStatusiOS = this.waitForElementPresence( null,locator_iOS, waitTime).getAttribute("value");
			if (checkedStatusiOS.equals("1")) {
				status = true;
			}
		}
		return status;

	}

	public String getText(String locator_Android, String locator_iOS) throws IOException {
		String text = "null";
		text = waitForElementPresence( locator_Android,locator_iOS, waitTime).getText();
		return text;
	}
	
	public String getText_3Secs(String locator_Android, String locator_iOS) throws IOException {
		String text = "null";
		text = waitForElementPresence( locator_Android,locator_iOS, super.shortWaitTime).getText();
		return text;
	}
	public String getText(String locator) throws IOException {
		String text = "null";
		text = waitForElementPresence( locator, waitTime).getText();
		return text;
	}
	/*
	 * public String getTextByNameDirect( String locator) throws IOException {
	 * String text = "null"; text = waitForElementByNameDirect( locator).getText();
	 * return text; }
	 */

	public void keypadClose() throws IOException {
		if (super.getOS().equals("Android")) {
			((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);
		} else if (super.getOS().equals("iOS")) {
			driver.findElementById(super.pvData("keypadDone")).click();
		}
	}

	public void keypadEnter() throws IOException {
		if (super.getOS().equals("Android")) {
			((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.KEYCODE_SEARCH);
		} else if (super.getOS().equals("iOS")) {
			driver.findElementById(super.pvData("keypadDOne")).click();
		}
	}

	public void keypadNext() throws IOException {
		if (super.getOS().equals("Android")) {
			((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.ENTER);
		} else if (super.getOS().equals("iOS")) {
			driver.findElementById(super.pvData("keypadNext")).click();
		}
	}

	public void scrollDown(int ScrollCount) throws IOException {

		for (int i = 1; i <= ScrollCount; i++) {
			if (super.getOS().equals("Android")) {
				Dimension dimensions = driver.manage().window().getSize();
				Double screenHeightStart = dimensions.getHeight() * 0.4;
				int scrollStart = screenHeightStart.intValue();
				Double screenHeightEnd = dimensions.getHeight() * 0.2;
				int scrollEnd = screenHeightEnd.intValue();

				TouchAction action = new TouchAction(driver);
				action.press(0, scrollStart);
				action.waitAction();
				action.moveTo(0, scrollEnd);
				action.release();
				action.perform();
			} else if (super.getOS().equals("iOS")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("direction", "down");
				js.executeScript("mobile: scroll", scrollObject);
			}
		}
	}

	public void scrollUp(int ScrollCount) throws IOException {
		for (int i = 1; i <= ScrollCount; i++) {
			if (super.getOS().equals("Android")) {
				Dimension dimensions = driver.manage().window().getSize();
				Double screenHeightStart = dimensions.getHeight() * 0.4;
				int scrollStart = screenHeightStart.intValue();
				Double screenHeightEnd = dimensions.getHeight() * 0.2;
				int scrollEnd = screenHeightEnd.intValue();

				TouchAction action = new TouchAction(driver);
				action.press(0, scrollEnd);
				action.waitAction();
				action.moveTo(0, scrollStart);
				action.release();
				action.perform();
			} else if (super.getOS().equals("iOS")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("direction", "up");
				js.executeScript("mobile: scroll", scrollObject);
			}
		}
	}

	/*
	 * public void scrollDownUntillElementVisible(String locator, int
	 * maxScrollTimes) throws IOException { boolean displayed = false; for (int i =
	 * 1; i <= maxScrollTimes; i++) { try { displayed =
	 * waitForElementPresence(locator, shortWaitTime).isDisplayed(); } catch
	 * (Exception e) {
	 * System.out.println("scrollUntillElementVisible method executing and status :"
	 * + displayed); } if (displayed) { System.out.println("Element found"); break;
	 * } else { this.scrollDown(1); } } }
	 */

	/*
	 * 
	 * Android Specific actions
	 * 
	 */
	public void deviceBack_Android() {

		((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);
	}

	/*
	 * 
	 * iOS Specific actions
	 * 
	 */

	/*
	 * 
	 * Asserts
	 * 
	 */

	public void assertEquals_Text(String actualText, String expectedText) throws IOException {
		Assert.assertEquals(actualText, expectedText);
		this.screenshotPass();

	}

	public void assertEquals_True(boolean actualValue_WhichReturnsTrue) throws IOException {
		Assert.assertEquals(actualValue_WhichReturnsTrue, true);
		this.screenshotPass();

	}

	public void assertEquals_False(boolean actualValue_WhichReturnsFalse) throws IOException {
		Assert.assertEquals(actualValue_WhichReturnsFalse, false);
		this.screenshotPass();

	}
}
