package config;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.FrameworkBase;

public class UtilityPage extends FrameworkBase {

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static void waitforsec(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
		}
	}

	public static void implicitWait(int i) {
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
	}

	public static void explicitWait(int i, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, i);
		wait.until(ExpectedConditions.presenceOfElementLocated((By) ele));
	}

	public static void assertEquals(String str1, String str2) {
		Assert.assertEquals(str1, str2);
	}

	public static void assertEquals(String str3, String str4, String msg) {
		Assert.assertEquals(str3, str4, msg);
	}

	public static void assertTrue(boolean cond) {
		Assert.assertTrue(cond);
	}

	public static void assertTrue(boolean cond, String message) {
		Assert.assertTrue(cond, message);
	}

	public static void assertFalse(boolean cond) {
		Assert.assertFalse(cond);
	}

	public static void assertFalse(boolean cond, String message) {
		Assert.assertFalse(cond, message);
	}

	public static boolean isEnabled(WebElement ele) {
		boolean cond = ele.isEnabled();
		return cond;
	}

	public static boolean isSelected(WebElement ele) {
		boolean cond = ele.isSelected();
		return cond;
	}

	public static boolean isDisplayed(WebElement ele) {
		boolean cond = ele.isDisplayed();
		return cond;
	}

	public static void takeScreenShot(String testCaseName) {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\akash\\eclipse-workspace\\TestNGFramework\\MagnetoProject\\Screenshots\\"
				+ testCaseName + getTimeAndDate() + ".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (Exception e) {
		}
	}

	public static String getTimeAndDate() {

		SimpleDateFormat format = new SimpleDateFormat("ddMMMhhmm");
		String date = format.format(new Date());
//		System.out.println(date);
		return date;
	}
}
