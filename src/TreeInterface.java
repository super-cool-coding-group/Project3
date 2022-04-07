package src;

/**
 * This is the most abstract interface for trees - the TreeInterface.
 *
 * This interface has definitions for getting the root data, the height, the number of nodes, the state of the tree being empty,
 * and a way to clear the tree.
 *
 * This is the most basic functionality of having a tree - be it Binary, ternary, ... n-ary.
 * For example, this TreeInterface is extended by the BinaryTreeInterface (which is separately documented) to include
 * definitions for a way to create a tree given two subtrees.
 *
 * Each method is documented separately.
 *
 * @author George Matta
 * @author Matt Dong
 * @version 1.0
 */
public interface TreeInterface<T>{

    /**
     * A method to get the root data of the TreeInterface object
     * @return A generic T-type object of the data.
     */
    public T getRootData();

    /**
     * A method to get the height of the TreeInterface object
     * @return The height of the tree as an int.
     */
    public int getHeight();

    /**
     * A method to get the number of nodes of the TreeInterface object
     * @return The number of nodes the tree has as an int.
     */
    public int getNumberOfNodes();

    /**
     * A method to check if the tree is empty
     * @return A boolean denoting whether or not the tree is empty.
     */
    public boolean isEmpty();

    /**
     * A method to clear the tree. If this method is run, calling isEmpty() will return "true".
     */
    public void clear();

} // end TreeInterface
