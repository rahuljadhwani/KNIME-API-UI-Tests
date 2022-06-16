package pages.apipojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

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
