package smokeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import com.aventstack.extentreports.Status;
import pageOpject.Actions;
import pageOpject.Assertions;
import supoort.constants;


@Listeners
public class placeOrderFunctionality extends Actions implements constants {
	
	Assertions assertion;
	String currentUrl = "https://magento.softwaretestingboard.com/cms/noroute/index/";
	String product = "shirt";
	String message = "Thank you for your purchase!";
	
	@BeforeSuite
	public void initData() throws InterruptedException {	
		
		assertion = new Assertions();
		extentTest = extentReport.createTest("place Order Functionality","to check place Order functionality");
	    extentTest.log(Status.INFO, "place Order Test Start");
		maximizeBrowoser();
		visitWebsite(currentUrl);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Sign In")));
		typeInSearchInput(product);
		clickRandomProduct();
		choseRandomProductSize();
		choseRandomProductColor();
		typeOnInputField();
		clickOnAddToCartButton();
		clickOnTheShoppingCartIcon();
		clickOnProceedToCheckOut();
		

	}

	@Test(description="place Order Functionality ")
	public void placeOrder() throws InterruptedException{
		String Email =generateRandomEmail();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.name("firstname")));
		typeInEmailInputField(Email);
		typeInFirstNameInputField();
		typeInLastNameInputField();
		typeInStreetAddressInputField();
		typeInCityInputField();
		choseState(42);
		typeInZipCodeInputField();
		choseCountry();
		typeInPhoneNumberInputField();
		clickOnTableRateShippingMethods();
		clickOnNextButton();
		clickOnPlaceOrderButton();
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait4.until(ExpectedConditions.presenceOfElementLocated(By.className("checkout-success")));
		printOrderNumper();
		assertion.checkIfThePurchaseProcessDoneSuccessfully(message);
		
		
		
		
		

}
	@AfterSuite
	public void myAfterTest() {
		//closeBrowser();

	}

	}

