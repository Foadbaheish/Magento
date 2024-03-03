package supoort;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;





public class extentReportClass  implements ITestListener , constants{
	public static ExtentReports extentReport = new ExtentReports();
	public static ExtentSparkReporter HtmlReporter = new ExtentSparkReporter("reports/myReport.html");
	public static ExtentTest extentTest;
	public void onTestStart(ITestResult result) {

		extentReport.attachReporter(HtmlReporter);
		extentTest.log(Status.INFO, "Start Test...");

	}

	public void onTestSuccess(ITestResult result) {

		extentTest.log(Status.PASS, "All Steps are Passed ✓✓");
	}

	public void onTestFailure(ITestResult result) {

		TakesScreenshot driver = null;
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationpath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
				+ result.getName() + ".png";

		File finalDestination = new File(destinationpath);

		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		extentTest.log(Status.FAIL, "Step Is Fail , Click On The Screenshot To Show Erorr !! ..")
				.addScreenCaptureFromPath(destinationpath);

	}

	public void onFinish(ITestContext context) {
		extentTest.log(Status.INFO, "Test Is Done ✓✓");
		extentReport.flush();
	}

}
