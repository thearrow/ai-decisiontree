package hw3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataSet {

    private ArrayList<Example> examples;

    public DataSet() {
        examples = new ArrayList<Example>();
    }

    public DataSet(String filePath) {
        examples = new ArrayList<Example>();

        //read in data from file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line;
            while ((line = reader.readLine()) != null) {
                this.addExample(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DataSet duplicate(DataSet d) {
        DataSet newDataSet = new DataSet();

        for (int i = 0; i < d.size(); i++) {
            newDataSet.addExample(d.getExample(i));
        }

        return newDataSet;
    }

    public void addExample(String str) {
        Example e = new Example(str);
        examples.add(e);
    }

    public void addExample(Example e) {
        examples.add(e);
    }

    public Example getExample(int e) {
        return examples.get(e);
    }

    public Attribute getAttribute(int a) {
        return examples.get(0).getAttribute(a);
    }

    public int numAttributes() {
        return examples.get(0).numAttributes();
    }

    public int size() {
        return examples.size();
    }

    public ArrayList<DecisionTree> splitOnAttributeIndex(int a) {
        ArrayList<DecisionTree> result = new ArrayList<DecisionTree>();
        ArrayList<Example> tempExamples = examples;

        for (int i = 0; i < tempExamples.size(); i++) {
            DataSet data = new DataSet();

            Example outer = tempExamples.remove(i);
            String attValue = outer.getAttribute(a).getValue().trim();
            data.addExample(outer);
            for (int j = i; j < tempExamples.size(); j++) {
                Example temp = tempExamples.get(j);
                if (temp.getAttribute(a).getValue().trim().equalsIgnoreCase(attValue)) {
                    data.addExample(tempExamples.remove(j));
                    //decrement j to compensate for removal
                    j--;
                }
            }
            //decrement i to compensate for removal
            i--;
            DecisionTree tree = new DecisionTree(data);
            result.add(tree);
        }

        return result;
    }

    public ArrayList<String> getAllPossibleTargets() {
        ArrayList<String> targets = new ArrayList<String>();

        for (Example e : examples) {
            if (!targets.contains(e.getTarget())) {
                targets.add(e.getTarget());
            }
        }

        return targets;
    }

    public int getCountOfTarget(String t) {
        int count = 0;

        for (Example e : examples) {
            if (e.getTarget().equalsIgnoreCase(t)) {
                count++;
            }
        }

        return count;
    }

    public boolean hasSingleTarget() {
        boolean result = true;
        String target = examples.get(0).getTarget();

        for (Example e : examples) {
            if (!e.getTarget().equalsIgnoreCase(target)) {
                result = false;
            }
        }

        return result;
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