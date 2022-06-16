package constants;

import static utils.api.SpaceNameGenUtil.generateSpaceName;

public final class APIPaths {

    /**
     * Constructor is made private to prevent object-creation of this class, as this class contains all static methods.
     */
    private APIPaths() {

    }

    private static final String baseURI = "https://api.hub.knime.com";
    private static String createSpacePath = "/repository/Users/%s/%s";

    public static String getBaseURI(){
        return baseURI;
    }

    public static String getCreateSpacePath(){
        return String.format(createSpacePath, GlobalConstants.getPropertyMap().get("username"), generateSpaceName());
    }


}
