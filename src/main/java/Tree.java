/**
 * A class that implements a basic binary tree storing integers.
 * <p>
 * You need to complete this class by adding methods to insert values, compute the minimum and
 * maximum, search for a value, and compute a value's depth in the tree and number of descendants.
 * You will also need to complete several constructors used during tree creation and value
 * insertion.
 * <p>
 * Our binary tree is an example of a <i>recursive data structure</i>, since each tree instance
 * refers to several other tree instances to complete the entire structure. As you might expect,
 * recursive algorithms are particularly useful on recursive data structures.
 *
 * @see <a href="https://cs125.cs.illinois.edu/MP/6/">MP6 Documentation</a>
 * @see <a href="https://en.wikipedia.org/wiki/Binary_tree">Binary Tree</a>
 */
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
//MP7!!!!!!!!!
/**
 * A class that implements binary tree functions.
 *
 * Some functions use a recursive data structure, since each tree instance
 * refers to several other tree instances to complete the entire structure.
 *
 */
public class Tree {

    /** Current node's parent. May be null if I'm the root of the tree. */
    private Tree parent;

    /** Current node's left child, or null if none. */
    private Tree left;

    /** Current node's right child, or null if none. */
    private Tree right;

    /** Current node's value. */
    private int value;


    /** Current node's value. */
    private static int counter = 0;

    /** left total value. */
    private static int totalL = 0;


    /** right total value. */
    private static int totalR = 0;

    //CONSTRUCTORS

    /**
     * Initialize a new binary tree.
     * @param setValue - value for the root of the tree
     *
     */
    Tree(final int setValue) {
        this.value = setValue;
        this.parent = null;
      //Initialize a new binary tree.
    }


    /**
     * Initialize a new binary tree node for an existing tree.
     * @param setValue - value for the root of the tree
     * @param setParent - the parent of this node
     */
    Tree(final int setValue, final Tree setParent) {
        this.value = setValue;
        this.parent = setParent;

        //Initialize a new binary tree node for an existing tree.
    }


    //METHODS



    /**
     * Insert a new value into the binary tree.
     *
     * @param newValue - the new value to insert
     * @return true if the value does not already
     * exist and is successfully inserted, false otherwise
     */
    public boolean insert(final int newValue) {
          return getRoot().insertAsRoot(newValue);
    }

    /**
     * This assumes that the root will first call this method
     * and inserts by recursively finding and place to insert the leaf to the tree.
     * @param newValue The value of the new node to be added
     * @return whether or not the new node has been inserted
     */
    private boolean insertAsRoot(final int newValue) {
        if (newValue > value) {
            if (right != null) {
                return right.insertAsRoot(newValue);
            } else {
                right = new Tree(newValue, this);
                return true;
            }
        } else if (newValue < value) {
            if (left != null) {
                return left.insertAsRoot(newValue);
            } else {
                left = new Tree(newValue, this);
                return true;
            }
        } else {
            return false;
        }
    }






    /**
     * Gets the root from any point in the graph.
     * @return the root of the tree
     */
    public Tree getRoot() {
        if (parent != null) {
            return parent.getRoot();
        } else {
            return this;
        }
    }




    /**
     * This goes from the top down recursively searches the tree to find the specific value.
     * @param tree - a tree to parse
     *
     */
public void traversePreRecursive(final Tree tree) {
    if (tree != null) {
        System.out.println(tree.value);
        counter++;
        traversePreRecursive(tree.left);
        traversePreRecursive(tree.right);
    }

}


/**
 * This goes from the top down recursively searches the tree to find the specific value.
 * @param tree - a tree to parse
 *
 */
public void minToMax(final Tree tree) { // Each child of a tree is a root of its subtree.
    if (tree.left != null) {
        minToMax(tree.left);
    }
    System.out.println(tree.value);
    if (tree.right != null) {
        minToMax(tree.right);
    }
}




/**
 * This goes from the top down recursively searches the tree to find the specific value.
 * @param tree - a tree to parse
 *
 */
public void maxToMin(final Tree tree) { // Each child of a tree is a root of its subtree.
    if (tree.right != null) {
        maxToMin(tree.right);
    }
    System.out.println(tree.value);
    if (tree.left != null) {
        maxToMin(tree.left);
    }
}



/**
 * This goes from the top down recursively searches the tree to find the specific value.
 * @param tree - a tree to parse
 * @return int
 */
public int leftSum(final Tree tree) { // Each child of a tree is a root of its subtree.
    if (tree.left != null) {
        leftSum(tree.left);
    }
    totalL = totalL + tree.value;
    return totalL;
}



/**
 * This goes from the top down recursively searches the tree to find the specific value.
 * @param tree - a tree to parse
 * @return int
 */
public int rightSum(final Tree tree) { // Each child of a tree is a root of its subtree.
    int totalSum = tree.totalSum(tree);
    int leftSum = (tree.leftSum(tree)) / 2;
    int rightSum = totalSum - leftSum;
    return rightSum;

}



/**
 * This goes from the top down recursively searches the tree to find the specific value.
 * @param tree - a tree to parse
 * @return int
 */
@SuppressWarnings("static-access")
public int totalSum(final Tree tree) {
    int[] array = tree.binaryToArray(tree);
    int total = 0;
    for (int i = 0; i < array.length; i++) {
        total = total + array[i];
    }
    return total;
}






/**
 * This goes from the top down recursively searches the tree to find the specific value.
 * @param tree - a tree to parse
 * @return int
 */
public static int[] binaryToArray(final Tree tree) {
    return convertIntegers(binaryToArrayRecursive(tree, new ArrayList<Integer>()));
}



/**
 * This goes from the top down recursively searches the tree to find the specific value.
 * @param tree - a tree to parse
 * @param valueArray - please
 * @return int
 */
private static ArrayList<Integer> binaryToArrayRecursive(final Tree tree,
        final ArrayList<Integer> valueArray) {
    if (tree == null) {
        return valueArray;
    } else {
        valueArray.add(tree.value);
        if (tree.left != null) {
            valueArray.addAll(binaryToArrayRecursive(tree.left, new ArrayList<Integer>()));
        }
        if (tree.right != null) {
            valueArray.addAll(binaryToArrayRecursive(tree.right, new ArrayList<Integer>()));
        }
        return valueArray;

    }
}


/**
 * This goes from the top down recursively searches the tree to find the specific value.
 * @param integers - a tree to parse
 * @return int
 */
public static int[] convertIntegers(final ArrayList<Integer> integers) {
    int[] ret = new int[integers.size()];
    for (int i = 0; i < ret.length; i++) {
        ret[i] = integers.get(i).intValue();
    }
    return ret;
}




/**
* This goes from the top down recursively searches the tree to find the specific value.
* @param tree - a tree to parse
* @return int
*/
public int totalNodes(final Tree tree) {
   tree.traversePreRecursive(tree);
   return counter;
}





}


