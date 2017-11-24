package test.kvlabs.filemock.testcommon.jackson2;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "boolean",
    "integer",
    "string",
    "sub_object",
    "array",
    "meta_data"
})
public class Jackson2SamplePojo {

    @JsonProperty("boolean")
    private Boolean booleanValue;
    @JsonProperty("integer")
    private Integer integer;
    @JsonProperty("string")
    private String string;
    @JsonProperty("sub_object")
    private SubObject subObject;
    @JsonProperty("array")
    private List<Integer> array;
    @JsonProperty("meta_data")
    private Map<String, String> metaData;

    public Boolean getBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(Boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public SubObject getSubObject() {
        return subObject;
    }

    public void setSubObject(SubObject subObject) {
        this.subObject = subObject;
    }

    public List<Integer> getArray() {
        return array;
    }

    public void setArray(List<Integer> array) {
        this.array = array;
    }

    public Map<String, String> getMetaData() {
        return metaData;
    }

    public void setMetaData(Map<String, String> metaData) {
        this.metaData = metaData;
    }
    
    

}
