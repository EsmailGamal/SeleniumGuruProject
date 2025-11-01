package support;

import drivers.DriverHolder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestListeners implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverHolder.getDriver();
        if (driver instanceof TakesScreenshot) {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String methodName = result.getMethod().getMethodName();
            Path targetDir = Path.of("target", "screenshots");
            Path targetFile = targetDir.resolve(methodName + "_" + timestamp + ".png");
            try {
                Files.createDirectories(targetDir);
                Files.copy(src.toPath(), targetFile, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("[SCREENSHOT] Saved to: " + targetFile.toAbsolutePath());
            } catch (IOException e) {
                System.err.println("[ERROR] Failed to save screenshot: " + e.getMessage());
            }
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("[TEST-START] " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("[TEST-SUCCESS] " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("[TEST-SKIPPED] " + result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("[SUITE-START] " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("[SUITE-FINISH] " + context.getName());
    }
}


