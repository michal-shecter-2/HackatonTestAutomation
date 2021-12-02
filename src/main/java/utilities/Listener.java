package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listener  implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        if (Base.windowsDriver != null || Base.appuimDriver != null || Base.ElectronDriver != null) {
            try {
                MonteScreenRecorder.startRecord(result.getMethod().getMethodName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (Base.windowsDriver != null || Base.appuimDriver != null || Base.ElectronDriver != null) {
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            File file = new File("./test-recordings/" + result.getName() + ".avi");
            if (file.delete()) {
                System.out.println("Recorded Screen Cast File Deleted Successfully");
            } else {
                System.out.println("Failed to Delete the Recorded Screen Cast File");
            }
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (Base.windowsDriver != null || Base.appuimDriver != null || Base.ElectronDriver != null) {

            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
