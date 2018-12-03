package com.cavisson.pagemodel;

import com.automation.cavisson.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
public class TotalScenariosPage extends PageModel{
	@FindBy(xpath="//button[@label='Create']")
	WebElement createScenario;
	@FindBy(xpath="//span[text()='Delete']/preceding-sibling::span[contains(@class,'fa-trash')]/parent::button")
	WebElement deleteScenario;
	@FindBy(id="in")
	WebElement searchScenarioBox;
	@FindBy(xpath="//div[@class='sectionButton']//*[text()='Apply']/parent::button")
	WebElement applyButton;
        String scenarioCheckBoxXpath = "//a/span[text()='%s']/ancestor::td/preceding-sibling::td[@class='ui-selection-column']/p-dtcheckbox/div/div[contains(@class,'ui-chkbox-box')]";
	private String projectName;
	private String subProjectName;
	private String scenarioName;
	public TotalScenariosPage (CavissonDriver driver,String testCaseName){
		super(driver);
		setTestCaseName(testCaseName);
	}
	public void setScenarioName(String scenarioName){
		this.scenarioName=scenarioName;
	}
        public String getScenarioName(){
		return this.scenarioName;
	}
	public void executeCreateScenario(){
		getDriver().click( createScenario , getTestCaseName());		
	}
        public void executeDeleteScenario(){
		getDriver().click( deleteScenario, getTestCaseName());		
	}
	public void enterScenarioNameToSearch(){
		getDriver().sendKeys( searchScenarioBox , getScenarioName(), getTestCaseName());
	}
        public void applySearch(){
		getDriver().click( applyButton, getTestCaseName());		
	}
	public void selectScenarioToDelete(){
		getDriver().click( getDriver().getBaseDriver().findElement(By.xpath(String.format(scenarioCheckBoxXpath,getScenarioName()))), getTestCaseName());
	}	
}
