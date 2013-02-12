package hw3;

import java.io.Serializable;

public class Attribute implements Serializable {

    private String value;

    public Attribute(String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return this.value;
    }

}
