package com.myRetail.pageobjects;

import java.math.BigDecimal;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page object representing MyRetail Landing Page.
 */
public class LandingPage extends BasePage<LandingPage> {
	private String ColumnNames = "Product Id,Product Name,Product Description,Manufacturer,Quantity Available";
	
	

	@FindBy(xpath = "//h1[text()]")
	WebElement logo;
	

	@FindBy(id = "productId")
	WebElement TxtBx_Search;

	@FindBy(id = "searchProduct")
	WebElement Btn_Search;
	
	@FindBy(id = "findAll")
	WebElement Tab_AllProducts;
	
	@FindBy(id = "error-msg")
	WebElement Search_Error;
	
	@FindBy(id = "findAllProductsInStock")
	WebElement Tab_AllProductsInStock;

	@FindBy(id = "findAllProductsOutOfStock")
	WebElement Tab_AllProductsOutOfStock;

	@FindBy(id = "productTable")
	WebElement Tbl_ProductTable;
	
	@FindBy(xpath = "//table[@id='productTable']/tbody/tr[1]/th")
	List<WebElement>  Tbl_Columns;
	
	@FindBy(xpath = "//table[@id='productTable']/tbody/tr[2]/td[1]")
	WebElement Tbl_FirstRowResult;
	
	@FindBy(xpath = "//table[@id='productTable']/tbody/tr[2]")
	WebElement Tbl_FirstRow;
	
	@FindBy(xpath = "//table[@id='productTable']/tbody/tr[2]/td[5]")
	WebElement Tbl_OutOfStock;
	
	
	

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(logo);
	}

	public boolean search(String productId) {
		TxtBx_Search.clear();
		TxtBx_Search.sendKeys(productId);
		Btn_Search.click();
		return isSearchSuccessful(productId);
	}
	
	public void searchBlank(String productId) {
		TxtBx_Search.clear();
		TxtBx_Search.sendKeys(productId);
		Btn_Search.click();
		
	}
	


	@Override
	public String getPageUrl() {
		
		return null;
	}

	public boolean isSearchSuccessful(String value) {
		try
		{
			if(Tbl_FirstRowResult.isDisplayed())
		{
			return value.contentEquals(Tbl_FirstRowResult.getText());	
		}
			}catch(Exception e) {
			
		}
	return false;		
		
	}
	
	public boolean isSearchErrorDisplayed(String value) {
		try
		{
			if(Search_Error.isDisplayed())
		{
			return value.contentEquals(Search_Error.getText());	
		}
			}catch(Exception e) {
			
		}
	return false;		
		
	}
	
	
	public boolean isContentDisplayed(String value) {
		try
		{
			if(Tbl_FirstRowResult.isDisplayed())
		{
			return value.contentEquals(Tbl_FirstRowResult.getText());	
		}
			}catch(Exception e) {
			
		}
	return false;		
		
	}
	
	

	public boolean searchContent(String productId) {
		
		return isSearchSuccessful(productId);
	}
	
public boolean quantityCheck(String quantityAvailable) {
		
		return isOosQtySuccessful(quantityAvailable);
	}

public boolean isOosQtySuccessful(String value) {
	try
	{
		if(Tbl_OutOfStock.isDisplayed())
	{
		return value.contentEquals(Tbl_OutOfStock.getText());	
	}
		}catch(Exception e) {
		
	}
return false;		
	
}
	
	public boolean verifyCoulmnNames() {
		String actualColumnNames = this.getColumnNames();
		return actualColumnNames.contentEquals(ColumnNames);
	}

	


	private String getColumnNames() {
		
		return ColumnNames;
	}
	


	public void navigateToAllProductTab() {
		Tab_AllProducts.click();

	}

	public void navigateToInStockProductTab() {
		Tab_AllProductsInStock.click();
	}

	public void navigateToOutOfProductTab() {
		Tab_AllProductsOutOfStock.click();
	}
}
