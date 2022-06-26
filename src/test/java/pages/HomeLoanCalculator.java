package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WebDriverWrapper;

public class HomeLoanCalculator {
	private WebDriver driver;
	private Properties config;
	By titleTextBy = By.cssSelector("h1[class*='hero']");
	By singleButtonBy = By.xpath("//li//label[@for='application_type_single']/parent::li");
	By jointButtonBy = By.xpath("//li//label[@for='application_type_joint']/parent::li");
	By selectedApplicationButtonBy = By.xpath("//li[@class='selected']//label[contains(@for,'application_type')]");
	By noDependantsDropDownBy = By.xpath("//select[@title='Number of dependants']");
	By homePropertyButtonBy = By.xpath("//li//label[@for='borrow_type_home']/parent::li");
	By investmentPropertyButtonBy = By.xpath("//li//label[@for='borrow_type_investment']/parent::li");
	By selectedPropertyBy = By.xpath("//li[@class='selected']//label[contains(@for,'borrow_type')]");
	By currencyLabelBy = By.xpath("//div//span[@class='currency']");
	By otherIncomeTextBy = By
			.xpath("//div//label[text() = 'Your annual other income (optional)']/following-sibling::div//input");
	By annualIncomeTextBy = By
			.xpath("//div//label[text() = 'Your annual income (before tax)']/following-sibling::div//input");
	By livingExpensesTextBy = By.xpath("//div//label/following-sibling::div//input[@id='expenses']");
	By homeLoanRepaymentTextBy = By.xpath("//div//label/following-sibling::div//input[@id='homeloans']");
	By otherLoanRepaymentTextBy = By.xpath("//div//label/following-sibling::div//input[@id='otherloans']");
	By monthlyCommitmentTextBy = By
			.xpath("//div//label[text()='Other monthly commitments']/following-sibling::div//input");
	By creditCardLimitTextBy = By.xpath("//div//label/following-sibling::div//input[@id='credit']");
	By workOutBorrowButtonBy = By.cssSelector("button[id=btnBorrowCalculater]");
	By borrowResultTextBy = By.xpath("//span[@id='borrowResultTextAmount']");
	By startOverButtonBy = By.cssSelector("button.start-over");
	By errorTextBy = By.xpath("//button[@class='start-over']/ancestor::div[contains(@class,'error')]//div//div");
	int timeout;
	int pageLoadTimeOut;

	public HomeLoanCalculator(WebDriver driver, Properties config) {
		this.driver = driver;
		this.config = config;
		this.timeout = Integer.parseInt(this.config.getProperty("defaultTimeOut"));
		this.pageLoadTimeOut = Integer.parseInt(this.config.getProperty("pageLoadTimeOut"));
	}

	public boolean isPageLoaded(String title) {
		return WebDriverWrapper.verifyTextToBePresentInElement(driver, titleTextBy, title, pageLoadTimeOut);
	}

	public void clickSingleTypeButton() {
		WebDriverWrapper.clickButton(driver, singleButtonBy, timeout);
	}

	public void clickJointTypeButton() {
		WebDriverWrapper.clickButton(driver, jointButtonBy, timeout);
	}

	public void selectNoOfDependants(String noOfDependant) {
		WebDriverWrapper.selectDropDownByValue(driver, noDependantsDropDownBy, noOfDependant, timeout);
	}

	public void clickHomePropertyButton() {
		WebDriverWrapper.clickButton(driver, homePropertyButtonBy, timeout);
	}

	public void clickInvestmentPropertyButton() {
		WebDriverWrapper.clickButton(driver, homePropertyButtonBy, timeout);
	}

	public void setAnnualIncome(String annualIncome) {
		WebDriverWrapper.sendKeys(driver, annualIncomeTextBy, annualIncome, timeout);

	}

	public void setOtherIncome(String otherIncome) {
		WebDriverWrapper.sendKeys(driver, otherIncomeTextBy, otherIncome, timeout);

	}

	public void setLivingExpenses(String livingExpenses) {
		WebDriverWrapper.sendKeys(driver, livingExpensesTextBy, livingExpenses, timeout);
	}

	public void setHomeLoanRepaymentValue(String homeLoanRepayment) {
		WebDriverWrapper.sendKeys(driver, homeLoanRepaymentTextBy, homeLoanRepayment, timeout);
	}

	public void setOtherLoanRepaymentValue(String otherLoanRepayment) {
		WebDriverWrapper.sendKeys(driver, otherLoanRepaymentTextBy, otherLoanRepayment, timeout);
	}

	public void setMonthlyCommitments(String monthlyCommitment) {
		WebDriverWrapper.sendKeys(driver, monthlyCommitmentTextBy, monthlyCommitment, timeout);
	}

	public void setCreditCardLimit(String creditCardLimit) {
		WebDriverWrapper.sendKeys(driver, creditCardLimitTextBy, creditCardLimit, timeout);
	}

	public void clickWorkOutBorrowButton() {
		WebDriverWrapper.clickButton(driver, workOutBorrowButtonBy, timeout);
	}

	public String getEstimatedResult() {
		return WebDriverWrapper.getElementText(driver, borrowResultTextBy, timeout);
	}

	public void clickStartOverButton() {
		WebDriverWrapper.clickButton(driver, startOverButtonBy, timeout);
	}

	public WebElement getSelectedApplication() {
		return WebDriverWrapper.getWebElement(driver, selectedApplicationButtonBy, timeout);
	}

	public WebElement getDependantElement() {
		return WebDriverWrapper.getDropDownSelectedValue(driver, noDependantsDropDownBy, timeout);
	}

	public WebElement getSelectedProperty() {
		return WebDriverWrapper.getWebElement(driver, selectedPropertyBy, timeout);
	}

	public WebElement getAnnualIncome() {
		return WebDriverWrapper.getWebElement(driver, annualIncomeTextBy, timeout);
	}

	public WebElement getOtherIncome() {
		return WebDriverWrapper.getWebElement(driver, otherIncomeTextBy, timeout);
	}

	public WebElement getLivingExpenses() {
		return WebDriverWrapper.getWebElement(driver, livingExpensesTextBy, timeout);
	}

	public WebElement getHomeLoanRepayment() {
		return WebDriverWrapper.getWebElement(driver, homeLoanRepaymentTextBy, timeout);
	}

	public WebElement getOtherLoanRepayment() {
		return WebDriverWrapper.getWebElement(driver, otherLoanRepaymentTextBy, timeout);
	}

	public WebElement getMonthlyCommitment() {
		return WebDriverWrapper.getWebElement(driver, monthlyCommitmentTextBy, timeout);
	}

	public WebElement getCreditCardLimit() {
		return WebDriverWrapper.getWebElement(driver, creditCardLimitTextBy, timeout);
	}

	public WebElement getWorkOutBrorrowButton() {
		return WebDriverWrapper.getWebElement(driver, workOutBorrowButtonBy, timeout);
	}

	public WebElement getBorrowResult() {
		return WebDriverWrapper.getWebElement(driver, borrowResultTextBy, timeout);
	}

	public WebElement getErrorText() {
		return WebDriverWrapper.getWebElement(driver, errorTextBy, timeout);
	}
}
