// CHECKSTYLE:OFF:FileLength
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.testng.annotations.Test;

import junit.framework.Assert;


//MP7 test file
/**
 * Test suite for the Tree class.
 * <p>
 * The provided test suite is correct and complete. You should not need to modify it. However, you
 * should understand it. You may need to augment or write test suites for later MPs.
 *
 * @see <a href="https://cs125.cs.illinois.edu/MP/6/">MP6 Documentation</a>
 */
@SuppressWarnings("checkstyle:magicnumber")
public class TreeTest {

    // TODO
    /** Timeout for tree tests. */
    private static final int TREE_TEST_TIMEOUT = 1000;


    public static void main(String args[]) {
        System.out.println("MP7" + '\n');
       Tree tree = new Tree((int)(Math.random()*100) + 1);
       for (int i = 0; i < 15; i++) {
           tree.insert((int)(Math.random()*100) + 1);
       }
        System.out.println("Tree Nodes Printed: ");
        tree.traversePreRecursive(tree);
        System.out.print('\n');
        System.out.println("Total Nodes: " + (tree.binaryToArray(tree)).length);
        System.out.print('\n');
        System.out.println("Total Sum: " + tree.totalSum(tree));
        System.out.print('\n');
        System.out.println("Left Sum: " + tree.leftSum(tree));
        System.out.print('\n');
        System.out.println("Right Sum: " + tree.rightSum(tree));
        System.out.print('\n');
        int treeArray[] = tree.binaryToArray(tree);
        System.out.println("Array Length = " + (treeArray).length);
        System.out.print('\n');
        System.out.println("Printed Array: ");
        System.out.println(Arrays.toString(treeArray));
        System.out.print('\n');
        System.out.println("Tree Printed Minimum to Maximum: ");
        tree.minToMax(tree);
        System.out.print('\n');
        System.out.println("Tree Printed Maximum to Minimum: ");
        tree.maxToMin(tree);


    }


}
