package src;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * This is the testing class we use to test the methods we implemented for this project.
 *
 * We test the methods for both the BinaryTree and BinaryNode classes.
 *
 * The methods we are testing are the postorder traversal, preorder traversal, inorder traversal,
 * height calculation, node calculation, and the BinaryTree(preorder, inorder) constructor in the Binary Tree class.
 *
 * We use the JUnit testing framework to run these tests.
 *
 * @author Angelica Arteaga
 * @author George Matta
 */
public class BinaryMethodTests {

    BinaryTree<String> tree = new BinaryTree<String>();
    
    // BinaryTree objects
    // Leaves:
	BinaryTree<String> bTree = new BinaryTree<>("B");
	BinaryTree<String> fTree = new BinaryTree<>("F");
	BinaryTree<String> gTree = new BinaryTree<>("G");
	BinaryTree<String> hTree = new BinaryTree<>("H");

	// Subtrees:
	BinaryTree<String> dTree = new BinaryTree<>("D", fTree, null);
	BinaryTree<String> eTree = new BinaryTree<>("E", gTree, hTree);
	BinaryTree<String> cTree = new BinaryTree<>("C", dTree, eTree);

    //BinaryNode objects
    // Leaves:
    BinaryNode<String> bTreeNode = new BinaryNode<>("B");
    BinaryNode<String> fTreeNode = new BinaryNode<>("F");
    BinaryNode<String> gTreeNode = new BinaryNode<>("G");
    BinaryNode<String> hTreeNode = new BinaryNode<>("H");

    // Subtrees:
    BinaryNode<String> dTreeNode = new BinaryNode<>("D", fTreeNode, null);
    BinaryNode<String> eTreeNode = new BinaryNode<>("E", gTreeNode, hTreeNode);
    BinaryNode<String> cTreeNode = new BinaryNode<>("C", dTreeNode, eTreeNode);

    // Test Postorder traversal in BinaryTree
    @Test
    public void testPostorderTraverse(){
        tree.setTree("A", bTree, cTree);
        String expected = "BFDGHECA";
        String test = tree.postorderTraverse_test();
        assertEquals(expected, test);
    }

    // Test Postorder traversal in BinaryNode
    @Test
    public void testPostorderTraverse_callBinaryNodeMethod(){
        BinaryNode<String> tree = new BinaryNode<String>("A", bTreeNode, cTreeNode);
        String expected = "BFDGHECA";
        String test = tree.postorderTraverse_binaryNodeMethod_test();
        assertEquals(expected, test);
    }

    // Test Preorder traversal in BinaryTree
    @Test
    public void testPreorderTraverse(){
        tree.setTree("A", bTree, cTree);
        String expected = "ABCDFEGH";
        String test = tree.preorderTraverse_test();
        assertEquals(expected, test);
    }

    // Test Preorder traversal in BinaryNode
    @Test    
    public void testPreorderTraverse_callBinaryNodeMethod(){
        BinaryNode<String> tree = new BinaryNode<String>("A", bTreeNode, cTreeNode);
        String expected = "ABCDFEGH";
        String test = tree.preorderTraverse_binaryNodeMethod_test();
        assertEquals(expected, test);
    }

    // Test Inorder traversal in BinaryTree
    @Test
    public void testInorderTraverse(){
        tree.setTree("A", bTree, cTree);
        String expected = "BAFDCGEH";
        String test = tree.inorderTraverse_test();
        assertEquals(expected, test);
    }

    // Test Inorder traversal in BinaryNode
    @Test   
    public void testInorderTraverse_callBinaryNodeMethod(){
        BinaryNode<String> tree = new BinaryNode<String>("A", bTreeNode, cTreeNode);
        String expected = "BAFDCGEH";
        String test = tree.inorderTraverse_binaryNodeMethod_test();
        assertEquals(expected, test);
    }

    // Test height calculation in BinaryTree
        // test when height should be 0, 1, and any other number
    @Test
    public void testHeight(){
        // test height = 0
		BinaryTree<String> tree = new BinaryTree<>();
        int expected = 0;
        int test = tree.getHeight();
        assertEquals(expected, test);

        // test height = 1
        BinaryTree<String> tree2 = new BinaryTree<>("A");
        int expected2 = 1;
        int test2 = tree2.getHeight();
        assertEquals(expected2, test2);

        // test height = 4
        BinaryTree<String> tree3 = new BinaryTree<>();
        tree3.setTree("A", bTree, cTree);
        int expected3 = 4;
        int test3 = tree3.getHeight();
        assertEquals(expected3, test3);
    }

    // Test height calculation in BinaryNode
        // test when height should be 0, 1, and any other number.
        // also check a node that is within a tree but is not necessarily the root of the tree
    @Test
    public void testHeight_callBinaryNodeMethod(){
        BinaryTree<String> tree = new BinaryTree<>();
        int expected = 0;
        int test = tree.getHeight_callBinaryNodeMethod();
        assertEquals(expected, test);

        // test height = 1
        BinaryTree<String> tree2 = new BinaryTree<>("A");
        int expected2 = 1;
        int test2 = tree2.getHeight_callBinaryNodeMethod();
        assertEquals(expected2, test2);

        // test height = 4
        BinaryTree<String> tree3 = new BinaryTree<>();
        tree3.setTree("A", bTree, cTree);
        int expected3 = 4;
        int test3 = tree3.getHeight_callBinaryNodeMethod();
        assertEquals(expected3, test3);
        //System.out.print(test3);

        // test node

    }

    // Test node calculation in BinaryTree
        // same tests as height

    @Test
    public void testGetNumberOfNodes(){
        tree.setTree("A", bTree, cTree);
        int test = tree.getNumberOfNodes();
        int expected = 8;
        assertEquals(expected, test);
    }

    // Test node calculation in BinaryNode
    @Test
    public void testGetNumberOfNodes_callBinaryNodeMethod(){
        tree.setTree("A", bTree, cTree);
        int test = tree.getNumberOfNodes_callBinaryNodeMethod();
        int expected = 8;
        assertEquals(expected, test);
    }

    // Test BinaryTree(preorder, inorder) constructor
    @Test
    public void testBinaryTree(){
        BinaryTree<String> tree = new BinaryTree<String>("ABCDFEGH", "BAFDCGEH");
        String test = tree.postorderTraverse_test();
        String expected = "BFDGHECA";
        assertEquals(expected, test);
    }

}
