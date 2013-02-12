package hw3;

public class Main {

    public static void main(String[] args) {

        DataSet train = new DataSet(args[0]);
        DataSet test = new DataSet(args[1]);
        DecisionTree tree;

        //create and train the decision tree
        tree = new DecisionTree(train);
        tree.Learn();

        //test each example and keep count for accuracy
        double correct = 0, total = 0;
        for (int i = 0; i < test.size(); i++) {
            Example e = test.getExample(i);
            if (tree.Test(e)) {
                correct++;
            }
            total++;
        }

        System.out.println("Learner was " + correct / total * 100 + "% accurate.");

    }

}