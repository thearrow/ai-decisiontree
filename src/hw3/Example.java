package hw3;

import java.io.Serializable;
import java.util.ArrayList;

public class Example implements Serializable {

    ArrayList<Attribute> attributes;
    private String target;

    public Example(String str) {
        attributes = new ArrayList<Attribute>();
        String[] attrs = str.split(",");
        for (int i = 0; i < attrs.length - 1; i++) {
            this.addAttribute(attrs[i]);
        }
        target = attrs[attrs.length - 1];
    }

    public void addAttribute(String value) {
        Attribute atr = new Attribute(value);
        attributes.add(atr);
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Attribute getAttribute(int a) {
        return attributes.get(a);
    }

    public int numAttributes() {
        return attributes.size();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("(");
        for (Attribute a : attributes) {
            result.append(a);
            result.append(", ");
        }
        result.append("Target: ");
        result.append(target);
        result.append(")");

        return result.toString();
    }

}