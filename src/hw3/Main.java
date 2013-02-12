package hw3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        DataSet train = new DataSet();
        DataSet test = new DataSet();
        DecisionTree tree;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));

            String line;
            while ((line = reader.readLine()) != null) {
                train.addExample(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tree = new DecisionTree(train);
        tree.Learn();

        try {
            BufferedReader reader2 = new BufferedReader(new FileReader(args[1]));

            String line;
            while ((line = reader2.readLine()) != null) {
                test.addExample(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}