package com.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.Base;
import com.pages.DashBoard_Page;
import com.util.ExcelReader;

public class ChangeLocationTest extends Base{
	DashBoard_Page dp;
	@BeforeClass
	public void launchBrowser()
	{
		initializaiton();
		dp = new DashBoard_Page();
	}
	@AfterClass
	public void closeSetup()
	{
		tearDown();
	}
	@BeforeTest
	public void reportSetup()
	{
		extentReportSetup();
	}
	@AfterTest
	public void closeReportSetup()
	{
		closeExtentReportSetup();
	}
	

	@DataProvider
	public Object[][] getData()
	{
		Object data[][]=null;
		String excelpath=".\\src\\main\\resources\\SearchItems.xlsx";
		String sheetName="Sheet1";
		ExcelReader reader=new ExcelReader(excelpath,sheetName);
		data=reader.getTestData();
		return data;
	}
	
	@Test
	public void changeLocation()
	{
		ExtentTest test = extent.createTest("BigBasket Search & Sort Test");
		test.log(Status.INFO, "Test started for Change location");
		dp.changeLocation();
		test.log(Status.INFO, "Test completed for Change location");
	}

}
