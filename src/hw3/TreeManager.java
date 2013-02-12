package hw3;

import java.io.*;

public class TreeManager {
    //be lazy and use java serializable magic to save/load DecisionTree

    public static boolean saveTree(DecisionTree tree) {
        try {
            //use buffering
            ObjectOutput output =
                    new ObjectOutputStream(
                            new BufferedOutputStream(
                                    new FileOutputStream("tree.dat")));
            try {
                output.writeObject(tree);
            } finally {
                output.close();
            }
        } catch (IOException ex) {
            System.out.println("Error saving tree! " + ex);
            return false;
        }
        return true;
    }

    public static DecisionTree loadTree() {
        DecisionTree tree = null;
        try {
            //use buffering
            ObjectInput input =
                    new ObjectInputStream(
                            new BufferedInputStream(
                                    new FileInputStream("tree.dat")));
            try {
                //deserialize the tree
                tree = (DecisionTree) input.readObject();
            } finally {
                input.close();
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error reading tree! "+ex);
        } catch (IOException ex) {
            System.out.println("Error reading tree! "+ex);
        }
        return tree;
    }

}
