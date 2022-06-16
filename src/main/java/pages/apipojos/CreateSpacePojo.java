package pages.apipojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * This class is used to create API request body as java object for Create Spaces functionality
 *
 */
public class CreateSpacePojo {

    @Setter
    @Getter
    @JsonProperty("private")
    private boolean isPrivateSpace;

    @Setter
    @Getter
    @JsonProperty("type")
    private String type;


}
