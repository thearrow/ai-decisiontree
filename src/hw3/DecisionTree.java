package hw3;

import java.util.ArrayList;

public class DecisionTree {

    private int splitAttr;
    private DataSet root;
    private ArrayList<DecisionTree> children;

    public DecisionTree(DataSet d) {
        root = d;
        children = new ArrayList<DecisionTree>();
    }

    public void splitOnAttributeIndex(int a) {
        splitAttr = a;
        DataSet copy = DataSet.duplicate(root);
        children = copy.splitOnAttributeIndex(a);
    }

}