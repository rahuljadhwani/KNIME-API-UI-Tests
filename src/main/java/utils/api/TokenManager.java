package utils.api;

import org.openqa.selenium.Cookie;

import java.util.Set;

public class TokenManager {

    private static Set<Cookie> webCookies;
    public static String getToken(){

        for(Cookie currentCookie : webCookies){
            if(currentCookie.getName().equals("knime_hub_auth")){
                return currentCookie.getValue();
            }
        }
        return null;

    }

    public static void setCookies(Set<Cookie> cookies){
        webCookies  = cookies;
    }
}
