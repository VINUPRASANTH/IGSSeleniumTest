package stepDefinitions;

import java.util.Map;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import pages.HomeLoanCalculator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorDefinition {
	WebDriver driver;
	static WebDriver refDriver;
	WebDriverWait wait;
	BaseStep baseStep;
	HomeLoanCalculator homeLoanCalculator;
	Properties testData;
	SoftAssert softAssert;

	@Before
	public void initHomeLoan() {
		baseStep = BaseStep.getInstance();
		driver = BaseStep.driver;
		homeLoanCalculator = baseStep.getHomeLoanCalculator();
		testData = baseStep.getConfig();
		softAssert = new SoftAssert();

	}

	@Given("^Launch the Home Loan Calculator Application$")
	public void launchCalculatorApp() {
		driver.get(testData.getProperty("url"));
		driver.manage().window().maximize();
		System.out.println("Application Launched " + testData.getProperty("url"));
	}

	@When("^Loan calculator application loaded successfully$")
	public void checkApplicationLoadedSuccessFully() {
		Assert.assertTrue(homeLoanCalculator.isPageLoaded("How much could I borrow?"));
		System.out.println("App Loaded");
	}

	@Then("^Enter the application form details$")
	public void enterLoanApplicationDetails(DataTable dataTable) {
		Map<String, String> obj = dataTable.asMap();
		if (obj.get("ApplicationType").equals("Single")) {
			homeLoanCalculator.clickSingleTypeButton();
		} else {
			homeLoanCalculator.clickJointTypeButton();
		}
		homeLoanCalculator.selectNoOfDependants(obj.get("Dependants"));
		if (obj.get("PuyingProperty").equals("Home to live in")) {
			homeLoanCalculator.clickHomePropertyButton();
		} else {
			homeLoanCalculator.clickInvestmentPropertyButton();
		}
		homeLoanCalculator.setAnnualIncome(obj.get("AnnualIncome"));
		homeLoanCalculator.setOtherIncome(obj.get("OtherIncome"));

		homeLoanCalculator.setLivingExpenses(obj.get("LivingExpense"));
		homeLoanCalculator.setHomeLoanRepaymentValue(obj.get("HomeLoanRepayment"));
		homeLoanCalculator.setOtherLoanRepaymentValue(obj.get("OtherLoanRepayment"));
		homeLoanCalculator.setMonthlyCommitments(obj.get("OtherCommitments"));
		homeLoanCalculator.setCreditCardLimit(obj.get("CreditCardLimit"));

	}

	@Then("^Click 'Work out how much I could borrow' button$")
	public void clickOnWorkOutButton() {
		homeLoanCalculator.clickWorkOutBorrowButton();
	}

	@Then("^Verify the estimated amount is (.*)$")
	public void verifyEstimatedAmount(String expectedEstimation) throws InterruptedException {

		Thread.sleep(5000);
		String actual = homeLoanCalculator.getEstimatedResult();
		softAssert.assertEquals(actual, expectedEstimation,
				"Expected value = " + expectedEstimation + " actual value = " + actual);

	}

	@Then("^Click 'Start Over' button to reset the form$")
	public void clickStartOverButton() {
		homeLoanCalculator.clickStartOverButton();
	}

	@Then("^Verify form values are reset$")
	public void verifyDefaultState() {

		softAssert.assertEquals(homeLoanCalculator.getSelectedApplication().getText(), "Single");
		softAssert.assertEquals(homeLoanCalculator.getDependantElement().getText(), "0");
		softAssert.assertEquals(homeLoanCalculator.getSelectedProperty().getText(), "Home to live in");
		softAssert.assertEquals(homeLoanCalculator.getAnnualIncome().getText(), "", "Annual income should be empty");
		softAssert.assertEquals(homeLoanCalculator.getOtherIncome().getText(), "", "Other income should be empty");
		softAssert.assertEquals(homeLoanCalculator.getLivingExpenses().getText(), "", "Living expense should be empty");
		softAssert.assertEquals(homeLoanCalculator.getHomeLoanRepayment().getText(), "",
				"Home Loan Repayment should be empty");
		softAssert.assertEquals(homeLoanCalculator.getOtherLoanRepayment().getText(), "",
				"Other Loan Repayment should be empty");
		softAssert.assertEquals(homeLoanCalculator.getMonthlyCommitment().getText(), "");
		softAssert.assertEquals(homeLoanCalculator.getCreditCardLimit().getAttribute("value"), "0");
		softAssert.assertEquals(homeLoanCalculator.getWorkOutBrorrowButton().isDisplayed(), true);
		softAssert.assertEquals(homeLoanCalculator.getEstimatedResult(), "$0");

	}

	@Then("Enter living expense {string}")
	public void enter_living_expense(String livingExpense) {
		homeLoanCalculator.setLivingExpenses(livingExpense);
	}

	@Then("Verify application displays the message as {string}")
	public void verify_application_displays_the_message_as(String expectedText) {
		String actualResult = homeLoanCalculator.getErrorText().getText();
		softAssert.assertEquals(actualResult, expectedText,
				"Actual : " + actualResult + "\n Expected : " + expectedText);
	}

	@After
	public void teardown() {
		softAssert.assertAll();
		refDriver = driver;

	}

	@AfterAll
	public static void afterAll() {
		refDriver.quit();
	}

}
