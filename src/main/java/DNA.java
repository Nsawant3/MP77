/**
 * A class that implements a basic binary tree storing integers.
 * <p>
 *
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
public class DNA {

 /** String variable. */
private String sequence = new String();

//CONSTRUCTORS

    /**
     * Create a new DNA instance from the given sequence of base pairs.
     * @param setSequence - parameter to set the Sequence
     *
     */
   DNA(final java.lang.String setSequence) {
        //Create a new DNA instance from the given sequence of base pairs.
    }


    //METHODS

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DNA other = (DNA) obj;
        if (sequence == null) {
            if (other.sequence != null) {
                return false;
            }
        } else if (!sequence.equals(other.sequence)) {
            return false;
        }
        return true;
    }


    /**
     * Return the longest common subsequence of the two provided DNA sequences.
     * You should complete a recursive implementation of this algorithm.
     * You may want to use a helper function so that you can recurse on strings,
     * which have helpful methods, rather than the DNA sequence object.
     * A recursive solution to this problem can get quite slow,
     * particularly as the length of the sequences to compare increases.
     * The testing timeouts provided should be sufficient and will be adjusted as needed.
     * However, feel free to investigate and consider faster approaches.
     *
     * @param firstSequence - the first Sequence
     * @param secondSequence - the second Sequence
     * @return the longest common subsequence between the two provided DNA sequences
     */
    public static DNA getLongestCommonSubsequence(final DNA firstSequence,
            final DNA secondSequence) {
        DNA longestCommonSequence = new DNA("");
        String sequence1String = firstSequence.getSequence();
        String sequence2String = secondSequence.getSequence();
        int longestSequenceLength = 1;

        for (int i = 0; i < sequence1String.length(); i++) {
            for (int j = longestSequenceLength;
                    j < sequence1String.length() - longestSequenceLength; j++) {
                if (sequence2String.contains(sequence1String.substring(i, j))) {
                    longestSequenceLength = j - i + 1;
                    longestCommonSequence = new DNA(sequence1String.substring(i, j));
                }
            }

        }
        return longestCommonSequence;

        //Return the longest common subsequence of the two provided DNA sequences.
    }


    /**
     *Gets the sequence of base pairs for this DNA instance.
     *
     * @return the sequence of base pairs for this DNA instance
     */
    public java.lang.String getSequence() {
        return sequence;
        //Gets the sequence of base pairs for this DNA instance.
    }


    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        if (sequence == null) {
            result = prime * result + (0);
            return result;
        } else {
            result = prime * result + (sequence.hashCode());
            return result;
        }
       // result = prime * result + ((sequence == null) ? 0 : sequence.hashCode());
       // return result;
    }

}
