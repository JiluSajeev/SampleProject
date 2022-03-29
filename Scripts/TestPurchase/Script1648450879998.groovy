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
import groovy.ui.Console as Console
import groovy.util.logging.Log as Log
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

String order_confirm_txt = WebUI.getText(findTestObject('Object Repository/PurchasePage/label_Id'))

//reads each line of string
String[] full_text = order_confirm_txt.readLines()

//takes the first line
String idtxt = full_text[0]

//println(idtxt)
//splitting with space
String[] idtxt_split = idtxt.split(' ')

//println(idtxt_split)
// take element after space
String Id = idtxt_split[1]

//println(Id)
WebUI.closeBrowser()