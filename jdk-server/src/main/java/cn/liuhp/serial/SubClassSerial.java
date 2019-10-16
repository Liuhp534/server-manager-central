package cn.liuhp.serial;

import java.io.Serializable;

public class SubClassSerial implements Serializable {

    //private static final long serialVersionUID = -4625535012041179847L;

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
