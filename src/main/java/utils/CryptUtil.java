package utils;

import java.util.Base64;

public final class CryptUtil {

    private CryptUtil(){}

    public static String decodeData(String data){
        return new String(Base64.getDecoder().decode(data));
    }
}
