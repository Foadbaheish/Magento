package pageOpject;

import org.openqa.selenium.By;
import org.testng.Assert;

import supoort.constants;


public class Assertions  implements constants {
	public void checkIfThePurchaseProcessDoneSuccessfully(String message){
		
		Assert.assertEquals(driver.findElement(By.cssSelector(".page-title .base")).getText(),message);
	}
}
