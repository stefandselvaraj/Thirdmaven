package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author raj64
 * @date 14\07\22
 * @description Base methods For all Classes
 * 
 */

public class BaseClass {
	public static WebDriver driver;

	/**
	 * @description broswer type
	 * @param type
	 */

	public static void getDriver(String type) {
		switch (type) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			break;
		} 
		
	/**
	 * @description adactin url
	 */

	}

	public static void getUrl(String url) {
		driver.get(url);

	}

	/**
	 * @description sendkey
	 * @param element
	 * @param data
	 */
	
	public static void setValue(WebElement element , String data) {
		element.sendKeys(data);
	}

	/**
	 * @description click
	 * @param element
	 */
	
	public static void click(WebElement element) {
		element.click();

	}
	
	/**
	 * @description get tittle
	 * @return string
	 */

	public static String getTitle() {
		String title = driver.getTitle();
		return title;

	}
	
	/**
	 * @description find locator by id
	 * @param id
	 * @return WebElement
	 */

	public static WebElement findElementById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;

	}
	/**
	 * @description find locator by name
	 * @param name
	 * @return webElement
	 */

	public static WebElement findElementByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;

	}
	
	/**
	 * @description find locator by classname
	 * @param className
	 * @return webElement
	 */

	public static WebElement findElementByClassName(String className) {
		WebElement element = driver.findElement(By.className(className));
		return element;

	}
	
	/**
	 * @description find locator by Xpath
	 * @param Xpath
	 * @return
	 */

	public static WebElement findElementByXpath(String Xpath) {
		WebElement element = driver.findElement(By.xpath(Xpath));
		return element;

	}
	
	/**
	 * @description maximizing window
	 */

	public static void maximize() {
		driver.manage().window().maximize();
	}
	
	/**
	 * @description all window Close
	 */

	public static void closeAllWindow() {
		driver.quit();
	}
	
	/**
	 * @description current window close
	 */

	public static void closeWindow() {
		driver.close();
	}

    /**
     * @description get text
     * @param element
     * @return
     */
	
	public static String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	/**
	 * @description get Attribute value
	 * @param element
	 * @param attributeName
	 * @return
	 */
	public static String getAttribute(WebElement element , String attributeName) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}

	/**
	 * @description drop down select by text
	 * @param element
	 * @param text
	 */
	public static void selectOptionByText(WebElement element , String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * @description drop down select by value
	 * @param element
	 * @param text
	 */
	public static void selectOptionByValue(WebElement element , String text) {
		Select select = new Select(element);
		select.selectByValue(text);
	}
	
	/**
	 * @description drop down select by index
	 * @param element
	 * @param index
	 */

	public static void selectOptionByIndex(WebElement element , int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 * @description property file value
	 * @param key
	 * @return  string
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {

		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir")+"\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;

	}
	
	/**
	 * @description cancel alert popUp
	 */


	public static void cancelAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();

	}
	
	/**
	 * @description accept alert popUp
	 */

	public static void okAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}

	
	/**
	 * @description create and insert value 
	 * @param path
	 * @param sheetname
	 * @param rowNo
	 * @param cellNo
	 * @param Data
	 * @throws IOException
	 */
	
	public void creatCellAndInsertValue(String path, String sheetname, int rowNo, int cellNo,String Data) throws IOException {
		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rowNo);
		Cell createCell = row.createCell(cellNo);
		createCell.setCellValue(Data);
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);

	}
	
	/**
	 * @description get value form file
	 * @param path
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Exception
	 * @throws IOException
	 */


	public String getData(String path,String sheetName, int rownum, int cellnum) throws Exception, IOException {
		String value = null;

		File f = new File(path);
		FileInputStream file = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(file);
		Sheet s = w.getSheet(sheetName);
		Row r = s.getRow(rownum);
		Cell c = r.getCell(cellnum);
		int cellType = c.getCellType();
		if (cellType==1) {
			value = c.getStringCellValue();

		}
		else if (cellType==0) {
			if (DateUtil.isCellDateFormatted(c)) {
				Date dateCellValue = c.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd\\mm\\yyyy");
				value = sim.format(dateCellValue);

			}
			else {
				double numericCellValue = c.getNumericCellValue();
				long l = (long)numericCellValue;
				value = String.valueOf(l);

			}

		}
		return value;
		}
	
	public byte[] screenshotAsByte() {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
		
	}















}