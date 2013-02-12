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

    public int size() {
        return root.size();
    }

    public boolean rootHasSingleTarget() {
        return root.hasSingleTarget();
    }

    public void splitOnAttributeIndex(int a) {
        splitAttr = a;
        DataSet copy = DataSet.duplicate(root);
        children = copy.splitOnAttributeIndex(a);
    }

    public double calculateGain() {
        double e_root = this.calculateEntropyOfRoot();
        double e_children = 0.0;

        for (DecisionTree child : children) {
            e_children += ((double) child.size() / (double) root.size())
                    * child.calculateEntropyOfRoot();
        }

        //entropy of root - sum((#child/#parent)*entropy of child)
        return e_root - e_children;
    }

    public double calculateEntropyOfRoot() {
        double entropy = 0.0;
        ArrayList<String> targets = root.getAllPossibleTargets();
        int total = root.size();

        for (String t : targets) {
            double pv = (double) root.getCountOfTarget(t) / (double) total;
            entropy += pv * (Math.log(pv) / Math.log(2.0));
        }

        //sum over all possible v's: -P(v)log2(P(v))
        return -entropy;
    }

    public void Learn() {
        int attributes = root.numAttributes();
        int bestAttr = 0;
        double gain, maxGain = 0.0;

        if (!this.rootHasSingleTarget()) {

            //find the best attribute (index) to split on
            for (int i = 0; i < attributes; i++) {
                this.splitOnAttributeIndex(i);
                gain = this.calculateGain();
                if (gain > maxGain) {
                    maxGain = gain;
                    bestAttr = i;
                }
            }

            //split on the best attribute and recursively learn
            //the rest of the tree
            this.splitOnAttributeIndex(bestAttr);
            for (DecisionTree child : children) {
                child.Learn();
            }
        }
    }

    public boolean Test(Example e) {
        boolean correct = false;
        String attr = e.getAttribute(this.splitAttr).getValue();

        if (children.size() == 0) {
            String predictedTarget = root.getExample(0).getTarget();
            if (e.getTarget().equalsIgnoreCase(predictedTarget)) {
                return true;
            } else {
                System.out.println("Predicted: " + predictedTarget +
                        ", Actual: " + e.getTarget());
                System.out.println("For Test Data: " + e + "\n");
            }
        }

        for (DecisionTree child : children) {
            if (attr.equalsIgnoreCase(child.root.getAttribute(splitAttr).getValue())) {
                correct = child.Test(e);
            }
        }

        return correct;
    }

}