package hw3;

import java.util.ArrayList;

public class DecisionTree {

    private Attribute splitAttr;
    private DataSet root;
    private ArrayList<DecisionTree> children;

    public DecisionTree(DataSet d) {
        root = d;
        children = new ArrayList<DecisionTree>();
    }

    public void splitOnAttributeIndex(int a) {
        splitAttr = root.getAttribute(a);
        children = root.splitOnAttributeIndex(a);
    }
}
