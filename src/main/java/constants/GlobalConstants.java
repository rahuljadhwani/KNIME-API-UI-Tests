package constants;

import lombok.Getter;
import lombok.Setter;
import utils.PropertyReaderUtil;

import java.util.HashMap;

public class GlobalConstants {

    static  {
        GlobalConstants.setPropertyMap(PropertyReaderUtil.readPropertyFileAsMap(GlobalConstants.getFrameworkPropertyFilePath()));
    }

    @Getter
    private static final String frameworkPropertyFilePath = "src/main/resources/project-details.properties";

    @Getter
    private static final int EXPLICIT_WAIT_TIMEOUT = 30;

    @Getter
    @Setter
    private static HashMap<String, String> propertyMap;

    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-test-output/";
    private static String extentReportFilePath = "";


    public static String getExtentReportFilePath(){
        if(extentReportFilePath.isEmpty()){
            extentReportFilePath = createExtentReportPath();
        }
        return extentReportFilePath;
    }

    private static String createExtentReportPath() {
        return EXTENTREPORTFOLDERPATH+"/index.html";
    }

}
