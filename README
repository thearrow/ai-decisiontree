Jacob Klingler
klingler.45@osu.edu
klinglej

AI Homework #3 - Decision Tree

COMPILE:
    (in klinglerHW3 folder):
    javac hw3/*.java

RUN:
    TRAIN:
        java hw3/Main train train.txt
        ...where train.txt is training data

    TEST:
        java hw3/Main test test.txt
        ...where test.txt is testing data


ABOUT:
    Program implements standard algorithm covered in class
    to construct a decision tree using the principles of
    information entropy and information gain.

    After training, the DecisionTree is saved to a file,
    tree.dat, in the working directory using standard
    Java Object Serialization (not easily human-readable).
    During testing the tree is then loaded from this file.

    The program should be very generalizable - it should
    work well with all kinds of data with varying attribute
    counts and types, as long as the input data is in the
    form:
      attribute1,attribute2,attribute3,...attributeN,target


RESULTS:
    I tested the program using the sample training/test data
    given in the assignment (the 'string' versions).

    Training the Learner with the learning data and then testing
    on the test data, the Learner was able to reach 100% accuracy.

    Reversing the data files (training on the test file with only
    50 examples and testing on the original training file with 200
    examples), the learner was still able to achieve 87.5% accuracy.

    These high accuracy ratings are almost certainly due to the way
    the sample data was engineered - to provide something easily
    learnable.


