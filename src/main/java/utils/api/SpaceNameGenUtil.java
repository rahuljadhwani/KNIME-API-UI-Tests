package utils.api;

import com.github.javafaker.Faker;

public class SpaceNameGenUtil {

    public static String generateSpaceName(){
        return "New space by "+getSpaceOwnerName();
    }

    private static String getSpaceOwnerName() {
        return new Faker().name().firstName();
    }
}
