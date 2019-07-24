package com.qa.hs.keyword.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	// here we are initializing code for each browser
	// method which will be called by engine file and the browser type will passed
	// this method will return an element of web driver type
	public WebDriver init_driver(String browserName){
		// if the browser is chrome
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
			if(prop.getProperty("headless").equals("yes")){
				// headless mode -- browser will not open but the operations are performed in
				// the background
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			}
			// else browser will be opened
			else{
				driver = new ChromeDriver();
			}
		} 
				// if the browser is fire fox
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\kumar\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver");
			driver = new FirefoxDriver();
		}
		return driver;
	}
	
	public Properties init_properties(){
		//creating object property
		prop = new Properties();
		try {
			//calling the configuration file
			FileInputStream ip = new FileInputStream("C:\\Users\\kumar\\Downloads\\Keyword-Driven-Web-UI-Framework-master\\Keyword-Driven-Web-UI-Framework-master\\src\\main\\java\\com\\qa\\hs\\keyword\\config\\config.properties");
			//now load the properties
			//browser , URL
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
