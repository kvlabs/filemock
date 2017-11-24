
package test.kvlabs.filemock.testcommon.moshi;

import com.squareup.moshi.Json;

public class SubObject {

    @Json(name = "a")
    private String a;
    @Json(name = "c")
    private String c;
    @Json(name = "e")
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
