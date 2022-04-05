package src;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

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

    // Leaves:
	BinaryTree<String> bTree = new BinaryTree<>("B");
	BinaryTree<String> fTree = new BinaryTree<>("F");
	BinaryTree<String> gTree = new BinaryTree<>("G");
	BinaryTree<String> hTree = new BinaryTree<>("H");

	// Subtrees:
	BinaryTree<String> dTree = new BinaryTree<>("D", fTree, null);
	BinaryTree<String> eTree = new BinaryTree<>("E", gTree, hTree);
	BinaryTree<String> cTree = new BinaryTree<>("C", dTree, eTree);

    // Test Postorder traversal in BinaryTree
    @Test
    public void testPostorderTraverse() throws Exception {

        tree.setTree("A", bTree, cTree);


    }

    // Test Postorder traversal in BinaryNode
    @Test
    public void testPostorderTraverse_callBinaryNodeMethod(){

    }

    // Test Preorder traversal in BinaryTree
    @Test
    public void testPreorderTraverse(){

    }

    // Test Preorder traversal in BinaryNode
    @Test    
    public void testPreorderTraverse_callBinaryNodeMethod(){
    
    }

    // Test Inorder traversal in BinaryTree
    @Test
    public void testInorderTraverse(){

    }

    // Test Inorder traversal in BinaryNode
    @Test   
    public void testInorderTraverse_callBinaryNodeMethod(){

    }

    // Test height calculation in BinaryTree
        // test when height should be 0, 1, and any other number

    @Test
    public void testHeight(){

    }

    // Test height calculation in BinaryNode
        // test when height should be 0, 1, and any other number.
        // also check a node that is within a tree but is not necessarily
    @Test
    public void testHeight_callBinaryNodeMethod(){

    }

    // Test node calculation in BinaryTree
        // same tests as height

    @Test
    public void testNode(){

    }
    // Test node calculation in BinaryNode
    @Test
    public void testNode_callBinaryNodeMethod(){

    }

    // Test BinaryTree(preorder, inorder) constructor
    @Test
    public void testBinaryTree(){

    }

}
