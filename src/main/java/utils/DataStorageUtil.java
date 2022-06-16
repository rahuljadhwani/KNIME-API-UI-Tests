package utils;

import constants.DataStorage;

import java.util.Objects;

/**
 * This class contains logic for Data sharing in a multi-threaded execution
 *
 */
public class DataStorageUtil {

    private DataStorageUtil(){

    }

    private static ThreadLocal<DataStorage> dataStorageThreadLocal = new ThreadLocal<DataStorage>();

    public static DataStorage getDataStorage(){
        if(Objects.isNull(dataStorageThreadLocal.get())){
            dataStorageThreadLocal.set(new DataStorage());
        }
        return dataStorageThreadLocal.get();
    }

    public static void destroyDataStorage(){
        dataStorageThreadLocal.remove();
    }

}
