package src;

/**
 * This is the BinaryNode class which containts the definition of a single BinaryNode which can be connected to
 * two (2) more BinaryNode objects - a left and a right subnode/child. This serves to create a full Binary Tree.
 *
 * Each BinaryNode has data, and can have a left child and a right child.
 *
 * The BinaryTree class only has a reference to a single root datapoint, which is a BinaryNode.
 * (The BinaryTree class is documented separately)
 *
 * Through a BinaryNode, one could get the height of a subtree rooted at a node, the number of nodes for that subtree,
 * and a postorder, preorder, and inorder traversal of the subtree.
 *
 * All of these methods are recursive and are documented separately.
 *
 * @author George Matta
 * @author Pierlorenzo Peruzzo
 * @author Matt Dong
 *
 * @version 2.0
 */
class BinaryNode<T> {

    /**
     * The private field containing the generic T type data of the node
     */
    private T data;

    /**
     * The BinaryNode object for the left child
     */
    private BinaryNode<T> leftChild; // Reference to left child

    /**
     * The BinaryNode object for the right child
     */
    private BinaryNode<T> rightChild; // Reference to right child

    /**
     * A default constructor which calls the constructor BinaryNode(T) by passing in a null value.
     */
    public BinaryNode() {
        this(null); // Call next constructor
    } // end default constructor

    /**
     * This constructor takes a generic piece of data and constructs a BinaryNode whose data is the data passed
     * but the node has no left or right subnodes (so it is a leaf node)
     *
     * This constructor simply calls the BinaryNode(T, BinaryNode, BinaryNode) constructor but passes null for the left and right nodes.
     *
     * @param dataPortion The generic data held in the current node
     */
    public BinaryNode(T dataPortion) {
        this(dataPortion, null, null); // Call next constructor
    } // end constructor

    /**
     * A more complicated constructor, this constructor takes the data for the current node as well as a left and right node.
     * These two subnodes can be null to signify that a node doesn't have a right or a left subnode.
     *
     * @param dataPortion The generic data held in the current node
     * @param newLeftChild The left sub-BinaryNode object
     * @param newRightChild The right sub-BinaryNode object
     */
    public BinaryNode(T dataPortion, BinaryNode<T> newLeftChild, BinaryNode<T> newRightChild) {
        data = dataPortion;
        leftChild = newLeftChild;
        rightChild = newRightChild;
    } // end constructor

    /**
     * Retrieves the data portion of this node.
     *
     * @return The object in the data portion of the node.
     */
    public T getData() {
        return data;
    } // end getData

    /**
     * Sets the data portion of this node.
     *
     * @param newData The data object.
     */
    public void setData(T newData) {
        data = newData;
    } // end setData

    /**
     * Retrieves the left child of this node.
     *
     * @return A reference to this node's left child.
     */
    public BinaryNode<T> getLeftChild() {
        return leftChild;
    } // end getLeftChild

    /**
     * Sets this node’s left child to a given node.
     *
     * @param newLeftChild A node that will be the left child.
     */
    public void setLeftChild(BinaryNode<T> newLeftChild) {
        leftChild = newLeftChild;
    } // end setLeftChild

    /**
     * Detects whether this node has a left child.
     *
     * @return True if the node has a left child.
     */
    public boolean hasLeftChild() {
        return leftChild != null;
    } // end hasLeftChild

    /**
     * Retrieves the right child of this node.
     *
     * @return A reference to this node's right child.
     */
    public BinaryNode<T> getRightChild() {
        return rightChild;
    } // end getRightChild

    /**
     * Sets this node’s right child to a given node.
     *
     * @param newRightChild A node that will be the right child.
     */
    public void setRightChild(BinaryNode<T> newRightChild) {
        rightChild = newRightChild;
    } // end setRightChild

    /**
     * Detects whether this node has a right child.
     *
     * @return True if the node has a right child.
     */
    public boolean hasRightChild() {
        return rightChild != null;
    } // end hasRightChild

    /**
     * Detects whether this node is a leaf.
     *
     * @return True if the node is a leaf.
     */
    public boolean isLeaf() {
        return (leftChild == null) && (rightChild == null);
    } // end isLeaf

    /**
     * A Recursion Example in the BinaryNode Class
     * Copies the subtree rooted at this node.
     *
     * @return The root of a copy of the subtree rooted at this node.
     */
    public BinaryNode<T> copy() {
        BinaryNode<T> newRoot = new BinaryNode<>(data);
        if (leftChild != null)
            newRoot.setLeftChild(leftChild.copy());

        if (rightChild != null)
            newRoot.setRightChild(rightChild.copy());

        return newRoot;
    } // end copy

    /* -------------------------------------------------------------------- */
    /*
     * Part of Task 1
     */

    /**
     * A Recursive Method in the BinaryNode Class
     * prints (using post-order traversal) all nodes of the subtree rooted at "this"
     * node
     */
    public void postorderTraverse_binaryNodeMethod() {
        postorderTraverse_binaryNodeMethod(this);
    }

    /**
     * A Recursive Method in the BinaryNode Class
     * prints (using pre-order traversal) all nodes of the subtree rooted at "this"
     * node
     */
    public void preorderTraverse_binaryNodeMethod() {
        preorderTraverse_binaryNodeMethod(this);
    }

    /**
     * A Recursive Method in the BinaryNode Class
     * prints (using in-order traversal) all nodes of the subtree rooted at "this"
     * node
     */
    public void inorderTraverse_binaryNodeMethod() {
        inorderTraverse_binaryNodeMethod(this);
    }

    /**
     * A Recursive Method in the BinaryNode Class
     * prints (using post-order traversal) all nodes of the subtree rooted at "this"
     * node
     *
     * @param node The node we are printing the traversal for
     */
    public void postorderTraverse_binaryNodeMethod(BinaryNode<T> node) {

        if (node == null) {
            return;
        }

        postorderTraverse_binaryNodeMethod(node.getLeftChild());
        postorderTraverse_binaryNodeMethod(node.getRightChild());
        System.out.print(node.getData());
    }

    /**
     * A Recursive Method in the BinaryNode Class
     * prints (using pre-order traversal) all nodes of the subtree rooted at "this"
     * node
     *
     * @param node The node we are printing the traversal for
     */
    public void preorderTraverse_binaryNodeMethod(BinaryNode<T> node) {

        if (node == null) {
            return;
        }

        System.out.print(node.getData());
        preorderTraverse_binaryNodeMethod(node.getLeftChild());
        preorderTraverse_binaryNodeMethod(node.getRightChild());
    }

    /**
     * A Recursive Method in the BinaryNode Class
     * prints (using in-order traversal) all nodes of the subtree rooted at "this"
     * node
     *
     * @param node The node we are printing the traversal for
     */
    public void inorderTraverse_binaryNodeMethod(BinaryNode<T> node) {

        if (node == null) {
            return;
        }

        inorderTraverse_binaryNodeMethod(node.getLeftChild());
        System.out.print(node.getData());
        inorderTraverse_binaryNodeMethod(node.getRightChild());
    }

    // #region Test Traverse

    /**
     * A Recursive Method in the BinaryNode Class
     * prints (using post-order traversal) all nodes of the subtree rooted at "this"
     * node.
     * This method is for testing purpose only.
     *
     * @return A String denoting the postorder traversal of this node.
     */
    protected String postorderTraverse_binaryNodeMethod_test() {
        return postorderTraverse_binaryNodeMethod_test(this);
    }

    /**
     * A Recursive Method in the BinaryNode Class
     * prints (using pre-order traversal) all nodes of the subtree rooted at "this"
     * node.
     * This method is for testing purpose only.
     *
     * @return A String denoting the preorder traversal of this node.
     */
    protected String preorderTraverse_binaryNodeMethod_test() {
        return preorderTraverse_binaryNodeMethod_test(this);
    }

    /**
     * A Recursive Method in the BinaryNode Class
     * prints (using in-order traversal) all nodes of the subtree rooted at "this"
     * node.
     * This method is for testing purpose only.
     *
     * @return A String denoting the inorder traversal of this node.
     */
    protected String inorderTraverse_binaryNodeMethod_test() {
        return inorderTraverse_binaryNodeMethod_test(this);
    }

    /**
     * A Recursive Method in the BinaryNode Class
     * prints (using post-order traversal) all nodes of the subtree rooted at "this"
     * node.
     * This method is for testing purpose only.
     *
     * @param node The node we are printing the traversal for
     * @return A String denoting the postorder traversal of the passed node.
     */
    private String postorderTraverse_binaryNodeMethod_test(BinaryNode<T> node) {

        if (node == null) {
            return "";
        }

        return postorderTraverse_binaryNodeMethod_test(node.getLeftChild()) +
                postorderTraverse_binaryNodeMethod_test(node.getRightChild()) +
                node.getData().toString();
    }

    /**
     * A Recursive Method in the BinaryNode Class
     * prints (using pre-order traversal) all nodes of the subtree rooted at "this"
     * node.
     * This method is for testing purpose only.
     *
     * @param node The node we are printing the traversal for
     * @return A String denoting the preorder traversal of the passed node.
     */
    private String preorderTraverse_binaryNodeMethod_test(BinaryNode<T> node) {

        if (node == null) {
            return "";
        }

        return node.getData().toString() +
                preorderTraverse_binaryNodeMethod_test(node.getLeftChild()) +
                preorderTraverse_binaryNodeMethod_test(node.getRightChild());
    }

    /**
     * A Recursive Method in the BinaryNode Class
     * prints (using in-order traversal) all nodes of the subtree rooted at "this"
     * node.
     * This method is for testing purpose only.
     *
     * @param node The node we are printing the traversal for
     * @return A String denoting the inorder traversal of the passed node.
     */
    private String inorderTraverse_binaryNodeMethod_test(BinaryNode<T> node) {

        if (node == null) {
            return "";
        }

        return inorderTraverse_binaryNodeMethod_test(node.getLeftChild()) +
                node.getData().toString() +
                inorderTraverse_binaryNodeMethod_test(node.getRightChild());
    }

    // #endregion

    /* -------------------------------------------------------------------- */
    /*
     * Part of Task 2
     */

    /**
     * A Recursive Method in the BinaryNode Class
     * Computes the height of the subtree rooted at "this" node.
     *
     * @return The height of the subtree rooted at "this" node.
     */
    public int getHeight_binaryNodeMethod() {
        int height = 0;
        int leftHeight = 0;
        int rightHeight = 0;
        if (this != null) {
            if (leftChild != null) {
                leftHeight = leftChild.getHeight_binaryNodeMethod();
            }
            if (rightChild != null) {
                rightHeight = rightChild.getHeight_binaryNodeMethod();
            }
            height = 1 + Math.max(leftHeight, rightHeight);
        }
        return height;
    } // end getHeight

    /* -------------------------------------------------------------------- */
    /**
     * A Recursive Method in the BinaryNode Class
     * Counts the nodes in the subtree rooted at "this" node.
     *
     * @return The number of nodes in the subtree rooted at "this" node.
     */
    public int getNumberOfNodes_binaryNodeMethod() {
        int leftNumber = 0;
        int rightNumber = 0;
        if (leftChild != null)
            leftNumber = leftChild.getNumberOfNodes_binaryNodeMethod();
        if (rightChild != null)
            rightNumber = rightChild.getNumberOfNodes_binaryNodeMethod();
        return 1 + leftNumber + rightNumber;
    } // end getNumberOfNodes

} // end BinaryNode
