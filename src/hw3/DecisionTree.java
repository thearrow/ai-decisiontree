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

    public int rootSize(){
        return root.size();
    }

    public double calculateGain(){
        //entropy of root - sum((#child/#parent)*entropy of child)

        double e_root = this.calculateEntropyOfRoot();
        double e_children = 0.0;

        for (DecisionTree tree : children) {
            e_children += ((double)tree.rootSize()/(double)root.size())*tree.calculateEntropyOfRoot();
        }

        return e_root - e_children;
    }

    public double calculateEntropyOfRoot() {
        //sum over all possible v's: -P(v)log2(P(v))

        double entropy = 0.0;
        ArrayList<String> targets = root.getAllPossibleTargets();
        int total = root.size();

        for (String t : targets) {
            double pv = (double)root.getCountOfTarget(t)/(double)total;

            entropy += pv*(Math.log(pv)/Math.log(2.0));
        }

        return -entropy;
    }

}