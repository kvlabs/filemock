package test.kvlabs.filemock.testcommon.model.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubObject {

    @SerializedName("a")
    @Expose
    private String a;
    @SerializedName("c")
    @Expose
    private String c;
    @SerializedName("e")
    @Expose
    private String e;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

}
