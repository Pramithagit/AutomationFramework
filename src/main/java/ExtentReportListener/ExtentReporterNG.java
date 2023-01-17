package ExtentReportListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {


        static ExtentReports extent;
        public static ExtentReports getReportObject(){

            //this method helps in configuring the report(name of the report,title,author, where to create report)
            //String path = System.getProperty("/Users/deepa/Documents/prep/java/TestNG/NewAutomation/reports/Extent.html");   //location for the ExtentRepor
            String path = System.getProperty("user.dir")+("/reports/Extent.html");
            System.out.println(path);
            ExtentSparkReporter reporter = new ExtentSparkReporter(path);//creating object for ExtentSparkReporter
            reporter.config().setReportName("Web Automation results");    //we can configure ExtentReport page using reporter.config()method
            reporter.config().setDocumentTitle("Test Results");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Pramitha");//\reports\Extent.html
            return extent;


        }
    }

