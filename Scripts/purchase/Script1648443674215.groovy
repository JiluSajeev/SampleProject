import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CustomKeywords.'customKeywords.UserLogin.login'('jilu', 'jilu')

WebUI.click(findTestObject('UserAccountPage/label_titleSony xperia z5'))

WebUI.click(findTestObject('ProductDetail/button_Add to cart'))

WebUI.click(findTestObject('ProductDetail/label_cart'))

WebUI.click(findTestObject('CartPage/button_Place Order'))

WebUI.setText(findTestObject('PurchasePage/input_Name'), 'Jilu')

WebUI.setText(findTestObject('PurchasePage/input_Country'), 'India')

WebUI.setText(findTestObject('PurchasePage/input_City'), 'Trivandrum')

WebUI.setText(findTestObject('PurchasePage/input_Credit card'), '234567')

WebUI.setText(findTestObject('PurchasePage/input_Month'), '08')

WebUI.setText(findTestObject('PurchasePage/input_Year'), '2022')

WebUI.click(findTestObject('PurchasePage/button_Purchase'))

WebUI.verifyElementVisible(findTestObject('PurchasePage/label_Thank you'))

def thankyou = WebUI.getText(findTestObject('PurchasePage/label_Thank you'))

WebUI.verifyMatch(thankyou, 'Thank you for your purchase!', true, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('PurchasePage/popup'))

def text = WebUI.getText(findTestObject('PurchasePage/popup'))

//reads each line of string
String[] full_text = text.readLines()

WebUI.verifyMatch(full_text[1], 'Amount: 320 USD', true, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyMatch(full_text[2], 'Card Number: 234567', true, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyMatch(full_text[3], 'Name: Jilu', true, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyMatch(full_text[4], 'Date: 29/2/2022', true, FailureHandling.STOP_ON_FAILURE)

//takes the first line
String idtxt = full_text[0]

//println(idtxt)
//splitting with space
String[] idtxt_split = idtxt.split(' ')

//println(idtxt_split)
// take element after space
String Id = idtxt_split[1]


//WebUI.verifyTextPresent('Amount: 320 USD Card Number: 234567 Name: Jilu Date: 28/2/2022', false)
//WebUI.verifyMatch(text, '^Id.*', true, FailureHandling.STOP_ON_FAILURE)
//
//WebUI.verifyMatch(text, '.*Amount: 320.*', true, FailureHandling.STOP_ON_FAILURE)
//
//WebUI.verifyMatch(text, '.*Card Number: 234567.*', true, FailureHandling.STOP_ON_FAILURE)
//
//WebUI.verifyMatch(text, '.*Name: Jilu.*', true, FailureHandling.STOP_ON_FAILURE)
//
//WebUI.verifyMatch(text, '.*Date: 28/2/2022.*', true, FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot('C:/Users/jilus/Katalon Studio/TestProject/Reports/screenshots/purchase.png')

WebUI.closeBrowser()