package constants;

import lombok.Getter;
import lombok.Setter;

/**
 * This class will be used to set and get data in a multi-threaded environment
 */
public class DataStorage {

    @Setter
    @Getter
    private String spaceName;

}
