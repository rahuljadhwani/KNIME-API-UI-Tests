package enums;

public enum SpaceTypes {

    PUBLIC("Public space"),
    PRIVATE("Private space");

    String value;

    SpaceTypes(String value) {
        this.value = value;
    }

    private String getSpaceType(){
        return this.value;
    }

    @Override
    public String toString() {
        return getSpaceType();
    }
}
