package test.kvlabs.filemock.testcommon.model.gson;

import com.google.gson.annotations.Expose;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class GsonSamplePojo {

    @Expose
    @SerializedName("boolean")
    private Boolean booleanValue;
    @Expose
    @SerializedName("integer")
    private Integer integer;
    @Expose
    @SerializedName("string")
    private String string;
    @Expose
    @SerializedName("sub_object")
    private SubObject subObject;
    @Expose
    @SerializedName("array")
    private List<Integer> array;
    @Expose
    @SerializedName("meta_data")
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
