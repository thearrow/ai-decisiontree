package hw3;

public class Main {

    public static void main(String[] args) {

        if (args.length != 2)
            printInstructions();

        //create, train, and save the tree
        else if (args[0].equalsIgnoreCase("train")) {
            DataSet train = new DataSet(args[1]);
            DecisionTree tree;
            tree = new DecisionTree(train);
            if (tree.size() > 0) {
                tree.Learn();

                if(TreeManager.saveTree(tree)){
                    System.out.println("Tree created, trained, and saved to 'tree.dat'!");
                    System.out.println("Now run tests using: java hw3/Main test TestData.txt");
                }
            }
            else
                printInstructions();
        }

        //load tree, run test examples and output accuracy
        else if (args[0].equalsIgnoreCase("test")) {
            DataSet test = new DataSet(args[1]);
            DecisionTree tree;
            tree = TreeManager.loadTree();

            if (tree == null) {
                System.out.println("You need to train the Learner first!");
                System.out.println("Use: java hw3/Main train TrainData.txt");
                System.exit(1);
            }

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
            System.out.println("Correctly predicted "+correct+" / "+total+" examples.");
        }

        else
            printInstructions();
    }

    private static void printInstructions() {
        System.out.println("Usage: java hw3/Main {MODE} {FILE}");
        System.out.println("{MODE} = train OR test");
        System.out.println("{FILE} = path to data file");
        System.exit(1);
    }

}