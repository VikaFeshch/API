package jsonObj.Characters;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

    @JsonProperty("name")//rename variable
    public String mama;
 //   @JsonIgnore
    public String url;
}
