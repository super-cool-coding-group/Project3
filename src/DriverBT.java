package src;

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

		System.out.println("\nTESTING EXTRA FEATURES: \n");
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

	} // end createTree2

}  // end DriverBT
