public class BinaryTree<T> implements BinaryTreeInterface<T>{
    private BinaryNode<T> root;

    public BinaryTree(){
        root = null;
    } // end default constructor

    public BinaryTree(T rootData){
        root = new BinaryNode<>(rootData);
    } // end constructor

    public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree){
        initializeTree(rootData, leftTree, rightTree);
    } // end constructor

    /**
     * A constructor which takes preorder and inorder traversal Strings of a binary tree and uses that information
     * to construct the tree. This constructor calls the createTreeFromTraversals recursive method
     * @param preorder A String of the preorder traversal of the binary tree to be constructed
     * @param inorder A String of the inorder traversal of the binary tree to be constructed
     */
    @SuppressWarnings("unchecked")
    public BinaryTree(String preorder, String inorder){
        BinaryTree<String> createdTree = createTreeFromTraversals(preorder, inorder);
        root = ( (BinaryTree<T>) createdTree).getRootNode();
    }

    /**
     * A private recursive method that takes preorder and inorder traversal Strings for a binary tree and constructs the binary tree
     * @param preorder A String of the preorder traversal of the binary tree to be constructed
     * @param inorder A String of the inorder traversal of the binary tree to be constructed
     * @return The BinaryTree of Strings that we constructed from the traversal strings
     */
    private static BinaryTree<String> createTreeFromTraversals(String preorder, String inorder){
        // Basecase
        // Check that we have inorder and preorder strings. if we don't, then we are at a leaf, so we return null
        if(inorder.length() == 0 || preorder.length() == 0){
            return null;
        }

        // Get our root data from the preorder (it's always the first item in the preorder)
        // and find our root data in the inorder (to partition the node's left and right subtrees)
        String rootData = preorder.substring(0, 1);
        int inorderIndex = inorder.indexOf(rootData);

        // Partition the preorder string
        // For the left subtree, we partition from index 1 (we no longer care about the root index 0) to the index of the root + 1
        String preorderLeft = partitionTraversal(preorder, 1, inorderIndex + 1);
        // For the right subtree, we partition from the index of the root + 1 to the end of the preorder string
        String preorderRight = partitionTraversal(preorder, inorderIndex + 1, preorder.length());

        // Partition the inorder string
        // For left, we partition from 0 to the index of the root
        String inorderLeft = partitionTraversal(inorder, 0, inorderIndex);
        // For right, we partition from the index of the root + 1 to the end of the inorder string
        String inorderRight = partitionTraversal(inorder, inorderIndex + 1, inorder.length());

        // Create the left and right trees given the left and right partitions of our preorder and inorder strings
        // As stated in the basecase, if we end up not having one of the preorder or inorder strings, we would get null
        BinaryTree<String> leftTree = createTreeFromTraversals(preorderLeft, inorderLeft);
        BinaryTree<String> rightTree = createTreeFromTraversals(preorderRight, inorderRight);

        // Return the final binary tree, which ties together the root data to the left and right subtrees
        return new BinaryTree<String>(rootData, leftTree, rightTree);
    }

    /**
     * A private helper method for the recursive Binary Tree from Traversals constructor.
     * This method allows us to easily partition various traversal strings given a start and end index while maintaining
     * the assertsions that the start index is less than the end index, the start index is at least 0, and the end index is no greater
     * than the length of the traversal string.
     * This method basically just makes the necessary checks: if the checks fail, we return an empty string, if they don't, we just
     * use the built-in String.substring() method
     * @param traversal The traversal String we are partitioning
     * @param startInd The int starting index
     * @param endInd The int ending index
     * @return A substring of traversal from startInd to endInd (not inclusive), or an empty string if startInd is greater than endEnd,
     *          if startInd is less than 0, or if endInd is larger than the length of traversal
     */
    private static String partitionTraversal(String traversal, int startInd, int endInd){
        // Check if the start index is greater than the end index, if the start index is negative, or if the
        // end index is larger than the length of the traversal
        if(startInd > endInd || startInd < 0 || endInd > traversal.length()){
            // If any of those cases are true, we return an empty string, which will later get translated to a null node
            // which means we are at a leaf, or at a node which doesn't have either a left or a right subtree
            return "";
        }
        // Just a regular String.substring call - we already made all our sanitizary checks, so this shouldn't error
        return traversal.substring(startInd, endInd);
    }

    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree){
        initializeTree(rootData, (BinaryTree<T>)leftTree,
                                (BinaryTree<T>)rightTree);
    } // end setTree

    public void setRootData(T rootData){
        root.setData(rootData);
    } // end setRootData

    public T getRootData(){
        if (isEmpty())
            throw new EmptyTreeException();
        else
            return root.getData();
    } // end getRootData

    public boolean isEmpty(){
        return root == null;
    } // end isEmpty

    public void clear(){
        root = null;
    } // end clear

    protected void setRootNode(BinaryNode<T> rootNode){
        root = rootNode;
    } // end setRootNode

    protected BinaryNode<T> getRootNode(){
        return root;
    } // end getRootNode

    private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree){
        root = new BinaryNode<>(rootData);

        if ((leftTree != null) && !leftTree.isEmpty())
            root.setLeftChild(leftTree.root);

        if ((rightTree != null) && !rightTree.isEmpty())
        {
            if (rightTree != leftTree)
                root.setRightChild(rightTree.root);
            else
                root.setRightChild(rightTree.root.copy());
        } // end if

        if ((leftTree != null) && (leftTree != this))
            leftTree.clear();

        if ((rightTree != null) && (rightTree != this))
            rightTree.clear();
    } // end initializeTree


    /** -------------------------------------------------------------------- */
    /** Task 1: Implement the 4 methods
     *     . In BinaryTree.java
     *          1. public void postorderTraverse();
     *          2. private void postorderTraverse(BinaryNode<T> node)
     *          3. public void postorderTraverse_callBinaryNodeMethod()
     *     . In BinaryNode.java
     *          4. public void postorderTraverse_binaryNodeMethod()
     */

    /**
     * Calls postorderTraverse(BinaryNode<T> node)
     * prints (using post-order traversal) all nodes in the "whole" tree
     */
    public void postorderTraverse(){
        postorderTraverse(root);
    }

    /**
     * Calls preorderTraverse(BinaryNode<T> node)
     * prints (using pre-order traversal) all nodes in the "whole" tree
     */
    public void preorderTraverse(){
        preorderTraverse(root);
    }

    /**
     * Calls inorderTraverse(BinaryNode<T> node)
     * prints (using in-order traversal) all nodes in the "whole" tree
     */
    public void inorderTraverse(){
        inorderTraverse(root);
    }

    /**
     * A Recursive Method in the BinaryTree Class
     * prints (using post-order traversal) all nodes in the subtree rooted at this node.
     */
    private void postorderTraverse(BinaryNode<T> node){
        if (node == null) {
            return;
        }

        postorderTraverse(node.getLeftChild());
        postorderTraverse(node.getRightChild());
        System.out.print(node.getData());
    }

    /**
     * A Recursive Method in the BinaryTree Class
     * prints (using pre-order traversal) all nodes in the subtree rooted at this node.
     */
    private void preorderTraverse(BinaryNode<T> node){
        if (node == null) {
            return;
        }

        // postorderTraverse(node.getLeftChild());
        // postorderTraverse(node.getRightChild());
        // System.out.print(node.getData());
    }

    /**
     * A Recursive Method in the BinaryTree Class
     * prints (using in-order traversal) all nodes in the subtree rooted at this node.
     */
    private void inorderTraverse(BinaryNode<T> node){
        if (node == null) {
            return;
        }

        // postorderTraverse(node.getLeftChild());
        // postorderTraverse(node.getRightChild());
        // System.out.print(node.getData());
    }

    /**
     * The following calls postorderTraverse_binaryNodeMethod(), which is a recursive binaryNode class method
     * prints (using post-order traversal) all nodes in the "whole" tree
     */
    public void postorderTraverse_callBinaryNodeMethod(){
        if(root != null)
            root.postorderTraverse_binaryNodeMethod();
    }

    /**
     * The following calls preorderTraverse_binaryNodeMethod(), which is a recursive binaryNode class method
     * prints (using pre-order traversal) all nodes in the "whole" tree
     */
    public void preorderTraverse_callBinaryNodeMethod(){
        if(root != null)
            root.preorderTraverse_binaryNodeMethod();
    }

    /**
     * The following calls inorderTraverse_binaryNodeMethod(), which is a recursive binaryNode class method
     * prints (using in-order traversal) all nodes in the "whole" tree
     */
    public void inorderTraverse_callBinaryNodeMethod(){
        if(root != null)
            root.inorderTraverse_binaryNodeMethod();
    }


    /** -------------------------------------------------------------------- */
    /**
     * Task 2: Implement the 2 methods
     *     . In BinaryTree.java
     *          1. public int getHeight_callBinaryNodeMethod()
     *     . In BinaryNode.java
     *          2. public int getHeight_binaryNodeMethod()
     */

    /**
     * Calls getHeight(BinaryNode<T> node)
     * @return  The height of the "whole" tree
     */
    public int getHeight(){
        return getHeight(root);
    } // end getHeight

    /**
     * A Recursive Method in the BinaryTree Class
     * Computes the height of the subtree rooted at this node.
     * @return  The height of the subtree rooted at this node.
     */
    private int getHeight(BinaryNode<T> node){
        int height = 0;
        if (node != null)
            height = 1 + Math.max(getHeight(node.getLeftChild()),
                                getHeight(node.getRightChild()));
        return height;
    } // end getHeight

    /**
     * The following calls getHeight_binaryNodeMethod() which is a recursive binaryNode class method
     * Computes the height of the "whole" tree.
     * @return  The height of the "whole" tree.
     */
    public int getHeight_callBinaryNodeMethod(){
        int height = 0;
        if (root != null)
            height = root.getHeight_binaryNodeMethod();
        return height;
    } // end getHeight_callBinaryNodeMethod


    /** -------------------------------------------------------------------- */
    /** Task 3: Implement the 2 methods
        *     . In BinaryTree.java
        *          1. public int getNumberOfNodes()
        *          2. private int getNumberOfNodes(BinaryNode<T> node)*/

    /**
     * Calls getNumberOfNodes(BinaryNode<T> node)
     * @return The number of nodes in the "whole" tree
     */
    public int getNumberOfNodes(){
        return getNumberOfNodes(root);
    } // end getNumberOfNodes

    /**
     * A Recursive Method in the BinaryTree Class
     * Counts the nodes in the subtree rooted at this node.
     * @return The number of nodes in the subtree rooted at this node.
     */
    private int getNumberOfNodes(BinaryNode<T> node){
        int numberOfNodes = 0;
        if(node != null){
            numberOfNodes++; // We add one node for the current node
            numberOfNodes += getNumberOfNodes(node.getLeftChild()); // We get the nodes at the left subtree
            numberOfNodes += getNumberOfNodes(node.getRightChild()); // We get the nodes at the right subtree
        }
        return numberOfNodes; // We return the number of nodes
    } // end getNumberOfNodes

    /**
     * The following calls getNumberOfNodes_binaryNodeMethod() which is a recursive binaryNode class method
     * Counts the nodes in the "whole" tree
     * @return The number of nodes in the "whole" tree.
     */
    public int getNumberOfNodes_callBinaryNodeMethod(){
        int numberOfNodes = 0;
        if (root != null)
            numberOfNodes = root.getNumberOfNodes_binaryNodeMethod();
        return numberOfNodes;
    } // end getNumberOfNodes_callBinaryNodeMethod

} // end BinaryTree
