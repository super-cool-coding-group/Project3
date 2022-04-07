package src;

/**
 * This is the DriverBT which is a Driver for the BinaryTree and BinaryNode classes.
 *
 * This class has three methods: a main method, a createTree1 method, and a createTree2 method.
 *
 * The main method just runs through the entire program: it creates a tree, traverses it using post, pre, and in-order,
 * finds its height, finds the number of nodes it has, creates a second tree and runs through the whole process again, and creates
 * a tree using the special BinaryTree(inorder, preorder) constructor.
 *
 * This class is simply to showcase the functionality of the BinaryTree and BinaryNode classes.
 *
 * @author Angelica Arteaga
 * @author Pierlorenzo Peruzzo
 * @author George Matta
 *
 * @version 3.0
 */
public class DriverBT{

	public static void main(String[] args){

		System.out.println("1st Testing Example:");
		BinaryTree<String> aTree = new BinaryTree<>();
		createTree1(aTree);

		System.out.print("(binaryTree) post-order: ");
		aTree.postorderTraverse();

        System.out.println();

		System.out.print("(binaryNode) post-order: ");
		aTree.postorderTraverse_callBinaryNodeMethod();

		System.out.println();

		System.out.println("(BinaryTree) Height of tree is " + aTree.getHeight());
		System.out.println("(BinaryNode) Height of tree is " + aTree.getHeight_callBinaryNodeMethod());

		System.out.println();

		System.out.println("(BinaryTree) # nodes of tree is " + aTree.getNumberOfNodes());
		System.out.println("(BinaryNode) # nodes of tree is " + aTree.getNumberOfNodes_callBinaryNodeMethod());

		System.out.println("==========================================");
		System.out.println();

		System.out.println("2nd Testing Example:");
		BinaryTree<String> aTree2 = new BinaryTree<>();
		createTree2(aTree2);

		System.out.print("(binaryTree) post-order: ");
		aTree2.postorderTraverse();

        System.out.println();

		System.out.print("(binaryNode) post-order: ");
		aTree2.postorderTraverse_callBinaryNodeMethod();

		System.out.println();

		System.out.println("(BinaryTree) Height of tree is " + aTree2.getHeight());
		System.out.println("(BinaryNode) Height of tree is " + aTree2.getHeight_callBinaryNodeMethod());

		System.out.println();

		System.out.println("(BinaryTree) # nodes of tree is " + aTree2.getNumberOfNodes());
		System.out.println("(BinaryNode) # nodes of tree is " + aTree2.getNumberOfNodes_callBinaryNodeMethod());

		System.out.println();

		System.out.println("==========================================");

		System.out.println("\nTESTING EXTRA FEATURES (the tree construced is made using the special (preorder, inorder) constructor): \n");
        BinaryTree<String> bt = new BinaryTree<>("ABDHIECFGJK", "HDIBEAFCJGK");

		// Postorder traverse
		System.out.println("Testing Postorder Traverse:");
		System.out.print("\t(BinaryTree) ");
		bt.postorderTraverse();
		System.out.println();
		System.out.print("\t(BinaryNode) ");
		bt.getRootNode().postorderTraverse_binaryNodeMethod();
		System.out.println("\n");

		// Inorder Traverse
		System.out.println("Testing Inorder Traverse:");
		System.out.print("\t(BinaryTree) ");
		bt.inorderTraverse();
		System.out.println();
		System.out.print("\t(BinaryNode) ");
		bt.getRootNode().inorderTraverse_binaryNodeMethod();
		System.out.println("\n");

		// Preorder Traverse
		System.out.println("Testing Preorder Traverse:");
		System.out.print("\t(BinaryTree) ");
		bt.preorderTraverse();
		System.out.println();
		System.out.print("\t(BinaryNode) ");
		bt.getRootNode().preorderTraverse_binaryNodeMethod();
		System.out.println("\n");

        System.out.println("\nThe following tree was constructed using the special (preorder, inorder) constructor.\n");
        System.out.println("It is the same tree as the one created in createTree2.\nWe print out the postorder traversal of this tree.\n");
        BinaryTree<String> bt2 = new BinaryTree<>("ABCDFEGH", "BAFDCGEH");
        bt2.postorderTraverse();

        System.out.println("\n");

		System.out.println("==========================================");

		System.out.println("Done.");
	}  // end main

	public static void createTree1(BinaryTree<String> tree){
		// Leaves
		BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> gTree = new BinaryTree<>("G");

		// Subtrees:
		BinaryTree<String> fTree = new BinaryTree<>("F", null, gTree);
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, null);

		tree.setTree("A", bTree, cTree);

        System.out.println("\nGiven Tree:\n");
        System.out.println("     A      ");
        System.out.println("   /   \\  ");
        System.out.println("  B     C  ");
        System.out.println(" / \\   /  ");
        System.out.println("D   E  F   ");
        System.out.println("        \\ ");
        System.out.println("         G ");
        System.out.println();
	} // end createTree


	/**-------------------------------------------------------------------- */
	/**
     * Task 4: Create a tree case as shown in assignment 3
     */
	public static void createTree2(BinaryTree<String> tree){
		// Leaves:
		BinaryTree<String> bTree = new BinaryTree<>("B");
		BinaryTree<String> fTree = new BinaryTree<>("F");
		BinaryTree<String> gTree = new BinaryTree<>("G");
		BinaryTree<String> hTree = new BinaryTree<>("H");

		// Subtrees:
		BinaryTree<String> dTree = new BinaryTree<>("D", fTree, null);
		BinaryTree<String> eTree = new BinaryTree<>("E", gTree, hTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", dTree, eTree);

		tree.setTree("A", bTree, cTree);

		System.out.println("\nGiven Tree:\n");
        System.out.println("     A      ");
        System.out.println("   /   \\  ");
        System.out.println("  B     C  ");
        System.out.println("      /   \\ ");
        System.out.println("     D     E ");
        System.out.println("    /    /   \\ ");
        System.out.println("   F    G     H ");
        System.out.println();

	} // end createTree2

}  // end DriverBT
