package hw3;

import java.util.ArrayList;

public class DataSet {

    private ArrayList<Example> examples;

    public DataSet() {
        examples = new ArrayList<Example>();
    }

    public void addExample(String str) {
        Example e = new Example(str);
        examples.add(e);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < examples.size(); i++) {
            sb.append("Example ");
            sb.append(i);
            sb.append(": ");
            sb.append(examples.get(i));
        }
        return sb.toString();
    }

}
