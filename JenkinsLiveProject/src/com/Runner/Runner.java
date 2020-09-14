package com.Runner;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.runtest.JenkinsLive;

public class Runner {
	public WebDriver driver;
	JenkinsLive jl;
	public Runner() {
		jl=new JenkinsLive();
	}
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Browser\\chromedriver_win32_83\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/login?from=%2F");
		driver=jl.LoginPage(driver);
	}
	@Test
	public void VerifyJenkinsLive() throws InterruptedException {
		//jl.ClickBuildHistory(driver);
		//jl.ClickProjectRelationship(driver);
		//jl.JenkinsSuite1(driver);
		//jl.JenkinsSuite2(driver);
		//jl.ClickCheckFileFingerprint(driver);
		//jl.ClickMyViews(driver);
		jl.ClickCredentials(driver);
		jl.LogoutPage(driver);
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
