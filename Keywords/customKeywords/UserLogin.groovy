package customKeywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class UserLogin {

	@Keyword
	def login(String username,String password) {

		WebUI.openBrowser('')

		WebUI.navigateToUrl(GlobalVariable.URL)

		WebUI.maximizeWindow()

		WebUI.click(findTestObject('HomePage/label_Login'))

		WebUI.setText(findTestObject('LoginPage/input_txtusername'), username)

		WebUI.setText(findTestObject('LoginPage/input_txtpassword'), password)

		WebUI.click(findTestObject('Object Repository/LoginPage/button_Log in'))

		WebUI.verifyElementText(findTestObject('UserAccountPage/label_Welcomeuser'), 'Welcome '+username)
	}
}
