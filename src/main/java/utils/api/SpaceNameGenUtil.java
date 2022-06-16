package utils.api;

import com.github.javafaker.Faker;
import utils.DataStorageUtil;

public class SpaceNameGenUtil {

    public static String generateSpaceName(){
        String nameSpace = "New space by "+getSpaceOwnerName();
        DataStorageUtil.getDataStorage().setSpaceName(nameSpace);
        return nameSpace;
    }

    public static String getSpaceName(){
        return DataStorageUtil.getDataStorage().getSpaceName();
    }

    private static String getSpaceOwnerName() {
        return new Faker().name().firstName();
    }
}
