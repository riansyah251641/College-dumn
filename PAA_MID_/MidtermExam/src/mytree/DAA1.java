package mytree;

public class DAA1 extends MyTree {

    // Binary Search Tree (BST)
    // 1. isBST() [20 points]
    public static boolean isBST(MyTree t) {
        return isBST(t, Integer.MIN_VALUE, Integer.MAX_VALUE, 1);
    }

    // Helper function for isBST
    // Get a boolean value to know whether 't' is BST (Binary Search Tree)
    // whose values are within the range between lowerBound and upperBound
    private static boolean isBST(MyTree t, int lowerBound, int upperBound, int i) {
        if (t == null)
            return true;
        i += 1;
        if (t.getValue() < lowerBound || t.getValue() > upperBound)
            return false;

        return (isBST(t.getLeft(), lowerBound, t.getValue() - 1, i)
                && isBST(t.getRight(), t.getValue() + 1, upperBound, i));
    }

    // 2. printDescending() [10 points]
    public static void printDescending(MyTree t) {
        if (t == null)
            return;
        else if (!t.getEmpty()) {
            printDescending(t.getRight());
            System.out.println(" " + t.getValue());
            printDescending(t.getLeft());
        }
    }

    // 3. max() [10 points]
    /**
     * You have to:
     * - handle empty trees
     * - never look at left
     * - never compares values, i.e., the value of t and the right,
     * because it's not necessary if it's BST.
     * - returns the right value as soon as found
     *
     * @param t is the tree being searched for the max value
     * @return the max value of tree t
     */
    public static int max(MyTree t) {
        if (t == null || t.getEmpty()) {
            return Integer.MIN_VALUE;
        }
        return Math.max(t.getValue(), max(t.getRight()));
    }

}