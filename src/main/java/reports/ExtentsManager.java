package reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentsManager {

    private ExtentsManager(){

    }

    private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();


    public static ExtentTest getExtentTest(){
        return extentTestThreadLocal.get();
    }

    static void setExtentTest(ExtentTest test){
        extentTestThreadLocal.set(test);
    }

    static void unloadExtentTest(){
        extentTestThreadLocal.remove();
    }


}
