package stepDefinitions;

import pages.HomeLoanCalculator;
import utils.BaseHelper;

public class BaseStep extends BaseHelper{
	private HomeLoanCalculator homeLoanCalculatorPage;
	
	private static BaseStep baseStep;
	
	private BaseStep() {
		try {
			init();
		}catch(Exception e){
			
		}
	}
	
	public static BaseStep getInstance() {
		if(baseStep == null) {
			baseStep = new BaseStep();
		}
		return baseStep;
	}
	public HomeLoanCalculator getHomeLoanCalculator() {
		return homeLoanCalculatorPage;
	}
	public void initializeObjest() {
		homeLoanCalculatorPage = new HomeLoanCalculator(driver, config);
	}

}
