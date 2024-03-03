package pageOpject;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import supoort.constants;
import supoort.extentReportClass;
public class Actions extends extentReportClass implements constants   {


public void maximizeBrowoser() {
		driver.manage().window().maximize();

	}
	

	public void visitWebsite(String currentUrl) {
		driver.get(currentUrl);
	}

	public void typeInSearchInput(String product) {
		
		WebElement inputField = driver.findElement(By.id("search"));
		inputField.clear();
		inputField.sendKeys(product + Keys.ENTER);
	}

	public void closeBrowser() {

		driver.close();
	}

	public void clickRandomProduct() {

		List<WebElement> Product = driver.findElements(By.className("product-image-photo"));
		if (!Product.isEmpty()) {
			Random random = new Random();
			int randomIndex = random.nextInt(Product.size());
			WebElement randomProduct = Product.get(randomIndex);

			randomProduct.click();
		}
	}

	public void choseRandomProductSize() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".size .swatch-option")));

		List<WebElement> productSizeElements = driver.findElements(By.cssSelector(".size .swatch-option"));

		if (!productSizeElements.isEmpty()) {
			Random random = new Random();
			int randomIndex = random.nextInt(productSizeElements.size());

			WebElement randomProductElement = productSizeElements.get(randomIndex);
			randomProductElement.click();
		}

	}

	public void choseRandomProductColor() {
		List<WebElement> colorElements = driver.findElements(By.cssSelector(".swatch-option.color"));

		if (!colorElements.isEmpty()) {
			Random random = new Random();
			int randomIndex = random.nextInt(colorElements.size());

			WebElement randomColorElement = colorElements.get(randomIndex);
			randomColorElement.click();
		}
	}

	public void typeOnInputField() {

		WebElement inputField = driver.findElement(By.id("qty"));

		inputField.clear();

		Random random = new Random();
		int randomNumber = random.nextInt(10) + 1;

		inputField.sendKeys(String.valueOf(randomNumber));

	}

	public void clickOnAddToCartButton() {
		driver.findElement(By.className("tocart")).click();
	}

	public void clickOnTheShoppingCartIcon() throws InterruptedException  {

		Thread.sleep(2000); 
		driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();

	}

	public void clickOnProceedToCheckOut() throws InterruptedException {

		driver.findElement(By.id("top-cart-btn-checkout")).click();
	}

	public static String generateRandomEmail() {
		int min = 0;
		int max = 99;
		int randomNumber = (int) (Math.random() * (max - min + 1) + min);
		return "foad.user" + randomNumber + "@hotmail.com";
	}

	public void typeInEmailInputField(String Email) throws InterruptedException  {

		WebElement inputField = driver.findElement(By.id("customer-email"));
		inputField.clear();
		inputField.sendKeys(Email);
	}

	public void typeInFirstNameInputField() throws InterruptedException {
		WebElement inputField = driver.findElement(By.name("firstname"));
		inputField.clear();
		inputField.sendKeys("Foad");
	}

	public void typeInLastNameInputField() {
		WebElement inputField = driver.findElement(By.name("lastname"));
		inputField.clear();
		inputField.sendKeys("user");
	}

	public void typeInStreetAddressInputField() {
		WebElement inputField = driver.findElement(By.name("street[0]"));
		inputField.clear();
		inputField.sendKeys("New York Street");
	}

	public void typeInCityInputField() {
		WebElement inputField = driver.findElement(By.name("city"));
		inputField.clear();
		inputField.sendKeys("New York");
	}

	public void choseState(int index) {
		WebElement element = driver.findElement(By.name("region_id"));
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
	}

	public void typeInZipCodeInputField() {
		WebElement inputField = driver.findElement(By.name("postcode"));
		inputField.clear();
		inputField.sendKeys("10005");
	}

	public void choseCountry() {
		WebElement element = driver.findElement(By.name("country_id"));
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText("United States");
	}

	public void typeInPhoneNumberInputField() {
		WebElement inputField = driver.findElement(By.name("telephone"));
		inputField.clear();
		inputField.sendKeys("0599964666");
	}

	public void clickOnTableRateShippingMethods() {
		driver.findElement(RelativeLocator.with(By.className("radio")).near(By.tagName("td"))).click();

	}

	public void clickOnNextButton() {
		driver.findElement(By.className("continue")).click();
	}

	public void clickOnPlaceOrderButton() throws InterruptedException {
		 Thread.sleep(2500);
		driver.findElement(By.cssSelector(".action.primary.checkout")).click();
	}

	public void printOrderNumper() {
		
		WebElement order = driver
				.findElement(RelativeLocator.with(By.tagName("span")).near(By.className("checkout-success")));
		String orderNumber = order.getText();
		System.out.println("The Order Number Is : " + orderNumber);
	}



}
