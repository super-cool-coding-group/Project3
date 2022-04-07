package src;

/**
 * This is the BinaryTreeInterface which extends the TreeInterface - a separately documented interface.
 *
 * The BinaryTreeInterface introduces two additional methods: setRootData and setTree.
 *
 * While all trees have a height, nodes, the state of being empty, and the functionality of being cleared, a Binary tree
 * has the property of having a maximum of two subtrees.
 *
 * The two methods are documented separately.
 *
 * @author George Matta
 * @author Matt Dong
 *
 * @version 1.0
 */
public interface BinaryTreeInterface<T> extends TreeInterface<T>{

    /**
     * Sets the data in the root of this binary tree.
     * @param rootData  The object that is the data for the tree's root.
     */
    public void setRootData(T rootData);

    /** Sets this binary tree to a new binary tree.
     * @param rootData   The object that is the data for the new tree's root.
     * @param leftTree   The left subtree of the new tree.
     * @param rightTree  The right subtree of the new tree.
     */
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                                   BinaryTreeInterface<T> rightTree);

} // end BinaryTreeInterface
