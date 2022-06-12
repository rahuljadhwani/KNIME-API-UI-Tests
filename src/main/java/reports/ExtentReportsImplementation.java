package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.GlobalConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ExtentReportsImplementation {

    private static ExtentReports extentReports;

    public static void initExtentReports(){
        if(Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(GlobalConstants.getExtentReportFilePath());
            extentReports.attachReporter(sparkReporter);
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setDocumentTitle("Test report");
            sparkReporter.config().setReportName("KNIME Tests");
        }
    }


    public static void flushReports(){
        if(Objects.nonNull(extentReports)){
            extentReports.flush();
        }
        //to check
        try {
            Desktop.getDesktop().browse(new File(GlobalConstants.getExtentReportFilePath()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createTest(String testcaseName){
        ExtentsManager.setExtentTest(extentReports.createTest(testcaseName));
    }
}
