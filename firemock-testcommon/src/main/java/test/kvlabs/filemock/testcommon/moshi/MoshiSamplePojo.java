package test.kvlabs.filemock.testcommon.moshi;

import java.util.List;
import com.squareup.moshi.Json;
import java.util.Map;

public class MoshiSamplePojo {

    @Json(name = "boolean")
    private Boolean booleanValue;
    @Json(name = "integer")
    private Integer integer;
    @Json(name = "string")
    private String string;
    @Json(name = "sub_object")
    private SubObject subObject;
    @Json(name = "array")
    private List<Integer> array;
    @Json(name = "meta_data")
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
