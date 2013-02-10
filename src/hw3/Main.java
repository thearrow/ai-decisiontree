package hw3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        DataSet data = new DataSet();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));

            String line;
            while ((line = reader.readLine()) != null) {
                data.addExample(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DecisionTree tree = new DecisionTree(data);
        tree.splitOnAttributeIndex(3);
        System.out.println(data);

    }
}
